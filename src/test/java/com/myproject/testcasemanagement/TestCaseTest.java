package com.myproject.testcasemanagement;

import com.myproject.testcasemanagement.exceptions.InvalidTestCaseException;
import com.myproject.testcasemanagement.models.TestCase;
import com.myproject.testcasemanagement.models.TestCaseCreator;
import com.myproject.testcasemanagement.models.TestCaseEditor;
import com.myproject.testcasemanagement.models.TestSuite;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCaseTest {
    @Test
    public void userShouldBeAbleToCreateTest(){
        TestCaseCreator testCaseCreator=new TestCaseCreator();
        List<String> stepsToReproduce=new ArrayList<>();
        stepsToReproduce.add("Create new TestCase");
        stepsToReproduce.add("add name ");
        stepsToReproduce.add("add description");
        stepsToReproduce.add("execute test");
       TestCase testCase= testCaseCreator.createTest("Test1","This is description of test",stepsToReproduce);
        Assert.assertEquals("Test1",testCase.getName());
        Assert.assertEquals("This is description of test",testCase.getDescription());
        Assert.assertEquals(stepsToReproduce,testCase.getStepsToReproduce());
    }
    @Test(expectedExceptions = InvalidTestCaseException.class)
    public void userShouldNotAbleToCreateTestWithEmptyValue(){
        TestCaseCreator testCaseCreator=new TestCaseCreator();
        List<String> stepsToReproduce=new ArrayList<>();
        stepsToReproduce.add("Create new TestCase");
        stepsToReproduce.add("add name ");
        stepsToReproduce.add("add description");
        stepsToReproduce.add("execute test");
       TestCase testCase= testCaseCreator.createTest("","This is description of test",stepsToReproduce);
        Assert.assertEquals("Test",testCase.getName());
        Assert.assertEquals("This is description of test",testCase.getDescription());
        Assert.assertEquals(stepsToReproduce,testCase.getStepsToReproduce());
    }
    @Test(expectedExceptions= InvalidTestCaseException.class)
    public void userShouldNotAbleToCreateTestWithNullValue(){
        TestCaseCreator testCaseCreator=new TestCaseCreator();
        List<String> stepsToReproduce=new ArrayList<>();
        stepsToReproduce.add("Create new TestCase");
        stepsToReproduce.add("add name ");
        stepsToReproduce.add("add description");
        stepsToReproduce.add("execute test");
       TestCase testCase=testCaseCreator.createTest(null,"This is description of test",stepsToReproduce);
        Assert.assertEquals("TEst1",testCase.getName());
        Assert.assertEquals("This is description of test",testCase.getDescription());
        Assert.assertEquals(stepsToReproduce,testCase.getStepsToReproduce());
    }
    @Test(expectedExceptions = InvalidTestCaseException.class)
    public void userShouldNotAbleToEditTestCaseWithNullAsNewName() {
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
        testCaseEditor.editTestCase(testSuite,"hello", null, "des", stepsToReproduce);
    }

    @Test(expectedExceptions = InvalidTestCaseException.class)
    public void userShouldNotAbleToEditTestCaseWithEmptyName() {
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
        testCaseEditor.editTestCase(testSuite,"hello", "", "des", stepsToReproduce);
    }


}
