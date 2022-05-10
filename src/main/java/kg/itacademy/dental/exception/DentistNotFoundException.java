package kg.itacademy.dental.exception;

public class DentistNotFoundException extends RuntimeException {
    public DentistNotFoundException(String s) {
        super(s);
    }
}
