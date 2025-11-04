package dev.arcanus.codestore.modules.client_adm.application.repositories;

import dev.arcanus.codestore.modules.client_adm.application.use_cases.FindClientByEmailUseCase;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.value_objects.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class FindClientByEmailIntegrationTest {

    @Autowired
    private FindClientByEmailUseCase useCase;

    @Autowired
    private ClientRepositoryImpl clientRepository;

    Client client;
    @BeforeEach
    void setup() {
        this.clientRepository.clear();
        client = new Client(
                1L,
                "John Doe",
                "jhon@mail.com",
                new Address(
                        "Some Street",
                        "123",
                        "Apt 4",
                        "Some City",
                        "Some State",
                        "12345-678"
                )
        );

        this.clientRepository.add(client);
    }

    @Test
    @DisplayName("Integration Test - Deve encontrar um cliente pelo email")
    void shouldFindClientByEmail() {

        Client foundedClient = this.useCase.execute("jhon@mail.com");

        assertNotNull(foundedClient);
        assertEquals(client.getName(), foundedClient.getName());
        assertEquals(client.getEmail(), foundedClient.getEmail());
        assertEquals(client.getAddress(), foundedClient.getAddress());
    }

}
