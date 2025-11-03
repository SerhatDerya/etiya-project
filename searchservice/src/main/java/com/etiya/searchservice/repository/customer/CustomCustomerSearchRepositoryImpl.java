package com.etiya.searchservice.repository.customer;

import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import com.etiya.searchservice.domain.CustomerSearch;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@Repository
public class CustomCustomerSearchRepositoryImpl implements CustomCustomerSearchRepository {
    private final ElasticsearchOperations elasticsearchOperations;

    public CustomCustomerSearchRepositoryImpl(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    @Override
    public List<CustomerSearch> searchDynamic(String id, String accountNumber, String natId, String firstName, String lastName, String mobilePhone) {

        if (!StringUtils.hasText(id)
                && !StringUtils.hasText(accountNumber)
                && !StringUtils.hasText(natId)
                && !StringUtils.hasText(firstName)
                && !StringUtils.hasText(lastName)
                && !StringUtils.hasText(mobilePhone)) {
            return Collections.emptyList();
        }

        BoolQuery.Builder bool = QueryBuilders.bool();

        if (StringUtils.hasText(id)) {
            bool.must(m -> m.term(t -> t.field("id.keyword").value(id)));
        }

        if (StringUtils.hasText(mobilePhone)) {
            bool.must(m -> m.nested(n -> n
                    .path("contactMediums")
                    .query(nb -> nb.match(t -> t.field("contactMediums.mobilePhone").query(mobilePhone)))));
        }

        if (StringUtils.hasText(natId)) {
            bool.must(m -> m.term(t -> t.field("natId.keyword").value(natId)));
        }

        if (StringUtils.hasText(firstName)) {
            bool.must(m -> m.queryString(qs -> qs.fields("firstName").query("*" + firstName.toLowerCase() + "*")));
        }

        if (StringUtils.hasText(lastName)) {
            bool.must(m -> m.queryString(qs -> qs.fields("lastName").query("*" + lastName.toLowerCase() + "*")));
        }

        Query query = bool.build()._toQuery();
        NativeQuery nativeQuery = NativeQuery.builder().withQuery(query).build();

        SearchHits<CustomerSearch> hits = elasticsearchOperations.search(nativeQuery, CustomerSearch.class);
        return hits.stream().map(SearchHit::getContent).toList();


// ---------------------------------------------------------------------------------------------------------------------------------
//        if (StringUtils.hasText(accountNumber)) {
//            bool.must(m -> m.term(t -> t.field("customerNumber.keyword").value(accountNumber)));
//        }
// ---------------------------------------------------------------------------------------------------------------------------------
//        if (StringUtils.hasText(value)) {
//            bool.must(m -> m.nested(n -> n
//                    .path("contactMediums")
//                    .query(q -> q.bool(nb -> nb
//                            .must(mt -> mt.term(t -> t.field("contactMediums.type.keyword").value("PHONE"))) // sadece PHONE
//                            .must(mt -> mt.term(t -> t.field("contactMediums.value.keyword").value(value)))
//                    ))
//            ));
//        }
// ---------------------------------------------------------------------------------------------------------------------------------
//        if (StringUtils.hasText(mobilePhone)) {
//            bool.must(m -> m.nested(n -> n
//                    .path("contactMediumSearches")
//                    .query(q -> q.matchPhrase(t ->
//                            t.field("contactMediumSearches.mobilePhone")
//                                    .query(mobilePhone)
//                    ))
//            ));
//        }
// ---------------------------------------------------------------------------------------------------------------------------------

//        if (StringUtils.hasText(mobilePhone)) {
//            bool.must(m -> m.term(p -> p.field("contactMediums.mobilePhone.keyword").value(mobilePhone)));
//        }
//        if (StringUtils.hasText(mobilePhone)) {
//            bool.must(m -> m.nested(n -> n
//                    .path("contactMediums")
//                    .query(q -> q
//                            .term(t -> t.field("contactMediums.mobilePhone.keyword").value(mobilePhone))
//                    )
//            ));
//        }


    }
}
