package college.tusck.App.Controller.GlobalExceptionHandler;

import college.tusck.App.Model.IntegrationResponse.IntegrationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<IntegrationResponse> handleIllegalArgument(
            IllegalArgumentException ex
    ) {
        return ResponseEntity.badRequest()
                .body(new IntegrationResponse(0, "ERROR", ex.getMessage()));
    }
}
