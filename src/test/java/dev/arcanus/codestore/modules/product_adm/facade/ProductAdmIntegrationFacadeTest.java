package dev.arcanus.codestore.modules.product_adm.facade;

import dev.arcanus.codestore.modules.product_adm.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class ProductAdmIntegrationFacadeTest {

    @Autowired
    private ProductAdmFacade productAdmFacade;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository.clear();
    }

    @Test
    @DisplayName("Integração - ProductAdmFacade - Deve adicionar um produto com sucesso")
    void shouldAddProductSuccessfully() {
        AddProductFacadeInputDTO inputDTO = new AddProductFacadeInputDTO(
                "Product 1",
                "Description 1",
                10.0,
                100
        );

        Long idAddedProduct = productAdmFacade.addProduct(inputDTO);

        assertNotNull(idAddedProduct);
    }

    @Test
    @DisplayName("Integração - ProductAdmFacade - Deve verificar o estoque de um produto com sucesso")
    void shouldCheckStockSuccessfully() {
        AddProductFacadeInputDTO inputDTO = new AddProductFacadeInputDTO(
                "Product 2",
                "Description 2",
                20.0,
                200
        );
        Long idAddedProduct = productAdmFacade.addProduct(inputDTO);
        CheckStockFacadeOutputDTO stock = productAdmFacade.checkStock(idAddedProduct);
        assertNotNull(stock);
        assertEquals(idAddedProduct, stock.productId());
        assertEquals(inputDTO.stock(), stock.stock());
    }

    @Test
    @DisplayName("Integração - ProductAdmFacade - Deve listar todos os produtos com sucesso")
    void shouldListAllProductsSuccessfully() {
        AddProductFacadeInputDTO inputDTO1 = new AddProductFacadeInputDTO(
                "Product 3",
                "Description 3",
                30.0,
                300
        );
        AddProductFacadeInputDTO inputDTO2 = new AddProductFacadeInputDTO(
                "Product 4",
                "Description 4",
                40.0,
                400
        );
        productAdmFacade.addProduct(inputDTO1);
        productAdmFacade.addProduct(inputDTO2);

        ListAllProductsFacadeDTO allProducts = productAdmFacade.listAllProducts();

        assertNotNull(allProducts);
        assertEquals(2, allProducts.products().size());
    }

}
