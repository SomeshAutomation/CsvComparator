package com.veeva.csvfilecomparator.utils;

import com.veeva.csvfilecomparator.runner.Hooks;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.util.List;

@Slf4j
public class CommonFunction {

    public List<CSVRecord> getCSVRecordList(String csvFileName) {
        Reader filereader = null;
        try {
            filereader = new FileReader(new File(Hooks.PROPERTIES.getProperty("testDataPath") + csvFileName));
            return CSVFormat.DEFAULT.parse(filereader).getRecords();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public SoftAssert compareCSVRecord(CSVRecord expectedRecord, CSVRecord actualRecord, SoftAssert softAssert) {
        String[] expectedValues = expectedRecord.values();
        String[] actualValues = actualRecord.values();
        int minLength = Math.min(expectedValues.length, actualValues.length);
        softAssert.assertEquals(actualRecord.getComment(), expectedRecord.getComment(), "Comments Mismatch for record number " + expectedRecord.getRecordNumber() + " : ");
        softAssert.assertEquals(actualValues.length, expectedValues.length, "Expected number of values in the record number " + expectedRecord.getRecordNumber() + " mismatch");
        for (int i = 0; i < minLength; i++) {
            softAssert.assertEquals(actualValues[i], expectedValues[i], "Mismatch for record number " + expectedRecord.getRecordNumber() + " at column " + (i + 1));
        }
        return softAssert;
    }

    public void attachText(String name, String content) {
        Allure.addAttachment(name, "text/plain", content);
    }
}
