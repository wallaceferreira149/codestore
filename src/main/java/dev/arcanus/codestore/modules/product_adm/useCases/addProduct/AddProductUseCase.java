package dev.arcanus.codestore.modules.product_adm.useCases.addProduct;

import dev.arcanus.codestore.modules.product_adm.domain.entity.Product;
import dev.arcanus.codestore.modules.product_adm.gateway.ProductGateway;
import org.springframework.stereotype.Service;

@Service
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
