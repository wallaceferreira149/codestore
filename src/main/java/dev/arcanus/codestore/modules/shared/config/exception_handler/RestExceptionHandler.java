package dev.arcanus.codestore.modules.shared.config.exception_handler;

import dev.arcanus.codestore.modules.shared.domain.exceptions.CodeStoreException;
import dev.arcanus.codestore.modules.shared.infra.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(CodeStoreException.class)
    public static ResponseEntity<ApiResponse<ProblemDetail>> handleCodeStoreException(CodeStoreException exception) {
        ProblemDetail data = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        data.setTitle("CodeStore error");
        return ResponseEntity.internalServerError().body(ApiResponse.error("Unexpected Error", data, null));
    }
}
