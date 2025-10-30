package dev.arcanus.codestore.modules.client_adm.infra.mappers;

import dev.arcanus.codestore.modules.client_adm.infra.dtos.AddClientInputDto;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.value_objects.Address;

public class AddClientMapper {

    public static Client toEntity(AddClientInputDto dto) {
        Address address = new Address(
                dto.street(),
                dto.number(),
                dto.complement(),
                dto.city(),
                dto.state(),
                dto.zipCode()
        );

        return new Client(
                null,
                dto.name(),
                dto.email(),
                address
        );
    }
}
