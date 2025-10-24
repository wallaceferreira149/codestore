package dev.arcanus.codestore.modules.product_adm.useCases.findProduct;

import java.time.Instant;

public record FindedProductDTO(
    Long id,
    String name,
    String description,
    Double price,
    Integer stock,
    Instant createdAt,
    Instant updatedAt
) {
}
