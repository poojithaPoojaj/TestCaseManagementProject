package com.myproject.testcasemanagement.models;

import com.myproject.testcasemanagement.TestCaseValidator;
import com.myproject.testcasemanagement.exceptions.DuplicateTestCaseException;


import java.util.ArrayList;
import java.util.List;

public class TestSuite {
    private List<TestCase> testCaseList;
    public TestSuite(){
        testCaseList=new ArrayList<>();
    }
    public void store(TestCase testCase){
        if(new TestCaseValidator().nameShouldBeUnique(testCase.getName(),testCaseList)) {
            testCaseList.add(testCase);
        }
        else {
            throw new DuplicateTestCaseException(testCase.getName());
        }
    }

    public List<TestCase> getTestCaseList() {
        return testCaseList;
    }
}
