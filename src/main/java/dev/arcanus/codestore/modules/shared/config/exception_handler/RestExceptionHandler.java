package dev.arcanus.codestore.modules.shared.config.exception_handler;

import dev.arcanus.codestore.modules.shared.domain.exceptions.CodeStoreException;
import dev.arcanus.codestore.modules.shared.domain.exceptions.ResourceNotFoundCustomException;
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
        data.setDetail(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.error("Unexpected Error", data, null));
    }

    @ExceptionHandler(Exception.class)
    public static ResponseEntity<ApiResponse<ProblemDetail>> handleException(Exception exception) {
        ProblemDetail data = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        data.setTitle("Server Error");
        data.setDetail(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.error("Unexpected Error", data, null));
    }

//    @ExceptionHandler(ResourceNotFoundCustomException.class)
//    public static ResponseEntity<ApiResponse<ProblemDetail>> handleResourceNotFoundCustomException(ResourceNotFoundCustomException exception) {
//        ProblemDetail data = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
//        data.setTitle("Resource Not Found");
//        data.setDetail(exception.getMessage());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error("Resource Not Found", data, null));
//    }
}
