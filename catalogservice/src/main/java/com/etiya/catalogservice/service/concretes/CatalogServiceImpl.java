package com.etiya.catalogservice.service.concretes;

import com.etiya.catalogservice.domain.entities.Catalog;
import com.etiya.catalogservice.repository.CatalogRepository;
import com.etiya.catalogservice.service.abstracts.CatalogService;
import com.etiya.catalogservice.service.mappings.CatalogMapper;
import com.etiya.catalogservice.service.requests.CreateCatalogRequest;
import com.etiya.catalogservice.service.responses.catalog.CreatedCatalogResponse;
import com.etiya.catalogservice.service.responses.catalog.GetListCatalogResponse;
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
