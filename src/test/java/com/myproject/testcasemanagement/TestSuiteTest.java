package com.myproject.testcasemanagement;

import com.myproject.testcasemanagement.exceptions.DuplicateTestCaseException;
import com.myproject.testcasemanagement.exceptions.InvalidTestCaseException;
import com.myproject.testcasemanagement.models.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.List;

public class TestSuiteTest {
    @Test(expectedExceptions = DuplicateTestCaseException.class)
        public void userShouldNotAbleToCreateNewTestCaseWithDuplicateName() {
        TestCaseCreator testCaseCreator = new TestCaseCreator();
        List<String> stepsToReproduce = new ArrayList<>();
        stepsToReproduce.add("Create new TestCase");
        stepsToReproduce.add("add name ");
        stepsToReproduce.add("add description");
        stepsToReproduce.add("execute test");

        TestCase testCase1 = testCaseCreator.createTest("Test1", "This is description of test", stepsToReproduce);
        ;

        TestCase testCase2 = testCaseCreator.createTest("Test1", "This is description of test", stepsToReproduce);

        TestSuite testSuite = new TestSuite();
        testSuite.store(testCase1);
        testSuite.store(testCase2);
    }

    @Test(expectedExceptions = InvalidTestCaseException.class)
    public void userIsNotAbleToGiveNotExistingTestCaseName() {
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
        testCaseEditor.editTestCase(testSuite, "hello", "helllllo", "des", stepsToReproduce);

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
        testCaseEditor.editTestCase(testSuite, "testname", "TestName", "descriptions", stepsToReproduce);
        Assert.assertEquals("TestName", testCase.getName());
        Assert.assertEquals("descriptions", testCase.getDescription());
        Assert.assertEquals(stepsToReproduce, testCase.getStepsToReproduce());
    }

    @Test
    public void userShouldNotProvideDuplicateNewNameWhileEditing() {
        TestCaseCreator testCaseCreator = new TestCaseCreator();
        List<String> stepsToReproduce = new ArrayList<>();
        stepsToReproduce.add("Create new TestCase");
        stepsToReproduce.add("add name ");
        stepsToReproduce.add("add description");
        stepsToReproduce.add("execute test");

        TestCase testCase1 = testCaseCreator.createTest("Test1", "This is description of test", stepsToReproduce);
        ;

        TestCase testCase2 = testCaseCreator.createTest("Test2", "This is description of test", stepsToReproduce);

        TestSuite testSuite = new TestSuite();
        testSuite.store(testCase1);
        testSuite.store(testCase2);
        TestCaseEditor testCaseEditor = new TestCaseEditor();
        testCaseEditor.editTestCase(testSuite, "Test1", "Test1 ", "descriptions", stepsToReproduce);

    }

