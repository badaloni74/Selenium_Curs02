package com.mesajapp.pageobjects;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions(/*glue="PORTALES", plugin = {"testng:target/testng-cucumber-reports/second/cuketestng.xml"},Ç*/
    features = "src/test/resources/features/google.feature", monochrome = true)
public class TestScenarios {
}
