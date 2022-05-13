package kg.example6.country.exception;

public class CountryNotFoundException extends RuntimeException{
    public CountryNotFoundException(String s) {
        super(s);
    }
}