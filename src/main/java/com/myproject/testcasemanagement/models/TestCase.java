package com.myproject.testcasemanagement.models;

import com.myproject.testcasemanagement.TestCaseValidator;
import com.myproject.testcasemanagement.exceptions.InvalidTestCaseException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class TestCase {
    public TestCase(){

    }
    public TestCase(String name, String description, List<String> stepsToReproduce) {
        this.name=name;
        this.description=description;
        this.stepsToReproduce=stepsToReproduce;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getStepsToReproduce() {
        return stepsToReproduce;
    }

    String name,description;
    List<String> stepsToReproduce;


    public void setDetails(TestCase testCase,String name,String description,List<String> stepsToReproduce){
        testCase.setName(name);
        testCase.setDescription(description);
        testCase.stepsToReproduce=stepsToReproduce;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStepsToReproduce(List<String> stepsToReproduce) {
        this.stepsToReproduce = stepsToReproduce;
    }

}
