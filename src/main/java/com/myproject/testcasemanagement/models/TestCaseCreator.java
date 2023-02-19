package com.myproject.testcasemanagement.models;

import com.myproject.testcasemanagement.TestCaseValidator;
import com.myproject.testcasemanagement.exceptions.InvalidTestCaseException;

import java.util.List;

public class TestCaseCreator {
    public TestCase createTest(String name, String description, List<String> stepsToReproduce){
        if(new TestCaseValidator().nameIsNotNullOrEmpty(name)){
        }
        else {
            throw new InvalidTestCaseException("Test Case Name should not be empty or null");
        }

        return new TestCase(name,description,stepsToReproduce);
    }
}
