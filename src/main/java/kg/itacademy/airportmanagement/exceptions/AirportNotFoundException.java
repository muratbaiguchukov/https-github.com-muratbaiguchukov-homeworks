package kg.itacademy.airportmanagement.exceptions;

public class AirportNotFoundException extends RuntimeException {
    public AirportNotFoundException(String s) {
        super(s);
    }
}
