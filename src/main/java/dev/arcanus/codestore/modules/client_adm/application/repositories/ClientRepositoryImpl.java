package dev.arcanus.codestore.modules.client_adm.application.repositories;

import dev.arcanus.codestore.modules.client_adm.infra.mappers.ClientMapper;
import dev.arcanus.codestore.modules.client_adm.application.models.ClientModel;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.repository.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final ClientRepositoryJpaAdapter jpaAdapter;

    public ClientRepositoryImpl(ClientRepositoryJpaAdapter jpaAdapter) {
        this.jpaAdapter = jpaAdapter;
    }

    @Override
    public Client add(Client client) {
        ClientModel model = ClientMapper.entityToModel(client);
        ClientModel savedClient = this.jpaAdapter.save(model);
        return ClientMapper.modelToEntity(savedClient);
    }

    @Override
    public Client find(Long id) {
        return null;
    }

    @Override
    public Client findByEmail(String email) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        return List.of();
    }

    @Override
    public void update(Client client, Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
