package dev.arcanus.codestore.modules.client_adm.application.use_cases;

import dev.arcanus.codestore.modules.client_adm.application.models.ClientModel;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.exceptions.ClientEmailAlreadyExistsCustomException;
import dev.arcanus.codestore.modules.client_adm.domain.repository.ClientRepository;
import dev.arcanus.codestore.modules.client_adm.infra.mappers.ClientMapper;
import dev.arcanus.codestore.modules.shared.config.annotations.UseCase;

@UseCase
public class CreateClientUseCase {

    private final ClientRepository clientRepository;

    public CreateClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client execute(Client client) {

        if (clientRepository.isClientEmailExists(client.getEmail())) {
            throw new ClientEmailAlreadyExistsCustomException("Não foi possível criar o cliente com esse email");
        }

        ClientModel addedClient = clientRepository.add(ClientMapper.entityToModel(client));

        return ClientMapper.modelToEntity(addedClient);
    }





}
