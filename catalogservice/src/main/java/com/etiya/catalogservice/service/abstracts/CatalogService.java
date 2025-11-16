package com.etiya.catalogservice.service.abstracts;

import com.etiya.catalogservice.service.requests.CreateCatalogRequest;
import com.etiya.catalogservice.service.responses.catalog.CreatedCatalogResponse;
import com.etiya.catalogservice.service.responses.catalog.GetListCatalogResponse;

import java.util.List;

public interface CatalogService {
    CreatedCatalogResponse add(CreateCatalogRequest request);
    List<GetListCatalogResponse> getList();
}
