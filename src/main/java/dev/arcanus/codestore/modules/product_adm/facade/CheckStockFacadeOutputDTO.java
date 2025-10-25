package dev.arcanus.codestore.modules.product_adm.facade;

public record CheckStockFacadeOutputDTO(
        Long productId,
        Integer stock
) {
}
