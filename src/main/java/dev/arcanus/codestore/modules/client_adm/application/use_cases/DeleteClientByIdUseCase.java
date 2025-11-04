package dev.arcanus.codestore.modules.client_adm.application.use_cases;

import dev.arcanus.codestore.modules.client_adm.domain.repository.ClientRepository;
import dev.arcanus.codestore.modules.shared.config.annotations.UseCase;
import dev.arcanus.codestore.modules.shared.domain.exceptions.ResourceNotFoundCustomException;

@UseCase
public class DeleteClientByIdUseCase {

    private final ClientRepository clientRepository;

    public DeleteClientByIdUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void execute(Long id) {
        if (!this.clientRepository.isClientExists(id)) {
            throw new ResourceNotFoundCustomException("Client com Id $`{id} não foi encontrado");
        }
        this.clientRepository.delete(id);
    }
}
