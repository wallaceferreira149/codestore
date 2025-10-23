package dev.arcanus.codestore.modules.product_adm.gateway;

import dev.arcanus.codestore.modules.product_adm.domain.entity.Product;
import dev.arcanus.codestore.modules.shared.domain.valueobject.Id;

public interface ProductGateway {
    Product add(Product product);
    Product find(Id id);
}
