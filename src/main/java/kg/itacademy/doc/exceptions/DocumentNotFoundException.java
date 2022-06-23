package kg.itacademy.doc.exceptions;

public class DocumentNotFoundException extends RuntimeException{
    public DocumentNotFoundException(String s) {
        super(s);
    }
}
