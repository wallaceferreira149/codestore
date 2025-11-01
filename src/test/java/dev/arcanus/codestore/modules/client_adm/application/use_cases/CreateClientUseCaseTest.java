package dev.arcanus.codestore.modules.client_adm.application.use_cases;

import dev.arcanus.codestore.modules.client_adm.domain.value_objects.Address;
import dev.arcanus.codestore.modules.client_adm.infra.dtos.AddClientInputDto;
import dev.arcanus.codestore.modules.client_adm.infra.dtos.AddClientOutputDto;
import dev.arcanus.codestore.modules.client_adm.infra.mappers.AddClientMapper;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.repository.ClientRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateClientUseCaseTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private CreateClientUseCase createClientUseCase;

    @Test
    @DisplayName("Deve criar um cliente com dados válidos")
    void shoulCreateClientWhenGivenValidData() {
        Address address = new Address(
                "Some Street",
                "123",
                "Apt 4",
                "Some City",
                "Some State",
                "12345-678"
        );
        Client inputClient = new Client(
            1L,
            "John Doe",
            "jhon@mail.com",
            address
        );

        Client addedClient = this.createClientUseCase.execute(inputClient);

        assertNotNull(addedClient);
        assertEquals(inputClient.getName(), addedClient.getName());
        assertEquals(inputClient.getEmail(), addedClient.getEmail());
    }

}