package dev.arcanus.codestore.modules.client_adm.infra.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AddClientInputDto(
        @NotBlank(message = "Name cannot be blank")
        String name,

        @Email(message = "Email should be valid format")
        @NotBlank(message = "Email cannot be blank")
        String email,

        String street,
        String number,
        String complement,
        String city,
        String state,
        String zipCode
) {

}
