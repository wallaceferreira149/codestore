package dev.arcanus.codestore.modules.product_adm.repositories;

import dev.arcanus.codestore.modules.product_adm.domain.entity.Product;
import dev.arcanus.codestore.modules.product_adm.gateway.ProductGateway;
import dev.arcanus.codestore.modules.shared.domain.valueobject.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements ProductGateway {

    private final ProductJpaRepository jpaRepository;

    public ProductRepository(ProductJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Product add(Product product) {
        ProductModel model = new ProductModel(
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getStock()
        );
        ProductModel savedModel = this.jpaRepository.save(model);

        return new Product(
                model.getId(),
                model.getCreatedAt(),
                model.getUpdatedAt(),
                model.getName(),
                model.getDescription(),
                model.getPrice(),
                model.getStock()
        );

    }

    @Override
    public Product find(Long id) {
        ProductModel model = this.jpaRepository.findById(id).orElseThrow();
        return new Product(
            model.getId(),
            model.getCreatedAt(),
            model.getUpdatedAt(),
            model.getName(),
            model.getDescription(),
            model.getPrice(),
            model.getStock()
        );
    }

    @Override
    public List<Product> listAll() {
        List<ProductModel> productModels = this.jpaRepository.findAll();
        return productModels.stream().map(model -> new Product(
            model.getId(),
            model.getCreatedAt(),
            model.getUpdatedAt(),
            model.getName(),
            model.getDescription(),
            model.getPrice(),
            model.getStock()
        )).toList();
    }
}
