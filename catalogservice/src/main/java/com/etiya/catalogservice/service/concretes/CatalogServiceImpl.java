package com.etiya.catalogservice.service.concretes;

import com.etiya.catalogservice.domain.entities.Catalog;
import com.etiya.catalogservice.repository.CatalogRepository;
import com.etiya.catalogservice.service.abstracts.CatalogService;
import com.etiya.catalogservice.service.mappings.CatalogMapper;
import com.etiya.catalogservice.service.requests.CreateCatalogRequest;
import com.etiya.catalogservice.service.responses.catalog.CreatedCatalogResponse;
import com.etiya.catalogservice.service.responses.catalog.GetListCatalogResponse;
import com.etiya.common.crosscuttingconcerns.exceptions.types.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
    private final CatalogRepository catalogRepository;

    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public CreatedCatalogResponse add(CreateCatalogRequest request) {
        Catalog catalog = CatalogMapper.INSTANCE.catalogFromCreateCatalogRequest(request);

        // Parent ID varsa ve NULL değilse, veritabanından çek
        if (request.getParentId() != null) {
            Catalog parent = catalogRepository.findById(request.getParentId())
                    .orElseThrow(() -> new BusinessException("Parent catalog not found with id: " + request.getParentId()));
            catalog.setParent(parent);
        } else {
            // Parent yoksa (root catalog), null olarak bırak
            catalog.setParent(null);
        }

        Catalog result = catalogRepository.save(catalog);
        CreatedCatalogResponse response = CatalogMapper.INSTANCE.createdCatalogResponseFromCatalog(result);
        return response;
    }

    @Override
    public List<GetListCatalogResponse> getList() {
        List<Catalog> catalogs = catalogRepository.findAll();
        return CatalogMapper.INSTANCE.getListCatalogResponseFromCatalog(catalogs);
    }
}
