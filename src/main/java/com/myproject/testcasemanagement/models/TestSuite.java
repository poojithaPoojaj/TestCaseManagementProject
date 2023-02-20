package com.myproject.testcasemanagement.models;

import com.myproject.testcasemanagement.Sort;
import com.myproject.testcasemanagement.TestCaseValidator;
import com.myproject.testcasemanagement.exceptions.DuplicateTestCaseException;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestSuite {
    private List<TestCase> testCaseList;
    private List<String> formatTestCaseList;

    public TestSuite() {
        testCaseList = new ArrayList<>();
        formatTestCaseList = new ArrayList<>();
    }

    public void store(TestCase testCase) {
        if (new TestCaseValidator().nameShouldBeUnique(testCase.getName(), testCaseList)) {
            testCaseList.add(testCase);
        } else {
            throw new DuplicateTestCaseException(testCase.getName());
        }
    }

    public List<TestCase> getTestCaseList() {
        return testCaseList;
    }

    public List<String> getAllTestCaseNamesList(TestSuite testSuite) {
        List<String> testCaseNamesList = new ArrayList<>();
        for (TestCase testCase : testSuite.getTestCaseList()) {
            testCaseNamesList.add(testCase.getName());
        }
        return testCaseNamesList;
    }

    public void sortListByName(TestSuite testSuite) {
        new Sort().sortByName(testSuite.getTestCaseList());
    }

    public List<String> getFormattedTestCaseList(TestSuite testSuite) {
        for (TestCase testCase : testSuite.getTestCaseList()) {
            String steps = "";
            for (String s : testCase.getStepsToReproduce()) {
                steps += s;
                steps += " , ";
            }
            formatTestCaseList.add(String.format("Name:%s , Description:%s , StepsToReProduce:[ %s ]", testCase.getName(), testCase.getDescription(), steps.substring(0, steps.length() - 2)));

        }
        return formatTestCaseList;
    }
}
