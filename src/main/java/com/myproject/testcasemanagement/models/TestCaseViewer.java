package com.myproject.testcasemanagement.models;


import java.util.List;

public class TestCaseViewer  {


     public List<String> sortAndGetAllTestsInFormat(TestSuite testSuite){
          testSuite.sortListByName(testSuite);
          return testSuite.getFormattedTestCaseList(testSuite);
     }
}
