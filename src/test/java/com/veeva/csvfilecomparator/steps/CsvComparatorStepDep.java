package com.veeva.csvfilecomparator.steps;

import com.veeva.csvfilecomparator.utils.CommonFunction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import org.apache.commons.csv.CSVRecord;
import org.testng.asserts.SoftAssert;

public class CsvComparatorStepDep {

    private List<CSVRecord> firstFileRecords;
    private List<CSVRecord> secondFileRecords;
    private CommonFunction commonFunction;
    private SoftAssert softAssert;

    public CsvComparatorStepDep() {
        commonFunction = new CommonFunction();
    }

    @Given("user has csv file named {string}")
    public void userHasCsvFileNamed(String filename) {
        firstFileRecords = commonFunction.getCSVRecordList(filename);
    }

    @And("user has another csv file named {string}")
    public void userHasAnotherCsvFileNamed(String filename) {
        secondFileRecords = commonFunction.getCSVRecordList(filename);
    }

    @When("user compares two csv files")
    public void userComparesTwoCsvFiles() {

    }

    @Then("the system should identify differences")
    public void theSystemShouldIdentifyDifferences() {
        softAssert = new SoftAssert();
        int minRow = Math.min(firstFileRecords.size(), secondFileRecords.size());
        int i = 0;
        while (i < minRow) {
            softAssert = commonFunction.compareCSVRecord(firstFileRecords.get(i), secondFileRecords.get(i), softAssert);
            i++;
        }
        if (firstFileRecords.size() > secondFileRecords.size()) {
            softAssert.assertFalse(true, " Second/Actual File has less number of records ( Please check attachment for details)");
            commonFunction.attachText("Missing records are", firstFileRecords.subList(secondFileRecords.size(), firstFileRecords.size()).toString());

        } else if (firstFileRecords.size() < secondFileRecords.size()) {
            softAssert.assertFalse(true, " Second/Actual File has more number of records( Please check attachment for details)");
            commonFunction.attachText("Extra records are", secondFileRecords.subList(firstFileRecords.size(), secondFileRecords.size()).toString());
        }
        softAssert.assertAll();
    }
}
