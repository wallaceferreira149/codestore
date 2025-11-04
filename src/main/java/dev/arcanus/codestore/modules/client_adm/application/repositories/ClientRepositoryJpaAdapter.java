package dev.arcanus.codestore.modules.client_adm.application.repositories;

import dev.arcanus.codestore.modules.client_adm.application.models.ClientModel;
import dev.arcanus.codestore.modules.client_adm.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ClientRepositoryJpaAdapter extends JpaRepository<ClientModel, Long> {

    Optional<ClientModel> findByEmail(String email);
}
