//package dev.arcanus.codestore.modules.storeCatalog.application.useCases.listAll;
//
//import dev.arcanus.codestore.modules.shared.domain.valueobject.Id;
//import dev.arcanus.codestore.modules.storeCatalog.application.repositories.ProductRepositoryImpl;
//import dev.arcanus.codestore.modules.storeCatalog.domain.entities.Product;
//import dev.arcanus.codestore.modules.storeCatalog.domain.repository.ProductGateway;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.AssertionsKt.assertNotNull;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class ListAllProductsUseCaseTest {
//
//    @Mock
//    private ProductRepositoryImpl productRepository;
//
//    @InjectMocks
//    private ListAllProductsUseCase listAllProductsUseCase;
//
//    List<Product> productList;
//
//    @BeforeEach
//    void setUp() {
//        Product product1 = new Product(1L, "Product 1", "Description 1", 10.0);
//        Product product2 = new Product(2L, "Product 2", "Description 2", 20.0);
//
//        productList = new ArrayList<>();
//        productList.add(product1);
//        productList.add(product2);
//    }
//
//    @Test
//    @DisplayName("Deve listar todos os produtos com sucesso")
//    void shouldListAllProductsSuccessfully() {
//
//        when(this.productRepository.findAll()).thenReturn(this.productList);
//
//        ListAllProductsUseCaseDto allProductsDto = this.listAllProductsUseCase.execute();
//
//        assertNotNull(allProductsDto);
//    }
//}
