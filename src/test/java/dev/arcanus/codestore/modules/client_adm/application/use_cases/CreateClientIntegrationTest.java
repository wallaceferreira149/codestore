package dev.arcanus.codestore.modules.client_adm.application.use_cases;

import dev.arcanus.codestore.modules.client_adm.infra.dtos.AddClientInputDto;
import dev.arcanus.codestore.modules.client_adm.infra.dtos.AddClientOutputDto;
import dev.arcanus.codestore.modules.client_adm.infra.mappers.AddClientMapper;
import dev.arcanus.codestore.modules.client_adm.application.repositories.ClientRepositoryImpl;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class CreateClientIntegrationTest {

    @Autowired
    private CreateClientUseCase createClientUseCase;

    @Autowired
    private ClientRepositoryImpl clientRepository;

    @Test
    @DisplayName("Integração - Repository/Usecase - Deve criar um cliente com dados válidos")
    void shoulCreateClientWhenGivenValidData() {
        AddClientInputDto inputDto = new AddClientInputDto(
                "John Doe",
                "jhon@mail.com",
                "Some Street",
                "123",
                "Apt 4",
                "Some City",
                "Some State",
                "12345-678"
        );
        Client addClient = AddClientMapper.toEntity(inputDto);

        AddClientOutputDto addedClient = this.createClientUseCase.execute(inputDto);

        assertNotNull(addedClient);
        assertEquals(inputDto.name(), addedClient.name());
        assertEquals(inputDto.email(), addedClient.email());
        assertEquals(inputDto.street(), addClient.getAddress().street());

    }
}