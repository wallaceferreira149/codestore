package dev.arcanus.codestore.modules.product_adm.useCases.listAllProducts;

import dev.arcanus.codestore.modules.product_adm.domain.entity.Product;
import dev.arcanus.codestore.modules.product_adm.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllProductsUseCase {

    private final ProductRepository repository;

    public ListAllProductsUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductListDto execute() {
        List<Product> products = this.repository.listAll();
        return new ProductListDto(products);
    }

}
