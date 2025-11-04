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
class CreateClientE2ETest {

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
    @DisplayName("Deve criar um novo cliente com sucesso")
    void shouldCreateClientWhenDataIsValid() {

        AddClientInputDto inputDto = new AddClientInputDto(
                "John Doe",
                "jhon@mail.com",
                "Some Street",
                "123",
                "Apt 4",
                "Some City",
                "Some State",
                "12345-678"
        );

        ResponseEntity<ApiResponse<ClientOutputDto>> response = clientController.createClient(inputDto);

        assertEquals(201, response.getStatusCode().value());
        assertNotNull(response.getBody().data());
        assertEquals(inputDto.name(), response.getBody().data().name());
        assertEquals(inputDto.email(), response.getBody().data().email());
    }
}