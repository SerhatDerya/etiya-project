package com.etiya.catalogservice.service.mappings;

import com.etiya.catalogservice.domain.entities.Catalog;
import com.etiya.catalogservice.service.requests.CreateCatalogRequest;
import com.etiya.catalogservice.service.responses.catalog.CreatedCatalogResponse;
import com.etiya.catalogservice.service.responses.catalog.GetListCatalogResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CatalogMapper {
    CatalogMapper INSTANCE = Mappers.getMapper(CatalogMapper.class);

    @Mapping(target = "parent.id", source = "parentId")
    Catalog catalogFromCreateCatalogRequest(CreateCatalogRequest request);

    @Mapping(target = "parentId", source = "parent.id")
    CreatedCatalogResponse createdCatalogResponseFromCatalog(Catalog catalog);

    @Mapping(target = "parentId", source = "parent.id")
    GetListCatalogResponse getListCatalogResponseFromCatalog(Catalog catalogs);
    List<GetListCatalogResponse> getListCatalogResponseFromCatalog(List<Catalog> catalogs);
}
