//package dev.arcanus.codestore.modules.storeCatalog.application.repositories;
//
//import dev.arcanus.codestore.modules.storeCatalog.domain.entities.Product;
//import dev.arcanus.codestore.modules.storeCatalog.domain.repository.ProductGateway;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class ProductRepositoryImpl implements ProductGateway {
//
//    private final ProductJpaRepository productJpaRepository;
//
//    public ProductRepositoryImpl(ProductJpaRepository productJpaRepository) {
//        this.productJpaRepository = productJpaRepository;
//    }
//
//    @Override
//    public List<Product> findAll() {
//        return productJpaRepository.findAll();
//    }
//
//    @Override
//    public Product productDetail(Long id) {
//        return productJpaRepository.findById(id).orElse(null);
//    }
//}
