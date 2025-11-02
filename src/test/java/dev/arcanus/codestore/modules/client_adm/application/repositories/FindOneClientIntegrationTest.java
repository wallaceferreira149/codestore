package dev.arcanus.codestore.modules.client_adm.application.repositories;

import dev.arcanus.codestore.modules.client_adm.application.use_cases.FindOneClientUseCase;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.exceptions.ClientNotFoundCustomException;
import dev.arcanus.codestore.modules.client_adm.domain.value_objects.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class FindOneClientIntegrationTest {

    @Autowired
    private ClientRepositoryImpl clientRepository;

    @Autowired
    private FindOneClientUseCase useCase;

    @BeforeEach
    void setup() {
        this.clientRepository.clear();
    }

    @Test
    @DisplayName("Deve encontrar um cliente com sucesso")
    void shoulFindOneClient() {
        Address address = new Address(
                "Some Street",
                "123",
                "Apt 4",
                "Some City",
                "Some State",
                "12345-678"
        );
        Client client = new Client(
                1L,
                "John Doe",
                "jhon@mail.com",
                address
        );
        this.clientRepository.add(client);

        Client foundedClient = this.useCase.execute(1L);

        assertNotNull(foundedClient);
        assertEquals(client.getName(), foundedClient.getName());
        assertEquals(client.getEmail(), foundedClient.getEmail());
        assertEquals(client.getAddress(), foundedClient.getAddress());
    }

    @Test
    @DisplayName("Deve lançar erro se não encontrar o Id")
    void shoulThrowExceptionWhenClientIdDoesNotExist() {
        assertThrows(ClientNotFoundCustomException.class,
             () -> this.useCase.execute(1L));
    }



}