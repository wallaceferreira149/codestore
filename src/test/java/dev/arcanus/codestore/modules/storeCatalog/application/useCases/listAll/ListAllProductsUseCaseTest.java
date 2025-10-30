package dev.arcanus.codestore.modules.storeCatalog.application.useCases.listAll;

import dev.arcanus.codestore.modules.product_adm.domain.entity.Product;
import dev.arcanus.codestore.modules.product_adm.facade.ListAllProductsFacadeDTO;
import dev.arcanus.codestore.modules.product_adm.facade.ProductAdmFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.AssertionsKt.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListAllProductsUseCaseTest {

    @Mock
    private ProductAdmFacade productFacade;

    @InjectMocks
    private ListAllProductsUseCase listAllProductsUseCase;

    List<Product> products;
    Product productA;
    Product productB;

    @BeforeEach
    void setUp() {
        productA = new Product(
                1L,
                Instant.now(),
                Instant.now(),
                "Product 1",
                "Description 1",
                10.0,
                100
        );

        productB = new Product(
                2L,
                Instant.now(),
                Instant.now(),
                "Product 2",
                "Description 2",
                20.0,
                200
        );

    }

    @Test
    @DisplayName("Deve listar todos os produtos com sucesso")
    void shouldListAllProductsSuccessfully() {

        ListAllProductsFacadeDTO productsDto = new ListAllProductsFacadeDTO(List.of(productA, productB));
        when(this.productFacade.listAllProducts()).thenReturn(
                new ListAllProductsFacadeDTO(List.of(productA, productB))
        );

        ListAllProductsUseCaseDto allProductsDto = this.listAllProductsUseCase.execute();

        assertNotNull(allProductsDto);
        assertEquals(2, allProductsDto.products().size());
        assertEquals(productA.getId(), allProductsDto.products().get(0).getId());
        assertEquals(productB.getId(), allProductsDto.products().get(1).getId());
    }
}
