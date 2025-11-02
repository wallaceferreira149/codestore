package dev.arcanus.codestore.modules.client_adm.infra.mappers;

import dev.arcanus.codestore.modules.client_adm.application.models.ClientModel;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.value_objects.Address;
import dev.arcanus.codestore.modules.client_adm.infra.dtos.ClientOutputDto;

public class ClientMapper {

    public static ClientModel entityToModel(Client client) {
        return new ClientModel(
                null,
                client.getName(),
                client.getEmail(),
                client.getAddress().street(),
                client.getAddress().number(),
                client.getAddress().complement(),
                client.getAddress().city(),
                client.getAddress().state(),
                client.getAddress().zipCode()
        );
    }

    public static Client modelToEntity(ClientModel client) {
        Address address = new Address(
                client.getStreet(),
                client.getNumber(),
                client.getComplement(),
                client.getCity(),
                client.getState(),
                client.getZipCode()
        );

        return new Client(
                client.getId(),
                client.getName(),
                client.getEmail(),
                address
        );
    }

    public static ClientOutputDto entityToOutputDto(Client client) {
        return new ClientOutputDto(
                client.getId(),
                client.getName(),
                client.getEmail()
        );
    }
}
