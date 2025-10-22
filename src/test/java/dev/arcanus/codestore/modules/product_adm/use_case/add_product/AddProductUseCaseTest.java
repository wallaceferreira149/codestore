package dev.arcanus.codestore.modules.product_adm.use_case.add_product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.arcanus.codestore.modules.product_adm.domain.entity.Product;

// Anotação essencial para inicializar os Mocks antes de cada teste
@ExtendWith(MockitoExtension.class)
public class AddProductUseCaseTest {

    // 2. A classe a ser testada, injetando as dependências mockadas
    @InjectMocks
    private AddProductUseCase addProductUseCase;

    // 1. Dependência a ser isolada
    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        Product newProduct = new Product(1L, "Notebook", "High-end gaming laptop", 1500.00, 10);
        when(productRepository.save(any(Product.class))).thenReturn(newProduct);
    }

    
}
