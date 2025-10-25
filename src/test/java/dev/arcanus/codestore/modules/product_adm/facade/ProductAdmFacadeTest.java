package dev.arcanus.codestore.modules.product_adm.facade;

import dev.arcanus.codestore.modules.product_adm.domain.entity.Product;
import dev.arcanus.codestore.modules.product_adm.useCases.addProduct.AddProductDTO;
import dev.arcanus.codestore.modules.product_adm.useCases.addProduct.AddProductUseCase;
import dev.arcanus.codestore.modules.product_adm.useCases.addProduct.AddedProductDTO;
import dev.arcanus.codestore.modules.product_adm.useCases.checkStock.CheckStockUseCase;
import dev.arcanus.codestore.modules.product_adm.useCases.checkStock.CheckStockUseCaseOutputDto;
import dev.arcanus.codestore.modules.shared.domain.valueobject.Id;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductAdmFacadeTest {

    @Mock
    private AddProductUseCase addProductUseCase;

    @Mock
    private CheckStockUseCase checkStockUseCase;

    @InjectMocks
    private ProductAdmFacade productAdmFacade;

    AddProductFacadeInputDTO inputFacadeDTO;
    AddProductDTO productDto;
    AddedProductDTO addedProductDTO;
    Product productEntity;

    @BeforeEach
    void setUp() {
        inputFacadeDTO = new AddProductFacadeInputDTO(
                "Product 1",
                "Description 1",
                10.0,
                100
        );

        productDto = new AddProductDTO(
                inputFacadeDTO.name(),
                inputFacadeDTO.description(),
                inputFacadeDTO.price(),
                inputFacadeDTO.stock()
        );

        productEntity = new Product(
                new Id(1L),
                productDto.name(),
                productDto.description(),
                productDto.price(),
                productDto.stock()
        );

        addedProductDTO = new AddedProductDTO(
                1L,
                productDto.name(),
                productDto.description(),
                productDto.price(),
                productDto.stock(),
                Instant.now(),
                Instant.now()
        );
    }

    @Test
    @DisplayName("Deve adicionar um produto através da facade e retornar o id do produto adicionado")
    void shoudCallUseCaseAndSaveProductWhenAddProductFacedeIsCalled() {

        Product productCreated = new Product(
                new Id(1L),
                productEntity.getCreatedAt(),
                productEntity.getUpdatedAt(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                productEntity.getStock()
        );

        when(addProductUseCase.execute(productDto)).thenReturn(addedProductDTO);

        Long productAddedFromFacade = productAdmFacade.addProduct(inputFacadeDTO);

        assert(productAddedFromFacade.equals(addedProductDTO.id()));
        assert(productAddedFromFacade.equals(productCreated.getId().getId()));
        assertNotNull(productAddedFromFacade);
    }

    @Test
    @DisplayName("Deve retornar a quantidade em estoque através da facade quando o método checkStock for chamado com um id válido")
    void shouldReturnCallUseCaseWhenCheckStockIsCalledWithValidId() {

        CheckStockUseCaseOutputDto stockChecked = new CheckStockUseCaseOutputDto(1L, 100);

        when(checkStockUseCase.execute(1L)).thenReturn(stockChecked);

        CheckStockFacadeOutputDTO stockOutput = productAdmFacade.checkStock(1L);
        assertNotNull(stockOutput);
        assertEquals(1L, stockOutput.productId());
    }
}
