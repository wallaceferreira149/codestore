package dev.arcanus.codestore.modules.client_adm.application.repositories;

import dev.arcanus.codestore.modules.client_adm.domain.exceptions.ClientNotFoundCustomException;
import dev.arcanus.codestore.modules.client_adm.infra.mappers.ClientMapper;
import dev.arcanus.codestore.modules.client_adm.application.models.ClientModel;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import dev.arcanus.codestore.modules.client_adm.domain.repository.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final ClientRepositoryJpaAdapter jpaAdapter;

    public ClientRepositoryImpl(ClientRepositoryJpaAdapter jpaAdapter) {
        this.jpaAdapter = jpaAdapter;
    }

    @Override
    public ClientModel add(ClientModel client) {
        return this.jpaAdapter.save(client);
    }

    @Override
    public Client find(Long id) {
        ClientModel model = this.jpaAdapter.findById(id).orElseThrow(
                () -> new ClientNotFoundCustomException("Cliente não encontrado")
        );
        return ClientMapper.modelToEntity(model);
    }

    @Override
    public Optional<ClientModel> findByEmail(String email) {
        return this.jpaAdapter.findByEmail(email);
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
        this.jpaAdapter.deleteById(id);
    }

    @Override
    public boolean isClientExists(Long id) {
        return this.jpaAdapter.existsById(id);
    }

    @Override
    public boolean isClientEmailExists(String email) {
        return this.jpaAdapter.existsByEmail(email);
    }

    @Override
    public void clear() {
        this.jpaAdapter.deleteAll();
    }
}
