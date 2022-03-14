package com.gdsc.birdsweeper.utils.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super();
    }
    public ResourceNotFoundException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
    public ResourceNotFoundException(String arg0) {
        super(arg0);
    }
    public ResourceNotFoundException(Throwable arg0) {
        super(arg0);
    }
}
