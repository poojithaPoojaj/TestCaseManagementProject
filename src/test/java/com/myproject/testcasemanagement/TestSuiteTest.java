package com.myproject.testcasemanagement;

import com.myproject.testcasemanagement.exceptions.DuplicateTestCaseException;
import com.myproject.testcasemanagement.exceptions.InvalidTestCaseException;
import com.myproject.testcasemanagement.models.TestCase;
import com.myproject.testcasemanagement.models.TestCaseCreator;
import com.myproject.testcasemanagement.models.TestCaseEditor;
import com.myproject.testcasemanagement.models.TestSuite;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.InvalidClassException;
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
        testSuite.store(testCase2);
    }

    @Test(expectedExceptions = InvalidTestCaseException.class)
    public void userIsGoingToGiveNotExistingTestCaseName() {
        TestCaseCreator testCaseCreator = new TestCaseCreator();
        List<String> stepsToReproduce = new ArrayList<>();
        stepsToReproduce.add("Give not existing testcase name to edit along with this new details to edit");
        stepsToReproduce.add("check for the testcase name in the testCasesList");
        stepsToReproduce.add("if testCase exist with the name we are going to edit and do changes");
        stepsToReproduce.add("else throwing exception 'testCase not exist with the name' ");

        TestCase testCase = testCaseCreator.createTest("helo", "desc", stepsToReproduce);
        TestSuite testSuite = new TestSuite();
        testSuite.store(testCase);
        TestCaseEditor testCaseEditor = new TestCaseEditor();
        testCaseEditor.editTestCase(testSuite,"hello", "helllllo", "des", stepsToReproduce);

    }
    @Test
    public void checkEditedDetails() {
        TestCaseCreator testCaseCreator = new TestCaseCreator();
        List<String> stepsToReproduce = new ArrayList<>();
        stepsToReproduce.add("Give not existing testcase name to edit along with this new details to edit");
        stepsToReproduce.add("check for the testcase name in the testCasesList");
        stepsToReproduce.add("if testCase exist with the name we are going to edit and do changes");
        stepsToReproduce.add("else throwing exception 'testCase not exist with the name' ");

        TestCase testCase = testCaseCreator.createTest("testname", "desc", stepsToReproduce);
        TestSuite testSuite = new TestSuite();
        testSuite.store(testCase);
        TestCaseEditor testCaseEditor = new TestCaseEditor();
        testCaseEditor.editTestCase(testSuite,"testname", "TestName", "descriptions",stepsToReproduce);
        Assert.assertEquals("TestName",testCase.getName());
        Assert.assertEquals("descriptions",testCase.getDescription());
        Assert.assertEquals(stepsToReproduce,testCase.getStepsToReproduce());
    }
    @Test
    public void userShouldNotProvideDuplicateNewNameWhileEditing(){
        TestCaseCreator testCaseCreator=new TestCaseCreator();
        List<String> stepsToReproduce=new ArrayList<>();
        stepsToReproduce.add("Create new TestCase");
        stepsToReproduce.add("add name ");
        stepsToReproduce.add("add description");
        stepsToReproduce.add("execute test");

        TestCase testCase1=testCaseCreator.createTest("Test1","This is description of test",stepsToReproduce);;

        TestCase testCase2=testCaseCreator.createTest("Test2","This is description of test",stepsToReproduce);

        TestSuite testSuite=new TestSuite();
        testSuite.store(testCase1);
        testSuite.store(testCase2);
        TestCaseEditor testCaseEditor = new TestCaseEditor();
        testCaseEditor.editTestCase(testSuite,"Test1", "Test1", "descriptions",stepsToReproduce);


    }
}
