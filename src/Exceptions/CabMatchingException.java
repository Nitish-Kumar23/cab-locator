package Exceptions;

public class CabMatchingException extends RuntimeException{

    public CabMatchingException(ErrorCodes errorCode, String message) {
        super(message);
    }
}
