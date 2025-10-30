package dev.arcanus.codestore.modules.client_adm.domain.entities;

import dev.arcanus.codestore.modules.client_adm.domain.value_objects.Address;
import dev.arcanus.codestore.modules.shared.domain.entity.BaseEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Client extends BaseEntity {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Email(message = "Email should be valid format")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    private Address address;

    public Client(){}

    public Client(Long id, String name, String email, Address address) {
        super(id);
        this.name = name;
        this.email = email;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
