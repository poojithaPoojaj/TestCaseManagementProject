package com.myproject.testcasemanagement;

import com.myproject.testcasemanagement.models.TestCase;

import java.util.List;

public class TestCaseValidator {
    public boolean nameIsNotNullOrEmpty(String name){
        return  name!=null && !name.isEmpty();
    }
    public boolean nameShouldBeUnique(String name, List<TestCase> testCaseList){
        for(TestCase t:testCaseList){
            if(t.getName().equalsIgnoreCase(name))
                return false;
        }
        return true;
    }
}
