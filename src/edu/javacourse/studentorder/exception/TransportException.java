package edu.javacourse.studentorder.exception;

public class TransportException extends Exception {
    private String code;

    public String getCode() {
        return code;
    }

    public TransportException(String s, String code) {
        super(s);
        this.code = code;
    }

    public TransportException(String s, Throwable throwable, String code) {
        super(s, throwable);
        this.code = code;
    }

    public TransportException(Throwable throwable, String code) {
        super(throwable);
        this.code = code;
    }

    public TransportException(String s, Throwable throwable, boolean b, boolean b1, String code) {
        super(s, throwable, b, b1);
        this.code = code;
    }
}
