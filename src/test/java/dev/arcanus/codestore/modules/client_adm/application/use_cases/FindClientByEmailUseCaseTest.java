package dev.arcanus.codestore.modules.client_adm.application.use_cases;

import dev.arcanus.codestore.modules.client_adm.application.models.ClientModel;
import dev.arcanus.codestore.modules.client_adm.application.repositories.ClientRepositoryImpl;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.value_objects.Address;
import dev.arcanus.codestore.modules.client_adm.infra.mappers.ClientMapper;
import dev.arcanus.codestore.modules.shared.domain.exceptions.ResourceNotFoundCustomException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class FindClientByEmailUseCaseTest {

    @Mock
    private ClientRepositoryImpl clientRepository;

    @InjectMocks
    private FindClientByEmailUseCase findClientByEmailUseCase;

    Client client;
    String mail;

    @BeforeEach
    void setUp() {
        client = new Client(
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
        mail = "jhon@mail.com";
    }

    @Test
    @DisplayName("Deve encontrar um cliente através do email")
    void shouldFindClientByEmail() {

        ClientModel clientModel = ClientMapper.entityToModel(client);

        when(clientRepository.findByEmail(mail)).thenReturn(Optional.of(clientModel));

        Client foundedClient = this.findClientByEmailUseCase.execute(mail);

        assertNotNull(foundedClient);
        assertEquals(client.getName(), foundedClient.getName());
        assertEquals(client.getEmail(), foundedClient.getEmail());
        assertEquals(client.getAddress(), foundedClient.getAddress());
    }

    @Test
    @DisplayName("Deve lançar erro quando email não for encontrado")
    void shouldThrowExceptionWhenEmailDoesNotExist() {

        when(clientRepository.findByEmail(mail)).thenThrow(new ResourceNotFoundCustomException("Cliente não encontrado"));

        assertThrows(ResourceNotFoundCustomException.class,
             () -> this.findClientByEmailUseCase.execute(mail));
    }
}