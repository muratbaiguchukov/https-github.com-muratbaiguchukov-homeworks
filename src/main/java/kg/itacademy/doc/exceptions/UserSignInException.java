package kg.itacademy.doc.exceptions;

import org.springframework.http.HttpStatus;

public class UserSignInException extends RuntimeException{
    public UserSignInException(String s, HttpStatus notFound) {
    }
}
