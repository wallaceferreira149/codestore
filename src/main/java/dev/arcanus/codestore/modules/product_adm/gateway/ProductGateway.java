package dev.arcanus.codestore.modules.product_adm.gateway;

import dev.arcanus.codestore.modules.product_adm.domain.entity.Product;
import dev.arcanus.codestore.modules.shared.domain.valueobject.Id;

import java.util.List;

public interface ProductGateway {
    Product add(Product product);
    Product find(Long id);
    List<Product> listAll();
}
