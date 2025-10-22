package dev.arcanus.codestore.modules.product_adm.use_case.add_product;

public record AddProductDTO(
    String name,
    String description,
    double price,
    int stock
) {}