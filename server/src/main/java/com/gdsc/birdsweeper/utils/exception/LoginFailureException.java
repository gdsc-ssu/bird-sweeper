package com.gdsc.birdsweeper.utils.exception;

public class LoginFailureException extends RuntimeException {
    public LoginFailureException() {
        super("Login failed.");
    }
    public LoginFailureException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
    public LoginFailureException(String arg0) {
        super(arg0);
    }
    public LoginFailureException(Throwable arg0) {
        super(arg0);
    }
}
