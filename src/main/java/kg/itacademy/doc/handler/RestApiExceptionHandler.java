package kg.itacademy.doc.handler;

import kg.itacademy.doc.exceptions.ImDontKnowException;
import kg.itacademy.doc.model.ErrorModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class RestApiExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<String> handleValidationExceptions(RuntimeException ex) {
        return ResponseEntity
                .badRequest()
                .body(ex.getMessage());
    }

    @ExceptionHandler(ImDontKnowException.class)
    public ResponseEntity<ErrorModel> handleValidationExceptions(ImDontKnowException ex) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setMsg(ex.getMessage());
        errorModel.setExceptionClassName(ImDontKnowException.class.toString());
        return ResponseEntity.status(ex.getStatus()).body(errorModel);
    }
}
