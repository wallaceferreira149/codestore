package dev.arcanus.codestore.modules.storeCatalog.application.useCases.listAll;

import dev.arcanus.codestore.modules.product_adm.facade.ListAllProductsFacadeDTO;
import dev.arcanus.codestore.modules.product_adm.facade.ProductAdmFacade;
import dev.arcanus.codestore.modules.storeCatalog.domain.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "storeCatalogListAllProductsUseCase")
public class ListAllProductsUseCase {

    private final ProductAdmFacade productFacade;

    public ListAllProductsUseCase(ProductAdmFacade productFacade) {
        this.productFacade = productFacade;
    }

    public ListAllProductsUseCaseDto execute(){
        ListAllProductsFacadeDTO products = this.productFacade.listAllProducts();
        List<Product> storeProducts = products.products().stream()
                .map(p -> new Product(
                        p.getId(),
                        p.getName(),
                        p.getDescription(),
                        p.getPrice()
                )).toList();
        return new ListAllProductsUseCaseDto(storeProducts);
    }
}
