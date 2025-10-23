package dev.arcanus.codestore.modules.product_adm.use_case.add_product;

import dev.arcanus.codestore.modules.product_adm.domain.entity.Product;
import dev.arcanus.codestore.modules.product_adm.gateway.ProductGateway;

public class AddProductUseCase {
    
    private final ProductGateway productRepository;

    public AddProductUseCase(ProductGateway productRepository) {
        this.productRepository = productRepository;
    }

    public AddedProductDTO execute(AddProductDTO dto) {

        Product product = new Product(
            null,
            dto.name(),
            dto.description(),
            dto.price(),
            dto.stock()
        );

        Product savedProduct = productRepository.add(product);

        return new AddedProductDTO(
            savedProduct.getId().getId(),
            savedProduct.getName(),
            savedProduct.getDescription(),
            savedProduct.getPrice(),
            savedProduct.getStock(),
            savedProduct.getCreatedAt(),
            savedProduct.getUpdatedAt()
        );
    }
}
