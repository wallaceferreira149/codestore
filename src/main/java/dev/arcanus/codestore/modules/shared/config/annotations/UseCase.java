package dev.arcanus.codestore.modules.shared.config.annotations;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.*;

@Documented // Indica que a annotation deve aparecer na documentação (Javadoc) das classes que a usam.
@Target(ElementType.TYPE) // Define que a annotation só pode ser aplicada a tipos (classes, interfaces, enums).
@Retention(RetentionPolicy.RUNTIME) // Especifica que a annotation estará disponível em tempo de execução via reflexão.
@Service // Meta-annotation: transforma classes anotadas em beans gerenciados pelo Spring.
@Validated // Aplica validação aos métodos/argumentos das classes anotadas pelo Spring.
public @interface UseCase { // Declara a annotation pública chamada UseCase; aqui podem ser definidos atributos/métodos se necessário.
}
