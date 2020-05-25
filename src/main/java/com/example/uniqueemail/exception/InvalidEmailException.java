package com.example.uniqueemail.exception;

public class InvalidEmailException extends RuntimeException{

    public InvalidEmailException(String message)
    {
        super(message);
    }

    public InvalidEmailException(Throwable th)
    {
        super(th);
    }
}
