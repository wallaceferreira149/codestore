package dev.arcanus.codestore.modules.product_adm.useCases.addProduct;

public record AddProductDTO(
    String name,
    String description,
    double price,
    int stock
) {}