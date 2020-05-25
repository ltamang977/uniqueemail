package com.example.uniqueemail.exception;

public class ErrorResponse {

    private Integer errorCode;
    private String errorMessage;
    private String errorDetails;

    public ErrorResponse(Integer errorCode, String errorMessage)
    {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ErrorResponse(Integer errorCode, String errorMessage, String errorDetails)
    {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDetails = errorDetails;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorDetails() {
        return errorDetails;
    }
}
