package dev.arcanus.codestore.modules.client_adm.domain.exceptions;

import dev.arcanus.codestore.modules.shared.domain.exceptions.CodeStoreException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ClientNotFoundCustomException extends CodeStoreException
 {
     private String title;
     private String message = this.getMessage();

    public ClientNotFoundCustomException(String title, String message) {
        super(message);
        this.title = title;
     }

     public ClientNotFoundCustomException(String title) {
        this(title, title);
     }

     @Override
        public ProblemDetail toProblemDetail() {
            ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
            problemDetail.setTitle(title);
            problemDetail.setDetail(this.message);
            return problemDetail;
        }
}
