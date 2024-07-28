package org.example;

public enum ResponseCode {
    OK(true, "2000", "OK"),
    NOT_FOUND(false, "4004", "PAGE_NOT_FOUND");

    private final boolean httpStatus;
    private final String code;
    private final String message;

    ResponseCode(boolean httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public boolean isHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
