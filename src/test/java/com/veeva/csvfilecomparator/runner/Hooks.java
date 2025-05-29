package com.veeva.csvfilecomparator.runner;

import io.cucumber.java.BeforeAll;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

@Slf4j
public class Hooks {
    public static Properties properties = new Properties();
    public static final String CONFIG_FILE_NAME = "config.properties";

    @BeforeAll
    public static void beforeAllSetUp() throws IOException {
        properties.load(Hooks.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME));
        log.info("in the Before All : config properties loaded");
    }
}