    @Test
    public void userShouldProvideValidTestCaseNameToDelete() {
        TestCaseCreator testCaseCreator = new TestCaseCreator();
        List<String> stepsToReproduce = new ArrayList<>();
        stepsToReproduce.add("Create new TestCase");
        stepsToReproduce.add("add name ");
        stepsToReproduce.add("add description");
        stepsToReproduce.add("add steps to reproduce");
        stepsToReproduce.add("add few new Test Cases");
        stepsToReproduce.add("search for the test case with the name to delete");
        stepsToReproduce.add("delete test case");
        TestCase testCase = testCaseCreator.createTest("Test1", "This is description of test", stepsToReproduce);
        TestSuite testSuite = new TestSuite();
        testSuite.store(testCase);
        TestCaseRemover testCaseRemover = new TestCaseRemover();
        testCaseRemover.removeTestCase(testSuite, "Test12");

    }
    @Test
    public void checkDeletedTestCase(){
        TestCaseCreator testCaseCreator = new TestCaseCreator();
        List<String> stepsToReproduce = new ArrayList<>();
        stepsToReproduce.add("Create new TestCase");
        stepsToReproduce.add("add name ");
        stepsToReproduce.add("add description");
        stepsToReproduce.add("add steps to reproduce");
        stepsToReproduce.add("search for the test case with the name to delete");
        stepsToReproduce.add("delete test case");
        TestCase testCase1 = testCaseCreator.createTest("Test1", "This is description of test", stepsToReproduce);
        TestSuite testSuite = new TestSuite();
        testSuite.store(testCase1);
        TestCase testCase2 = testCaseCreator.createTest("Test2", "This is description of test", stepsToReproduce);
        testSuite.store(testCase2);
        TestCaseRemover testCaseRemover = new TestCaseRemover();
        testCaseRemover.removeTestCase(testSuite,"Test1");
        Assert.assertFalse(testSuite.getAllTestCaseNamesList(testSuite).contains("Test1"));
    }
    @Test
    public void viewAllTestCasesInOrder(){
        TestCaseCreator testCaseCreator = new TestCaseCreator();
        List<String> stepsToReproduce = new ArrayList<>();
        stepsToReproduce.add("Create new TestCase");
        stepsToReproduce.add("add name ");
        stepsToReproduce.add("add description");
        stepsToReproduce.add("add steps to reproduce");
        stepsToReproduce.add("Again add few new TestCases");
        stepsToReproduce.add("sort and display all testCases and compare with the test");
        TestCase testCase1 = testCaseCreator.createTest("TestC", "This is description of test", stepsToReproduce);
        TestSuite testSuite = new TestSuite();
        testSuite.store(testCase1);
        TestCase testCase2 = testCaseCreator.createTest("TestD", "This is description of test", stepsToReproduce);
        testSuite.store(testCase2);
        TestCase testCase3 = testCaseCreator.createTest("TestA", "This is description of test", stepsToReproduce);
        testSuite.store(testCase3);
        TestCase testCase4 = testCaseCreator.createTest("TestB", "This is description of test", stepsToReproduce);
        testSuite.store(testCase4);
         TestCaseViewer testCaseViewer=new TestCaseViewer();

         List<String> formattedTestCases=testCaseViewer.sortAndGetAllTestsInFormat(testSuite);
        Assert.assertEquals("Name:TestA , Description:This is description of test ," +
                " StepsToReProduce:[ Create new TestCase , add name  , add description , add steps to reproduce , " +
                "Again add few new TestCases , sort and display all testCases and compare with the test  ]",
                formattedTestCases.get(0));
        Assert.assertEquals("Name:TestB , Description:This is description of test ," +
                " StepsToReProduce:[ Create new TestCase , add name  , add description , add steps to reproduce ," +
                " Again add few new TestCases , sort and display all testCases and compare with the test  ]",
                formattedTestCases.get(1));
        Assert.assertEquals("Name:TestC , Description:This is description of test , " +
                "StepsToReProduce:[ Create new TestCase , add name  , add description , add steps to reproduce , " +
                "" + "Again add few new TestCases , sort and display all testCases and compare with the test  ]",
                formattedTestCases.get(2));
        Assert.assertEquals("Name:TestD , Description:This is description of test ," +
                " StepsToReProduce:[ Create new TestCase , add name  , add description , add steps to reproduce , " +
                "Again add few new TestCases , sort and display all testCases and compare with the test  ]",
                 formattedTestCases.get(3));


    }
    @Test
    public void searchTestwithValidTestName(){
        TestCaseCreator testCaseCreator = new TestCaseCreator();
        List<String> stepsToReproduce = new ArrayList<>();
        stepsToReproduce.add("Create new TestCase");
        stepsToReproduce.add("add name ");
        stepsToReproduce.add("add description");
        stepsToReproduce.add("add steps to reproduce");
        stepsToReproduce.add("add few new Test Cases");
        stepsToReproduce.add("sort and search for testCase and compare with the test");
        TestCase testCase1 = testCaseCreator.createTest("TestC", "This is description of test", stepsToReproduce);
        TestSuite testSuite = new TestSuite();
        testSuite.store(testCase1);
        TestCase testCase2 = testCaseCreator.createTest("TestD", "This is description of test", stepsToReproduce);
        testSuite.store(testCase2);
        TestCase testCase3 = testCaseCreator.createTest("TestA", "This is description of test", stepsToReproduce);
        testSuite.store(testCase3);
        TestCase testCase4 = testCaseCreator.createTest("TestB", "This is description of test", stepsToReproduce);
        testSuite.store(testCase4);
        TestCaseFinder testCaseFinder=new TestCaseFinder();
        String testCaseInFormat=testCaseFinder.findTestCase(testSuite,"TestD");
        Assert.assertEquals("Name:TestD , Description:This is description of test , " +
                "StepsToReProduce:[ Create new TestCase , add name  , add description , add steps to reproduce , " +
                "add few new Test Cases , sort and search for testCase and compare with the test  ]",
                testCaseInFormat);

    }

}
