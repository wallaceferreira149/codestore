package dev.arcanus.codestore.modules.client_adm.domain.exceptions;

import dev.arcanus.codestore.modules.shared.domain.exceptions.CodeStoreException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ClientEmailAlreadyExistsCustomException extends CodeStoreException {

    private String title;

    public ClientEmailAlreadyExistsCustomException(String title, String message) {
        super(message);
        this.title = title;
    }

    public ClientEmailAlreadyExistsCustomException(String title) {
        this(title, title);
    }

    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problemDetail.setTitle(this.title);
        problemDetail.setDetail(this.getMessage());
        return problemDetail;
    }
}
