package com.myproject.testcasemanagement;

import com.myproject.testcasemanagement.exceptions.DuplicateTestCaseException;
import com.myproject.testcasemanagement.models.TestCase;
import com.myproject.testcasemanagement.models.TestCaseCreator;
import com.myproject.testcasemanagement.models.TestSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSuiteTest {
    @Test(expectedExceptions = DuplicateTestCaseException.class)
    public void userShouldNotAbleToCreateNewTestCaseWithDuplicateName(){
        TestCaseCreator testCaseCreator=new TestCaseCreator();
        List<String> stepsToReproduce=new ArrayList<>();
        stepsToReproduce.add("Create new TestCase");
        stepsToReproduce.add("add name ");
        stepsToReproduce.add("add description");
        stepsToReproduce.add("execute test");

        TestCase testCase1=testCaseCreator.createTest("Test1","This is description of test",stepsToReproduce);;

        TestCase testCase2=testCaseCreator.createTest("Test1","This is description of test",stepsToReproduce);


        TestSuite testSuite=new TestSuite();
        testSuite.store(testCase1);
        System.out.println(testCase1);
        testSuite.store(testCase2);
        System.out.println(testCase2);

    }
}
