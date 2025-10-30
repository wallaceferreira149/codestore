package dev.arcanus.codestore.modules.storeCatalog.domain.repository;

import dev.arcanus.codestore.modules.storeCatalog.domain.entities.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();
    Product productDetail(Long id);

}
