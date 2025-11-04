package dev.arcanus.codestore.modules.client_adm.infra.controllers;

import dev.arcanus.codestore.modules.client_adm.application.repositories.ClientRepositoryImpl;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.value_objects.Address;
import dev.arcanus.codestore.modules.client_adm.infra.dtos.AddClientInputDto;
import dev.arcanus.codestore.modules.client_adm.infra.dtos.ClientOutputDto;
import dev.arcanus.codestore.modules.shared.infra.ApiResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FindClientByIdE2ETest {

    @Autowired
    private ClientController clientController;

    @Autowired
    private ClientRepositoryImpl clientRepository;

    Client client;

    @BeforeEach
    void setUp() {
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
    }

    @Test
    @DisplayName("Deve encontrar um cliente quando ID existir")
    void shouldFindOneClientWhenIdExists() {
        this.clientRepository.add(client);
        ResponseEntity<ApiResponse<?>> response = this.clientController.findOneClient(client.getId());

        assertEquals(200, response.getStatusCode().value());

        ClientOutputDto data = (ClientOutputDto) response.getBody().data();
        assertEquals(client.getName(), data.name());
        assertEquals(client.getEmail(), data.email());
    }

    @Test
    @DisplayName("Deve retornar erro quando id não existir")
    void shouldReturnErrorResponseWhenIdDoesNotExist() {
        ResponseEntity<ApiResponse<?>> response = this.clientController.findOneClient(2L);

        assertEquals(404, response.getStatusCode().value());
        assertEquals("error", response.getBody().status());
        assertEquals("Client not found", response.getBody().message());
    }
}