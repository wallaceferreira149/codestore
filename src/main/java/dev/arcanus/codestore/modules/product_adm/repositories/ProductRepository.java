package dev.arcanus.codestore.modules.product_adm.repositories;

import dev.arcanus.codestore.modules.product_adm.domain.entity.Product;
import dev.arcanus.codestore.modules.product_adm.gateway.ProductGateway;
import dev.arcanus.codestore.modules.shared.domain.valueobject.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
                new Id(model.getId()),
                model.getCreatedAt(),
                model.getUpdatedAt(),
                model.getName(),
                model.getDescription(),
                model.getPrice(),
                model.getStock()
        );

    }

    @Override
    public Product find(Id id) {
        ProductModel model = this.jpaRepository.findById(id.getId()).orElseThrow();
        return new Product(
            new Id(model.getId()),
            model.getCreatedAt(),
            model.getUpdatedAt(),
            model.getName(),
            model.getDescription(),
            model.getPrice(),
            model.getStock()
        );
    }
}
