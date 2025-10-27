//package dev.arcanus.codestore.modules.storeCatalog.application.useCases.productDetail;
//
//import dev.arcanus.codestore.modules.storeCatalog.application.repositories.ProductRepositoryImpl;
//import dev.arcanus.codestore.modules.storeCatalog.domain.entities.Product;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ProductListDetailUseCase {
//
//    private final ProductRepositoryImpl productRepository;
//
//    public ProductListDetailUseCase(ProductRepositoryImpl productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    public ProductDetailDto execute(Long id) {
//        Product product = productRepository.productDetail(id);
//        if (product == null) {
//            return null;
//        }
//        return new ProductDetailDto(
//                product.getId(),
//                product.getName(),
//                product.getDescription(),
//                product.getSalesPrice()
//        );
//    }
//}
