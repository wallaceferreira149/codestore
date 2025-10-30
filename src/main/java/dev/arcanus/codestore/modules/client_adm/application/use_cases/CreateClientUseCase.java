package dev.arcanus.codestore.modules.client_adm.application.use_cases;

import dev.arcanus.codestore.modules.client_adm.infra.dtos.AddClientInputDto;
import dev.arcanus.codestore.modules.client_adm.infra.dtos.AddClientOutputDto;
import dev.arcanus.codestore.modules.client_adm.infra.mappers.AddClientMapper;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.repository.ClientRepository;
import dev.arcanus.codestore.modules.shared.config.annotations.UseCase;

@UseCase
public class CreateClientUseCase {

    private final ClientRepository clientRepository;

    public CreateClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client execute(Client client) {

       return clientRepository.add(client);

    }





}
