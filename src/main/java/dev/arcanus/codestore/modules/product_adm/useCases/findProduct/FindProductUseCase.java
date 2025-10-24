package dev.arcanus.codestore.modules.product_adm.useCases.findProduct;

import dev.arcanus.codestore.modules.product_adm.domain.entity.Product;
import dev.arcanus.codestore.modules.product_adm.gateway.ProductGateway;
import dev.arcanus.codestore.modules.shared.domain.valueobject.Id;
import org.springframework.stereotype.Service;

@Service
public class FindProductUseCase {

    private final ProductGateway repository;

    public FindProductUseCase(ProductGateway repository) {
        this.repository = repository;
    }

    public FindedProductDTO execute(Long id) {
        Product product = this.repository.find(new Id(id));

        if (product == null) {
            throw new Error("Product not found");
        }

        return new FindedProductDTO(
            product.getId().getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getStock(),
            product.getCreatedAt(),
            product.getUpdatedAt()
        );
    }
}
