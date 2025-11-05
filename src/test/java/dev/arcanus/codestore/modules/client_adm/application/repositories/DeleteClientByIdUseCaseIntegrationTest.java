package dev.arcanus.codestore.modules.client_adm.application.repositories;

import dev.arcanus.codestore.modules.client_adm.application.models.ClientModel;
import dev.arcanus.codestore.modules.client_adm.application.use_cases.DeleteClientByIdUseCase;
import dev.arcanus.codestore.modules.client_adm.domain.factory.ClientFactory;
import dev.arcanus.codestore.modules.shared.domain.exceptions.ResourceNotFoundCustomException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class DeleteClientByIdUseCaseIntegrationTest {

    @Autowired
    private DeleteClientByIdUseCase deleteClientByIdUseCase;

    @Autowired
    private ClientRepositoryImpl clientRepository;

    ClientModel client;
    @BeforeEach
    void setUp() {
        this.clientRepository.clear();
        client = this.clientRepository.add(ClientFactory.createModel());
    }

    @Test
    @DisplayName("Integration Repo/UseCase - Deve deletar um cliente pelo ID")
    void shouldDeleteClientById() {
        this.deleteClientByIdUseCase.execute(client.getId());
        assertFalse(this.clientRepository.isClientExists(client.getId()),
                "O cliente não deveria mais existir no repositório após a execução do Use Case.");
    }

    @Test
    @DisplayName("IT-DEL-02 Deve lançar um erro ao tentar deletar um cliente com ID não exitente")
    void shouldThrowExceptionWhenClientIdDoesNotExist() {
        assertThrows(ResourceNotFoundCustomException.class,
                () -> this.deleteClientByIdUseCase.execute(99L));
    }
}