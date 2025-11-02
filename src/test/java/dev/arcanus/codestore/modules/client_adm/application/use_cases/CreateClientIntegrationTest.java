package dev.arcanus.codestore.modules.client_adm.application.use_cases;

import dev.arcanus.codestore.modules.client_adm.domain.value_objects.Address;
import dev.arcanus.codestore.modules.client_adm.application.repositories.ClientRepositoryImpl;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class CreateClientIntegrationTest {

    @Autowired
    private CreateClientUseCase createClientUseCase;

    @Autowired
    private ClientRepositoryImpl clientRepository;

    @BeforeEach
    void setup() {
        this.clientRepository.clear();
    }

    @Test
    @DisplayName("Integração - Repository/Usecase - Deve criar um cliente com dados válidos")
    void shoulCreateClientWhenGivenValidData() {
        Address address = new Address(
                "Some Street",
                "123",
                "Apt 4",
                "Some City",
                "Some State",
                "12345-678"
        );
        Client inputClient = new Client(
                1L,
                "John Doe",
                "jhon@mail.com",
                address
        );

        Client addedClient = this.createClientUseCase.execute(inputClient);

        assertNotNull(addedClient);
        assertEquals(inputClient.getName(), addedClient.getName());
        assertEquals(inputClient.getEmail(), addedClient.getEmail());

    }
}