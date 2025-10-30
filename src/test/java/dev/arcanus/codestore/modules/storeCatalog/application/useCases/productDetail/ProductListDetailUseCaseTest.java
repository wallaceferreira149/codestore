//package dev.arcanus.codestore.modules.storeCatalog.application.useCases.productDetail;
//
//import dev.arcanus.codestore.modules.storeCatalog.application.repositories.ProductRepositoryImpl;
//import dev.arcanus.codestore.modules.storeCatalog.domain.entities.Product;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class ProductListDetailUseCaseTest {
//
//    @Mock
//    private  productRepository;
//
//    @InjectMocks
//    private ProductListDetailUseCase productDetailUseCase;
//
//    Long testId = 1L;
//    Product validProduct;
//    @BeforeEach
//    void setUp() {
//        validProduct = new Product(
//                1L,
//                "Product 1",
//                "Description 1",
//                10.0
//        );
//    }
//
//    @Test
//    @DisplayName("Deve retornar detalhes do produto dado um ID válido")
//    void shouldReturnProductDetailsWhenGivenValidId() {
//
//        when(productRepository.productDetail(testId)).thenReturn(validProduct);
//
//        ProductDetailDto resultProductDetail = productDetailUseCase.execute(testId);
//
//        assertNotNull(resultProductDetail);
//        assertEquals(validProduct.getId(), resultProductDetail.id());
//    }
//}