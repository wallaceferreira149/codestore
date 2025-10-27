package dev.arcanus.codestore.modules.product_adm.facade;

public interface ProductAdmFacadeGateway {

    Long addProduct(AddProductFacadeInputDTO input);
    CheckStockFacadeOutputDTO checkStock(Long productId);
    ListAllProductsFacadeDTO listAllProducts();
}
