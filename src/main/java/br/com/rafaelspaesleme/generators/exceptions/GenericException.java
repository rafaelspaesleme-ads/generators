package br.com.rafaelspaesleme.generators.exceptions;

public class GenericException extends RuntimeException {
    public GenericException() {
    }

    public GenericException(String s) {
        super(s);
    }

    public GenericException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public GenericException(Throwable throwable) {
        super(throwable);
    }

    public GenericException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
