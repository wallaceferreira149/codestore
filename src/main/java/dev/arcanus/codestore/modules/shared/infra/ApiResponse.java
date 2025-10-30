package dev.arcanus.codestore.modules.shared.infra;

import org.springframework.http.ProblemDetail;

public record ApiResponse<T>(
        String status,
        String message,
        T data,
        Object metadata
) {
    public static <T> ApiResponse<T> success(String message, T data, Object metadata) {
        return new ApiResponse<>("success", message, data, metadata);
    }

    public static ApiResponse<ProblemDetail> error(String message, ProblemDetail data, Object metadata) {
        return new ApiResponse<>("error", message, data, metadata);
    }
}
