package dev.arcanus.codestore.modules.shared.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class CodeStoreException extends RuntimeException {

    /**
     * Convert the exception to a ProblemDetail object.
     * @return A ProblemDetail object that represents the exception.
     */
    public ProblemDetail toProblemDetail() {
        // Create a ProblemDetail object with the status code of INTERNAL_SERVER_ERROR.
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        // Set the title of the ProblemDetail object to "CodeStore Error".
        problemDetail.setTitle("CodeStore Error");
        // Set the detail of the ProblemDetail object to the message of the exception.
        problemDetail.setDetail(this.getMessage());
        // Return the ProblemDetail object.
        return problemDetail;
    }
}
