package dev.arcanus.codestore.modules.client_adm.domain.repository;

import dev.arcanus.codestore.modules.client_adm.application.models.ClientModel;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    Client add(Client client);
    Client find(Long id);
    Optional<ClientModel> findByEmail(String email);
    List<Client> findAll();
    void update(Client client, Long id);
    void delete(Long id);
    void clear();
}
