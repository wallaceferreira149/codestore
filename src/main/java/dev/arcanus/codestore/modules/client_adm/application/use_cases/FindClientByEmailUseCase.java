package dev.arcanus.codestore.modules.client_adm.application.use_cases;

import dev.arcanus.codestore.modules.client_adm.application.models.ClientModel;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.repository.ClientRepository;
import dev.arcanus.codestore.modules.client_adm.infra.mappers.ClientMapper;
import dev.arcanus.codestore.modules.shared.config.annotations.UseCase;
import dev.arcanus.codestore.modules.shared.domain.exceptions.ResourceNotFoundCustomException;

import java.util.Optional;

@UseCase
public class FindClientByEmailUseCase {

    private final ClientRepository clientRepository;

    public FindClientByEmailUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client execute(String mail) {

        Optional<ClientModel> client = this.clientRepository.findByEmail(mail);

        if (client.isEmpty()) {
            throw new ResourceNotFoundCustomException("Cliente não encontrado");
        }

        return ClientMapper.modelToEntity(client.get());
    }
}
