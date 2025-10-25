package dev.arcanus.codestore.modules.product_adm.useCases.checkStock;

public record CheckStockUseCaseOutputDto(
        Long productId,
        Integer stock
) {
}
