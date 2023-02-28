package com.myproject.testcasemanagement.models;

import com.myproject.testcasemanagement.exceptions.DuplicateTestCaseException;
import com.myproject.testcasemanagement.exceptions.InvalidTestCaseException;

import java.util.List;

public class TestCaseFinder {

    public String findTestCase(TestSuite testSuite,String name){
        testSuite.sortListByName(testSuite);
        List<TestCase> testCaseList=testSuite.getTestCaseList();
         for(TestCase testCase:testCaseList){
             if(testCase.getName().equals(name))
             {
                 return testCase.getTestCaseInFormat(testCase);
             }
         }
         return "Test Case Not exist with the name";
    }
}
