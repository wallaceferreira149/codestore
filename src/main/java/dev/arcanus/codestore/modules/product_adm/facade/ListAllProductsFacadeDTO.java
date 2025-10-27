package dev.arcanus.codestore.modules.product_adm.facade;

import dev.arcanus.codestore.modules.product_adm.domain.entity.Product;

import java.util.List;

public record ListAllProductsFacadeDTO(
        List<Product> products
) {
}
