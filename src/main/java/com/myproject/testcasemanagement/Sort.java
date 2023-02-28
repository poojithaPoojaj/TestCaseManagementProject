package com.myproject.testcasemanagement;

import com.myproject.testcasemanagement.models.TestCase;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort
{
    public void sortByName(List<TestCase> testCaseList){
        Collections.sort(testCaseList, new Comparator<TestCase>() {

            public int compare(TestCase t1, TestCase t2) {
                return t1.getName().compareTo(t2.getName());

            }
        });
    }
    public void sortByPrority(List<TestCase> testCaseList){
        Collections.sort(testCaseList, new Comparator<TestCase>() {

            @Override
            public int compare(TestCase t1, TestCase t2) {
                return t1.getPriority()-t2.getPriority();
            }
        });
    }

}
