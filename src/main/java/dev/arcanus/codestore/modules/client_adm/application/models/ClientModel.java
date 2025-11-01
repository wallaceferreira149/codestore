package dev.arcanus.codestore.modules.client_adm.application.models;

import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.shared.repository.BaseModel;
import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class ClientModel extends BaseModel {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String street;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String zipCode;

    public ClientModel() {
    }

    public ClientModel(Long id, String name, String email, String street, String number, String complement, String city, String state, String zipCode) {
        super(id);
        this.name = name;
        this.email = email;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
