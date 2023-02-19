package com.myproject.testcasemanagement.exceptions;

public class InvalidTestCaseException extends RuntimeException{
    public InvalidTestCaseException(String message){
        super(message);
    }
}
