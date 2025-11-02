package dev.arcanus.codestore.modules.client_adm.application.use_cases;

import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.repository.ClientRepository;
import dev.arcanus.codestore.modules.shared.config.annotations.UseCase;
import org.springframework.stereotype.Service;

@UseCase
public class FindOneClientUseCase {

    private final ClientRepository clientRepository;

    public FindOneClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client execute(Long id) {
        return this.clientRepository.find(id);
    }
}
