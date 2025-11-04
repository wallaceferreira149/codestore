package dev.arcanus.codestore.modules.client_adm.application.use_cases;

import dev.arcanus.codestore.modules.client_adm.application.models.ClientModel;
import dev.arcanus.codestore.modules.client_adm.application.repositories.ClientRepositoryImpl;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.repository.ClientRepository;
import dev.arcanus.codestore.modules.client_adm.domain.value_objects.Address;
import dev.arcanus.codestore.modules.shared.domain.exceptions.ResourceNotFoundCustomException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteClientByIdUseCaseTest {

    @Mock
    private ClientRepositoryImpl repository;

    @InjectMocks
    private DeleteClientByIdUseCase deleteClientByIdUseCase;

    Long existingId = 1L;
    Long nonExistingId = 99L;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Deve deletar um cliente através do ID")
    void shouldDeleteClientByIdWhenIdExists(){
        Long id = 1L;
        when(repository.isClientExists(existingId)).thenReturn(true);

        this.deleteClientByIdUseCase.execute(id);

        // Verifica se isClientExists foi chamado UMA vez com o ID correto.
        verify(repository, times(1)).isClientExists(existingId);
        // Verifica se delete foi chamado UMA vez com o ID correto.
        verify(repository, times(1)).delete(existingId);

    }

    @Test
    @DisplayName("Deve lançar erro quando client não existir")
    void shouldThrowExceptionWhenClientNotExists() {
        when(repository.isClientExists(nonExistingId)).thenReturn(false);

        assertThrows(ResourceNotFoundCustomException.class,
                () -> deleteClientByIdUseCase.execute(nonExistingId)
        );

        // Verifica se isClientExists foi chamado UMA vez com o ID correto.
        verify(repository, times(1)).isClientExists(nonExistingId);
        // **IMPORTANTE**: Verifica se o método delete NUNCA foi chamado, pois o fluxo foi interrompido pela exceção.
        verify(repository, never()).delete(nonExistingId);
    }
}