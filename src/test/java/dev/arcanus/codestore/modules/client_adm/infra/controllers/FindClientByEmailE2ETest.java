package dev.arcanus.codestore.modules.client_adm.infra.controllers;

import dev.arcanus.codestore.modules.client_adm.application.models.ClientModel;
import dev.arcanus.codestore.modules.client_adm.application.repositories.ClientRepositoryImpl;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.factory.ClientFactory;
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

    ClientModel model;

    @BeforeEach
    void setUp(){
        this.clientRepository.clear();
        model = this.clientRepository.add(ClientFactory.createModel());
    }

    @Test
    @DisplayName("E2E - Deve encontrar um cliente pelo email")
    void shouldFindClientByEmail() {

        ResponseEntity<ApiResponse<?>> response = this.controller.findClientByEmail(model.getEmail());

        assertEquals(200, response.getStatusCode().value());
        assertEquals("success", response.getBody().status());

        ClientOutputDto data = (ClientOutputDto) response.getBody().data();
        assertEquals(model.getId(), data.id());
        assertEquals(model.getName(), data.name());
        assertEquals(model.getEmail(), data.email());
    }

}
