package dev.arcanus.codestore.modules.client_adm.application.repositories;

import dev.arcanus.codestore.modules.client_adm.application.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ClientRepositoryJpaAdapter extends JpaRepository<ClientModel, Long> {

}
