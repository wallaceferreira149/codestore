package dev.arcanus.codestore.modules.client_adm.application.use_cases;

import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.repository.ClientRepository;
import dev.arcanus.codestore.modules.shared.config.annotations.UseCase;

@UseCase
public class FindClientByIdUseCase {

    private final ClientRepository clientRepository;

    public FindClientByIdUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client execute(Long id) {
        return this.clientRepository.find(id);
    }
}
