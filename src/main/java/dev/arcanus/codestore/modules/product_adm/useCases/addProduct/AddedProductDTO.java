package dev.arcanus.codestore.modules.product_adm.useCases.addProduct;

import java.time.Instant;

public record AddedProductDTO(
    Long id,
    String name,
    String description,
    double price,
    int stock,
    Instant createdAt,
    Instant updatedAt
) {
    
}
