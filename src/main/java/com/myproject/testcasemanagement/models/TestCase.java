package com.myproject.testcasemanagement.models;

import com.myproject.testcasemanagement.TestCaseValidator;
import com.myproject.testcasemanagement.exceptions.InvalidTestCaseException;

import java.util.List;

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

}
