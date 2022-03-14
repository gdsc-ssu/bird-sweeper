package com.gdsc.birdsweeper.utils.exception;

public class AuthenticationEntryPointException extends RuntimeException {
    public AuthenticationEntryPointException() {
        super("AuthenticationEntryPointException");
    }
    public AuthenticationEntryPointException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
    public AuthenticationEntryPointException(String arg0) {
        super(arg0);
    }
    public AuthenticationEntryPointException(Throwable arg0) {
        super(arg0);
    }
}
