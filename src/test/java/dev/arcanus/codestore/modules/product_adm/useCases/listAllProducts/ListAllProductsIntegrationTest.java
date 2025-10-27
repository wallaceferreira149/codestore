package dev.arcanus.codestore.modules.product_adm.useCases.listAllProducts;

import dev.arcanus.codestore.modules.product_adm.domain.entity.Product;
import dev.arcanus.codestore.modules.product_adm.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class ListAllProductsIntegrationTest {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ListAllProductsUseCase useCase;

    List<Product> products;

    @BeforeEach
    void setUp() {
        Product product1 = new Product(1L, "Produto 1", "Descrição 1", 10.0, 100);
        this.repository.add(product1);
        Product product2 = new Product(2L, "Produto 2", "Descrição 2", 20.0, 200);
        this.repository.add(product2);
        products = List.of(product1, product2);
    }

    @Test
    @DisplayName("Integração - Repository/Usecase - Deve listar todos os produtos com sucesso")
    void shouldListAllProductsSuccessfully() {
        ProductListDto productsFound = useCase.execute();
        assertNotNull(productsFound);
        assert(productsFound.products().size() == 2);
        assertEquals(products.get(0).getName(), productsFound.products().get(0).getName());
        assertEquals(products.get(1).getName(), productsFound.products().get(1).getName());
        assertEquals(products.get(0).getId(), productsFound.products().get(0).getId());
    }

}
