package dev.arcanus.codestore.modules.client_adm.infra.controllers;

import dev.arcanus.codestore.modules.client_adm.application.use_cases.CreateClientUseCase;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.infra.dtos.AddClientInputDto;
import dev.arcanus.codestore.modules.client_adm.infra.dtos.AddClientOutputDto;
import dev.arcanus.codestore.modules.client_adm.infra.mappers.AddClientMapper;
import dev.arcanus.codestore.modules.shared.infra.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/clients")
public class ClientController {

    private final CreateClientUseCase createClientUseCase;

    public ClientController(CreateClientUseCase createClientUseCase) {
        this.createClientUseCase = createClientUseCase;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AddClientOutputDto>> createClient(@RequestBody @Valid AddClientInputDto inputDto) {

        Client client = AddClientMapper.toEntity(inputDto);

        Client createdClient = createClientUseCase.execute(client);

        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdClient.getId())
                    .toUri();

        AddClientOutputDto data = new AddClientOutputDto(
                createdClient.getId(),
                createdClient.getName(),
                createdClient.getEmail()
        );

        return ResponseEntity.ok(ApiResponse.success("Client created successfully", data, uri));

    }
}
