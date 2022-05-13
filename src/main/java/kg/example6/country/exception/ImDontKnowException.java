package kg.example6.country.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ImDontKnowException extends RuntimeException {
    private HttpStatus httpStatus;


    public ImDontKnowException(String s) {
        super(s);
    }

    public HttpStatus getStatus() {
        return HttpStatus.I_AM_A_TEAPOT;
    }
}