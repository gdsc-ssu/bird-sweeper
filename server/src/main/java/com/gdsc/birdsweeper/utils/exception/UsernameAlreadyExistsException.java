package com.gdsc.birdsweeper.utils.exception;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException() {
        super("Username already exist.");
    }
    public UsernameAlreadyExistsException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
    public UsernameAlreadyExistsException(String arg0) {
        super(arg0);
    }
    public UsernameAlreadyExistsException(Throwable arg0) {
        super(arg0);
    }
}
