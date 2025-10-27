package dev.arcanus.codestore.modules.storeCatalog.application.useCases.listAll;

import dev.arcanus.codestore.modules.storeCatalog.domain.entities.Product;

import java.util.List;

public record ListAllProductsUseCaseDto(
        List<Product> products
) {
}
