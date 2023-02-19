package com.myproject.testcasemanagement.exceptions;

public class DuplicateTestCaseException extends RuntimeException {
    public DuplicateTestCaseException(String name) {
        super("Test case already exist with the name " + name);
    }
}

