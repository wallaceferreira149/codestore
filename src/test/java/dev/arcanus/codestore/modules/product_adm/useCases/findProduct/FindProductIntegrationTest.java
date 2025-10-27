package dev.arcanus.codestore.modules.product_adm.useCases.findProduct;

import dev.arcanus.codestore.modules.product_adm.domain.entity.Product;
import dev.arcanus.codestore.modules.product_adm.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.AssertionsKt.assertNotNull;

@SpringBootTest
public class FindProductIntegrationTest {

    @Autowired
    private FindProductUseCase useCase;

    @Autowired
    private ProductRepository repository;

    Product validProduct;

    @BeforeEach
    void setUp() {
        validProduct = new Product(
            1L,
            "Product Name",
            "Product Description",
            100.0,
            10
        );

        this.repository.add(validProduct);
    }

    @Test
    @DisplayName("Integração - Repository/Usecase - Deve encontrar um produto pelo ID com sucesso")
    void shouldFindProductByIdSuccessfullyWhenIdExists() {
        FindedProductDTO findedProduct = this.useCase.execute(1L);
        assertNotNull(findedProduct);
        assertEquals(validProduct.getId(), findedProduct.id());
    }
}
