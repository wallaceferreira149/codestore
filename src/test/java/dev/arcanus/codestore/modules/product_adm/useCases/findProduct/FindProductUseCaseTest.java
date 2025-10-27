package dev.arcanus.codestore.modules.product_adm.useCases.findProduct;

import dev.arcanus.codestore.modules.product_adm.domain.entity.Product;
import dev.arcanus.codestore.modules.product_adm.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.AssertionsKt.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindProductUseCaseTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private FindProductUseCase useCase;

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

    }

    @Test
    @DisplayName("Deve encontrar um produto pelo ID com sucesso")
    void shouldFindProductByIdSuccessfullyWhenIdExists() {
        when(productRepository.find(1L)).thenReturn(validProduct);
        FindedProductDTO findedProduct = this.useCase.execute(1L);
        assertNotNull(findedProduct);
        assertEquals(validProduct.getId(), findedProduct.id());
        assertEquals(validProduct.getName(), findedProduct.name());
    }

}
