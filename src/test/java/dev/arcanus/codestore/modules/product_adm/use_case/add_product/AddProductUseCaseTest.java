package dev.arcanus.codestore.modules.product_adm.use_case.add_product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.arcanus.codestore.modules.product_adm.domain.entity.Product;
import dev.arcanus.codestore.modules.product_adm.gateway.ProductGateway;
import dev.arcanus.codestore.modules.shared.domain.valueobject.Id;

// Anotação essencial para inicializar os Mocks antes de cada teste
@ExtendWith(MockitoExtension.class)
public class AddProductUseCaseTest {

    // 2. A classe a ser testada, injetando as dependências mockadas
    @InjectMocks
    private AddProductUseCase useCase;

    // 1. Dependência a ser isolada
    @Mock
    private ProductGateway repository;

    private Product productEntity;
    private AddProductDTO dto;

    @BeforeEach
    void setUp() {
        dto = new AddProductDTO("Notebook", "High-end gaming laptop", 1500.00, 10);
        productEntity = new Product(new Id(1L), "Notebook", "High-end gaming laptop", 1500.00, 10);
    }

    @Test
    @DisplayName("Deve adicionar um novo produto com sucesso")
    public void shouldReturnAddedProductDTOWhenAddProductDTOHasCorrectData() {
        when(repository.add(any(Product.class))).thenReturn(productEntity);
        var result = useCase.execute(dto);
        
        assertNotNull(result);
        assertEquals(productEntity.getId().getId(), result.id());
    }

    
}
