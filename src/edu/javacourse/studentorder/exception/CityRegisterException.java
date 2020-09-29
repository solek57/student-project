package edu.javacourse.studentorder.exception;

public class CityRegisterException extends Exception {

    private String code;

    public String getCode() {
        return code;
    }

    public CityRegisterException(String s, Throwable throwable, String code) {
        super(s, throwable);
        this.code = code;
    }

    public  CityRegisterException(String message){
        super(message);
    }

    public CityRegisterException(String message, Throwable throwable){
        super(message, throwable);
    }
}
