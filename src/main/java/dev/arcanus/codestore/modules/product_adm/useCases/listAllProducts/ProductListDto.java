package dev.arcanus.codestore.modules.product_adm.useCases.listAllProducts;

import dev.arcanus.codestore.modules.product_adm.domain.entity.Product;

import java.util.List;

public record ProductListDto(
        List<Product> products
) {
}
