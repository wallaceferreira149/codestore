package dev.arcanus.codestore.modules.client_adm.application.repositories;

import dev.arcanus.codestore.modules.client_adm.application.models.ClientModel;
import dev.arcanus.codestore.modules.client_adm.application.use_cases.FindClientByIdUseCase;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.exceptions.ClientNotFoundCustomException;
import dev.arcanus.codestore.modules.client_adm.domain.factory.ClientFactory;
import dev.arcanus.codestore.modules.client_adm.domain.value_objects.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class FindOneClientIntegrationTest {

    @Autowired
    private ClientRepositoryImpl clientRepository;

    @Autowired
    private FindClientByIdUseCase useCase;

    ClientModel client;

    @BeforeEach
    void setup() {
        this.clientRepository.clear();
        client = this.clientRepository.add(ClientFactory.createModel());
    }

    @Test
    @DisplayName("Deve encontrar um cliente com sucesso")
    void shoulFindOneClient() {


        Client foundedClient = this.useCase.execute(1L);

        assertNotNull(foundedClient);
        assertEquals(client.getName(), foundedClient.getName());
        assertEquals(client.getEmail(), foundedClient.getEmail());
    }

    @Test
    @DisplayName("Deve lançar erro se não encontrar o Id")
    void shoulThrowExceptionWhenClientIdDoesNotExist() {
        assertThrows(ClientNotFoundCustomException.class,
             () -> this.useCase.execute(1L));
    }

}