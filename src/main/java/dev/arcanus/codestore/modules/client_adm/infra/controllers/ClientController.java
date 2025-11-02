package dev.arcanus.codestore.modules.client_adm.infra.controllers;

import dev.arcanus.codestore.modules.client_adm.application.use_cases.CreateClientUseCase;
import dev.arcanus.codestore.modules.client_adm.application.use_cases.FindOneClientUseCase;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.exceptions.ClientNotFoundCustomException;
import dev.arcanus.codestore.modules.client_adm.infra.dtos.AddClientInputDto;
import dev.arcanus.codestore.modules.client_adm.infra.dtos.ClientOutputDto;
import dev.arcanus.codestore.modules.client_adm.infra.mappers.AddClientMapper;
import dev.arcanus.codestore.modules.client_adm.infra.mappers.ClientMapper;
import dev.arcanus.codestore.modules.shared.infra.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v${api.version}/clients")
public class ClientController {

    private final CreateClientUseCase createClientUseCase;

    private final FindOneClientUseCase findOneClientUseCase;

    public ClientController(CreateClientUseCase createClientUseCase, FindOneClientUseCase findOneClientUseCase) {
        this.createClientUseCase = createClientUseCase;
        this.findOneClientUseCase = findOneClientUseCase;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ClientOutputDto>> createClient(@RequestBody @Valid AddClientInputDto inputDto) {

        Client client = AddClientMapper.toEntity(inputDto);

        Client createdClient = createClientUseCase.execute(client);

        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdClient.getId())
                    .toUri();

        ClientOutputDto data = new ClientOutputDto(
                createdClient.getId(),
                createdClient.getName(),
                createdClient.getEmail()
        );

        return ResponseEntity.created(uri).body(ApiResponse.success("Client created successfully", data, uri));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<?>> findOneClient(@PathVariable Long id) {

        Client client = null;
        try {
            client = this.findOneClientUseCase.execute(id);
            ClientOutputDto data = ClientMapper.entityToOutputDto(client);
            return ResponseEntity.ok(ApiResponse.success("Client found successfully", data, null));
        } catch (ClientNotFoundCustomException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    ApiResponse.error("Client not found", e.toProblemDetail(), null)
            );
        }
    }
}
