package com.myproject.testcasemanagement.models;

import com.myproject.testcasemanagement.exceptions.InvalidTestCaseException;

import java.util.List;

public class TestCaseRemover {

    public void removeTestCase(TestSuite testSuite,String name){
        if(testSuite.getAllTestCaseNamesList(testSuite).contains(name)){
            List<TestCase> testCases=testSuite.getTestCaseList();
            for(TestCase testCase:testCases){
                if(testCase.getName().equals(name))
                {
                    System.out.println(testCase.getName()+" "+testCase.getDescription());
                 testCases.remove(testCase);
                 return;
                }

            }
            System.out.println(testSuite.getAllTestCaseNamesList(testSuite));
        }
        else {
            throw new InvalidTestCaseException("Test Case not exist with the name to remove");
        }
    }
}
