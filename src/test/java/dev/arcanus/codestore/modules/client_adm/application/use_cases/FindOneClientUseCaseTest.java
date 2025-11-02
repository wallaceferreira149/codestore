package dev.arcanus.codestore.modules.client_adm.application.use_cases;

import dev.arcanus.codestore.modules.client_adm.application.repositories.ClientRepositoryImpl;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.exceptions.ClientNotFoundCustomException;
import dev.arcanus.codestore.modules.client_adm.domain.value_objects.Address;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class FindOneClientUseCaseTest {

    @Mock
    private ClientRepositoryImpl clientRepository;

    @InjectMocks
    private FindOneClientUseCase findOneClientUseCase;

    @Test
    @DisplayName("Deve encontrar um cliente")
    void shoulFindOneClient() {

        Client client = new Client(
            1L,
            "John Doe",
            "jhon@mail.com",
            new Address(
                "Some Street",
                "123",
                "Apt 4",
                "Some City",
                "Some State",
                "12345-678"
            )
        );

        when(clientRepository.find(1L)).thenReturn(client);

        Client foundedClient = this.findOneClientUseCase.execute(1L);

        assertNotNull(foundedClient);
        assertEquals(client.getName(), foundedClient.getName());
        assertEquals(client.getEmail(), foundedClient.getEmail());
        assertEquals(client.getAddress(), foundedClient.getAddress());
    }

    @Test
    @DisplayName("Deve lançar exeção quando o id do cliente não existir")
    void shoulThrowExceptionWhenClientIdDoesNotExist() {

        when(clientRepository.find(1L)).thenThrow(new ClientNotFoundCustomException("Cliente não encontrado"));

        assertThrows(ClientNotFoundCustomException.class,
             () -> this.findOneClientUseCase.execute(1L));
    }
}