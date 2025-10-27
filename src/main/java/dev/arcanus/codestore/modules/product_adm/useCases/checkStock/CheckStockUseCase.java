package dev.arcanus.codestore.modules.product_adm.useCases.checkStock;

import dev.arcanus.codestore.modules.product_adm.domain.entity.Product;
import dev.arcanus.codestore.modules.product_adm.gateway.ProductGateway;
import dev.arcanus.codestore.modules.shared.domain.valueobject.Id;
import org.springframework.stereotype.Service;

@Service
public class CheckStockUseCase {

    private final ProductGateway productRepository;

    public CheckStockUseCase(ProductGateway productRepository) {
        this.productRepository = productRepository;
    }

    public CheckStockUseCaseOutputDto execute(Long productId) {
        Product product = productRepository.find(productId);
        return new CheckStockUseCaseOutputDto(product.getId(), product.getStock());
    }

}
