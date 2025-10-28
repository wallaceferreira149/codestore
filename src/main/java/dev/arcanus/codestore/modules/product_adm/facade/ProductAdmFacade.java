package dev.arcanus.codestore.modules.product_adm.facade;

import dev.arcanus.codestore.modules.product_adm.useCases.addProduct.AddProductDTO;
import dev.arcanus.codestore.modules.product_adm.useCases.addProduct.AddProductUseCase;
import dev.arcanus.codestore.modules.product_adm.useCases.addProduct.AddedProductDTO;
import dev.arcanus.codestore.modules.product_adm.useCases.checkStock.CheckStockUseCase;
import dev.arcanus.codestore.modules.product_adm.useCases.checkStock.CheckStockUseCaseOutputDto;
import dev.arcanus.codestore.modules.product_adm.useCases.listAllProducts.ListAllProductsUseCase;
import dev.arcanus.codestore.modules.product_adm.useCases.listAllProducts.ProductListDto;
import org.springframework.stereotype.Service;

@Service
public record ProductAdmFacade(AddProductUseCase addProductUseCase, CheckStockUseCase checkStockUseCase,
                               ListAllProductsUseCase listAllProductsUseCase) implements ProductAdmFacadeGateway {

    @Override
    public Long addProduct(AddProductFacadeInputDTO input) {
        AddProductDTO dto = new AddProductDTO(
                input.name(),
                input.description(),
                input.price(),
                input.stock()
        );
        AddedProductDTO addedProduct = this.addProductUseCase.execute(dto);

        return addedProduct.id();
    }

    @Override
    public CheckStockFacadeOutputDTO checkStock(Long productId) {
        CheckStockUseCaseOutputDto outputUseCaseDto = this.checkStockUseCase.execute(productId);
        return new CheckStockFacadeOutputDTO(
                outputUseCaseDto.productId(),
                outputUseCaseDto.stock()
        );
    }

    @Override
    public ListAllProductsFacadeDTO listAllProducts() {
        ProductListDto products = this.listAllProductsUseCase.execute();
        return new ListAllProductsFacadeDTO(products.products());
    }
}
