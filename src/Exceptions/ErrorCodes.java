package Exceptions;

public enum ErrorCodes {

    NO_CAB_FOUND("no cabs were found",1001),
    INVALID_RIDER("invalid rider",1002);

    private String message;
    
    private Integer errorcode;

    ErrorCodes(String message, Integer errorcode) {
        this.message = message;
        this.errorcode = errorcode;
    }

    public String getMessage() {
        return message;
    }

    public Integer getErrorcode() {
        return errorcode;
    }

}
