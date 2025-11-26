package com.etiya.searchservice.configuration;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class CustomerSearchIndexInitializer {

    private static final Logger log = LoggerFactory.getLogger(CustomerSearchIndexInitializer.class);
    private static final String INDEX_NAME = "customer-searches";

    private final ElasticsearchOperations elasticsearchOperations;

    public CustomerSearchIndexInitializer(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    @PostConstruct
    public void createCustomerSearchIndex() {
        IndexCoordinates index = IndexCoordinates.of(INDEX_NAME);
        IndexOperations indexOps = elasticsearchOperations.indexOps(index);

        // Eğer aynı isimde index varsa, yeniden oluşturma
        if (indexOps.exists()) {
            log.info("✅ Elasticsearch index '{}' zaten mevcut, yeniden oluşturulmayacak.", INDEX_NAME);
            return;
        }

        // Eğer başka gereksiz index'ler varsa, onları kaldır (opsiyonel)
        cleanupOtherIndices(INDEX_NAME);

        // ---- contactMediums mapping ----
        Map<String, Object> contactMediumProps = new HashMap<>();
        contactMediumProps.put("id", Map.of("type", "keyword"));
        contactMediumProps.put("email", Map.of("type", "keyword"));
        contactMediumProps.put("homePhone", Map.of("type", "keyword"));
        contactMediumProps.put("mobilePhone", Map.of("type", "keyword"));
        contactMediumProps.put("fax", Map.of("type", "keyword"));
        contactMediumProps.put("customerId", Map.of("type", "keyword"));

        Map<String, Object> contactMediumMapping = new HashMap<>();
        contactMediumMapping.put("type", "nested");
        contactMediumMapping.put("properties", contactMediumProps);

        // ---- billingAccountSearches mapping ----
        Map<String, Object> billingProps = new HashMap<>();
        billingProps.put("id", Map.of("type", "keyword"));
        billingProps.put("accountNumber", Map.of("type", "keyword"));
        billingProps.put("accountName", Map.of("type", "text"));
        billingProps.put("statusId", Map.of("type", "keyword"));
        billingProps.put("typeId", Map.of("type", "keyword"));
        billingProps.put("customerId", Map.of("type", "keyword"));

        Map<String, Object> billingMapping = new HashMap<>();
        billingMapping.put("type", "nested");
        billingMapping.put("properties", billingProps);

        // ---- addressSearches mapping ----
        Map<String, Object> addressProps = new HashMap<>();
        addressProps.put("id", Map.of("type", "keyword"));
        addressProps.put("title", Map.of("type", "text"));
        addressProps.put("street", Map.of("type", "text"));
        addressProps.put("houseNumber", Map.of("type", "keyword"));
        addressProps.put("description", Map.of("type", "text"));
        addressProps.put("isDefault", Map.of("type", "boolean"));
        addressProps.put("customerId", Map.of("type", "keyword"));
        addressProps.put("cityId", Map.of("type", "keyword"));
        addressProps.put("cityName", Map.of("type", "text"));

        Map<String, Object> addressMapping = new HashMap<>();
        addressMapping.put("type", "nested");
        addressMapping.put("properties", addressProps);

        // ---- main properties ----
        Map<String, Object> props = new HashMap<>();
        props.put("id", Map.of("type", "keyword"));
        props.put("customerNumber", Map.of("type", "keyword"));
        props.put("firstName", Map.of("type", "text"));
        props.put("lastName", Map.of("type", "text"));
        props.put("natId", Map.of("type", "keyword"));
        props.put("dateOfBirth", Map.of("type", "date"));
        props.put("contactMediums", contactMediumMapping);
        props.put("billingAccountSearches", billingMapping);
        props.put("addressSearches", addressMapping);

        Map<String, Object> mappings = new HashMap<>();
        mappings.put("properties", props);

        Map<String, Object> settings = new HashMap<>();
        settings.put("number_of_shards", 1);
        settings.put("number_of_replicas", 0);

        // ---- index oluştur ----
        Document settingsDocument = Document.from(settings);
        Document mappingsDocument = Document.from(mappings);

        indexOps.create(settingsDocument);
        indexOps.putMapping(mappingsDocument);

        log.info("✅ Elasticsearch index '{}' başarıyla oluşturuldu.", INDEX_NAME);
    }

    /**
     * Eğer başka index’ler varsa, kaldırmak için opsiyonel bir temizlik metodu.
     */
    private void cleanupOtherIndices(String keepIndexName) {
        try {
            Set<String> allIndices = elasticsearchOperations.indexOps(IndexCoordinates.of("_all")).getAliases().keySet();
            for (String idx : allIndices) {
                if (!idx.equals(keepIndexName)) {
                    log.info("🧹 '{}' index’i kaldırılıyor...", idx);
                    elasticsearchOperations.indexOps(IndexCoordinates.of(idx)).delete();
                }
            }
        } catch (Exception e) {
            log.warn("⚠️ Diğer index’leri temizlerken hata oluştu: {}", e.getMessage());
        }
    }
}


