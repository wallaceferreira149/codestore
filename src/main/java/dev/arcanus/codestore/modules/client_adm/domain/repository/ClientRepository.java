package dev.arcanus.codestore.modules.client_adm.domain.repository;

import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;

import java.util.List;

public interface ClientRepository {

    Client add(Client client);
    Client find(Long id);
    Client findByEmail(String email);
    List<Client> findAll();
    void update(Client client, Long id);
    void delete(Long id);
    void clear();
}
