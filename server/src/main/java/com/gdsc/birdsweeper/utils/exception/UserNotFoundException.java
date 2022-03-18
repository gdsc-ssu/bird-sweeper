package com.gdsc.birdsweeper.utils.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User not found.");
    }
    public UserNotFoundException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
    public UserNotFoundException(String arg0) {
        super(arg0);
    }
    public UserNotFoundException(Throwable arg0) {
        super(arg0);
    }
}
