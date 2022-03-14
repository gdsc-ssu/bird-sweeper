package com.gdsc.birdsweeper.utils.exception;

public class InputNotFoundException extends RuntimeException {
    public InputNotFoundException() {
        super();
    }
    public InputNotFoundException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
    public InputNotFoundException(String arg0) {
        super(arg0);
    }
    public InputNotFoundException(Throwable arg0) {
        super(arg0);
    }
}
