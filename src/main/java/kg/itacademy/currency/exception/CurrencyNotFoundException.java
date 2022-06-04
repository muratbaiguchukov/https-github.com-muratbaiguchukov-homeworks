package kg.itacademy.currency.exception;

public class CurrencyNotFoundException extends RuntimeException {
    public CurrencyNotFoundException(String s) {
        super(s);
    }
}
