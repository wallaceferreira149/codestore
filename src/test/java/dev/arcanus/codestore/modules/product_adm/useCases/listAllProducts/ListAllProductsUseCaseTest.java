package dev.arcanus.codestore.modules.product_adm.useCases.listAllProducts;

import dev.arcanus.codestore.modules.product_adm.domain.entity.Product;
import dev.arcanus.codestore.modules.product_adm.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListAllProductsUseCaseTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ListAllProductsUseCase useCase;

    List<Product> products;

    @BeforeEach
    void setUp() {
        Product product1 = new Product(1L, "Produto 1", "Descrição 1", 10.0, 100);
        Product product2 = new Product(2L, "Produto 2", "Descrição 2", 20.0, 200);
        products = List.of(product1, product2);
    }

    @Test
    @DisplayName("Deve listar todos os produtos com sucesso")
    void shouldListAllProductsSuccessfully() {
        when(repository.listAll()).thenReturn(products);
        ProductListDto productsFound = useCase.execute();
        assertNotNull(productsFound);
        assertEquals(2, productsFound.products().size());
        assertEquals("Produto 1", productsFound.products().get(0).getName());
        assertEquals("Produto 2", productsFound.products().get(1).getName());
    }

}