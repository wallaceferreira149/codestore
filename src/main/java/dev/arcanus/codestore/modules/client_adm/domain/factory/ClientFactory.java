package dev.arcanus.codestore.modules.client_adm.domain.factory;

import dev.arcanus.codestore.modules.client_adm.application.models.ClientModel;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.value_objects.Address;

public class ClientFactory {

    public static Client createClient() {

        return new Client(
                1L,
                "John Doe",
                "john.doe@example.com",
                new Address(
                        "123 Main St",
                        "Apt 1",
                        "Springfield",
                        "IL",
                        "62704",
                        "USA"
                )
        );
    }

    public static ClientModel createModel() {
        return new ClientModel(
                null,
                "John Doe",
                "john.doe@example.com",
                "123 Main St",
                "Apt 1",
                "Springfield",
                "IL",
                "62704",
                "USA"
        );
    }
}
