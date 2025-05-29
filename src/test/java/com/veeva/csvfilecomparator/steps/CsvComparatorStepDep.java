package com.veeva.csvfilecomparator.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CsvComparatorStepDep {


    @Given("user has csv file named {string}")
    public void userHasCsvFileNamed(String filename) {
        System.out.println(filename);
    }

    @And("user has another csv file named {string}")
    public void userHasAnotherCsvFileNamed(String filename) {
        System.out.println(filename);

    }

    @When("user compares two csv files")
    public void userComparesTwoCsvFiles() {

    }

    @Then("the system should identify differences")
    public void theSystemShouldIdentifyDifferences() {
    }
}
