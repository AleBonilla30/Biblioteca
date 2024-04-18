package utils;

public class CatalogoNoexisteException extends RuntimeException{
    public CatalogoNoexisteException(String message) {
        super(message);
    }
}
