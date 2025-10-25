package dev.arcanus.codestore.modules.product_adm.facade;

import dev.arcanus.codestore.modules.product_adm.useCases.addProduct.AddProductDTO;
import dev.arcanus.codestore.modules.product_adm.useCases.addProduct.AddProductUseCase;
import dev.arcanus.codestore.modules.product_adm.useCases.addProduct.AddedProductDTO;
import dev.arcanus.codestore.modules.product_adm.useCases.checkStock.CheckStockUseCase;
import dev.arcanus.codestore.modules.product_adm.useCases.checkStock.CheckStockUseCaseOutputDto;

public class ProductAdmFacade implements ProductAdmFacadeGateway {

    private final AddProductUseCase addProductUseCase;
    private final CheckStockUseCase checkStockUseCase;

    public ProductAdmFacade(
            AddProductUseCase addProductUseCase,
            CheckStockUseCase checkStockUseCase
    ) {
        this.addProductUseCase = addProductUseCase;
        this.checkStockUseCase = checkStockUseCase;
    }

    @Override
    public Long addProduct(AddProductFacadeInputDTO input) {
        AddProductDTO dto = new AddProductDTO(
                input.name(),
                input.description(),
                input.price(),
                input.stock()
        );
        AddedProductDTO addedProduct = (AddedProductDTO) this.addProductUseCase.execute(dto);

        return addedProduct.id();
    }

    @Override
    public CheckStockFacadeOutputDTO checkStock(Long productId) {
        CheckStockUseCaseOutputDto outputUseCaseDto = (CheckStockUseCaseOutputDto) this.checkStockUseCase.execute(productId);
        return new CheckStockFacadeOutputDTO(
                outputUseCaseDto.productId(),
                outputUseCaseDto.stock()
        );
    }
}
