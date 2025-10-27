package dev.arcanus.codestore.modules.product_adm.useCases.addProduct;

import dev.arcanus.codestore.modules.product_adm.repositories.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.AssertionsKt.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class AddProductIntegrationTest {

    @Autowired
   private AddProductUseCase addProductUseCase;

    @Autowired
   private ProductRepository productRepository;

//   public AddProductIntegrationTest(
//           AddProductUseCase addProductUseCase,
//           ProductRepository productRepository
//   ) {
//       this.addProductUseCase = addProductUseCase;
//       this.productRepository = productRepository;
//   }

   @Test
    @DisplayName("Integração - Repository/Usecase - Deve adicionar um produto com sucesso")
    void shouldAddProductWhenDataIsCorrect() {
       AddProductDTO productInputDto = new AddProductDTO(
               "Produto de Teste",
               "Descrição do Produto de Teste",
               99.99,
               50
       );

       AddedProductDTO productAdded = this.addProductUseCase.execute(productInputDto);

         assertNotNull(productAdded);
         assertNotNull(productAdded.id());
         assertEquals(productInputDto.name(), productAdded.name());
   }
}
