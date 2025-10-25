package dev.arcanus.codestore.modules.product_adm.facade;

public record AddProductFacadeInputDTO(
        String name,
        String description,
        Double price,
        Integer stock
) {
}
