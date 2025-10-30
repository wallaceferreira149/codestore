package dev.arcanus.codestore.modules.client_adm.infra.dtos;

public record AddClientInputDto(
        String name,
        String email,
        String street,
        String number,
        String complement,
        String city,
        String state,
        String zipCode
) {

}
