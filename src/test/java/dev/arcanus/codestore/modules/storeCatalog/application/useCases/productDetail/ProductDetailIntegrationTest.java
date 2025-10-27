//package dev.arcanus.codestore.modules.storeCatalog.application.useCases.productDetail;
//
//import dev.arcanus.codestore.modules.storeCatalog.application.repositories.ProductRepositoryImpl;
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//
//@SpringBootTest
//@ActiveProfiles("test")
//@Transactional
//public class ProductDetailIntegrationTest {
//
//    private ProductListDetailUseCase productDetailUseCase;
//
//    private ProductRepositoryImpl productRepository;
//
//
//
//    public ProductDetailIntegrationTest(
//            ProductListDetailUseCase productDetailUseCase,
//            ProductRepositoryImpl productRepository
//    ) {
//        this.productDetailUseCase = productDetailUseCase;
//        this.productRepository = productRepository;
//    }
//
////    @BeforeEach
////    void setUp() {
////        Pr
////    }
//
//    @Test
//    @DisplayName("Integração - Repository/Usecase - Deve retornar detalhes do produto dado um ID válido")
//    void shoudReturnProductDetailsWhenGivenValidId() {
//        Long testId = 1L;
//
//        ProductDetailDto resultProductDetail = productDetailUseCase.execute(testId);
//
//        assert resultProductDetail != null;
//        assert resultProductDetail.id().equals(testId);
//    }
//
//}
