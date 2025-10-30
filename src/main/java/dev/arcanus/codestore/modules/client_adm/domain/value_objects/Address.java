package dev.arcanus.codestore.modules.client_adm.domain.value_objects;

public record Address(
        String street,
        String number,
        String complement,
        String city,
        String state,
        String zipCode
) {
}
