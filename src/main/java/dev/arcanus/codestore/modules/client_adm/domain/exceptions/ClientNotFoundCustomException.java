package dev.arcanus.codestore.modules.client_adm.domain.exceptions;

import dev.arcanus.codestore.modules.shared.domain.exceptions.CodeStoreException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ClientNotFoundCustomException extends CodeStoreException
 {
     private String detail;

    public ClientNotFoundCustomException(String detail) {
         this.detail = detail;
     }

     @Override
        public ProblemDetail toProblemDetail() {
            ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
            problemDetail.setTitle("Client Not Found");
            problemDetail.setDetail(detail);
            return problemDetail;
        }
}
