package com.myproject.testcasemanagement.models;

import com.myproject.testcasemanagement.TestCaseValidator;
import com.myproject.testcasemanagement.exceptions.DuplicateTestCaseException;
import com.myproject.testcasemanagement.exceptions.InvalidTestCaseException;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCaseEditor {

    public void editTestCase(TestSuite testSuite,String editTestCaseName,String name, String description, List<String> stepsToReproduce){
        if(!new TestCaseValidator().nameIsNotNullOrEmpty(name)){
            throw new InvalidTestCaseException("Test Case not Should be empty or null");
        }
        if(new TestSuite().getAllTestCaseNamesList(testSuite).contains(name) && !editTestCaseName.equals(name)){
            throw new DuplicateTestCaseException(name);
        }
       for(TestCase testCase:testSuite.getTestCaseList()){
            if(testCase.getName().equals(editTestCaseName)){
               testCase.setDetails(testCase,name,description,stepsToReproduce);
                return;
            }
       }
    throw new InvalidTestCaseException("TestCase not exist with the name ");
    }
}
