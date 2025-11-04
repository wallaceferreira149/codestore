package dev.arcanus.codestore.modules.shared.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ResourceNotFoundCustomException extends CodeStoreException {

    private final String title;

    public ResourceNotFoundCustomException(String title, String message) {
        super(message);
        this.title = title;
    }

    public ResourceNotFoundCustomException(String title) {
        this(title, title);
    }

    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle(this.title);
        problemDetail.setDetail(this.getMessage());
        return problemDetail;
    }
}
