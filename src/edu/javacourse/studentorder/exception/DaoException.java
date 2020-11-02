package edu.javacourse.studentorder.exception;

public class DaoException extends  Exception {
    public DaoException(Throwable throwable) {
        super(throwable);
    }

    public DaoException() {
    }

    public DaoException(String s) {
        super(s);
    }

    public DaoException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
