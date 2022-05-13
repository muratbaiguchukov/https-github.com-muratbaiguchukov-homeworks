package kg.example6.country.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorModel {
    private String msg;
    private String exceptionClassName;
}