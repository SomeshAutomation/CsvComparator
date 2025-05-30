package com.veeva.csvfilecomparator;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {
                "pretty",
                "html:target/results/cucumber-reports.html",
                "json:target/results/cucumber.json",
                "junit:target/results/cucumber.xml",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "timeline:target/results/timeline"
        },
        glue = "com.veeva.csvfilecomparator",
        monochrome = true,
        tags = "@CsvComparison")
public class TestRunner {
}
