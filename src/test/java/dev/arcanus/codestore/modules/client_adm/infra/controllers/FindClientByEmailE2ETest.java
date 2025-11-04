package dev.arcanus.codestore.modules.client_adm.infra.controllers;

import dev.arcanus.codestore.modules.client_adm.application.repositories.ClientRepositoryImpl;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.value_objects.Address;
import dev.arcanus.codestore.modules.client_adm.infra.dtos.ClientOutputDto;
import dev.arcanus.codestore.modules.shared.infra.ApiResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FindClientByEmailE2ETest {

    @Autowired
    private ClientController controller;

    @Autowired
    private ClientRepositoryImpl clientRepository;

    Client client;

    @BeforeEach
    void setUp(){
        client = new Client(
                1L,
                "wallace",
                "wallace@mail.com",
                new Address(
                        "Rua Teste",
                        "123",
                        "Apt 4",
                        "Cidade Teste",
                        "Estado Teste",
                        "12345-678"
                )
        );
        this.clientRepository.clear();
        this.clientRepository.add(client);
    }

    @Test
    @DisplayName("E2E - Deve encontrar um cliente pelo email")
    void shouldFindClientByEmail() {

        ResponseEntity<ApiResponse<?>> response = this.controller.findClientByEmail(client.getEmail());

        assertEquals(200, response.getStatusCode().value());
        assertEquals("success", response.getBody().status());

        ClientOutputDto data = (ClientOutputDto) response.getBody().data();
        assertEquals(client.getId(), data.id());
        assertEquals(client.getName(), data.name());
        assertEquals(client.getEmail(), data.email());
    }

}
