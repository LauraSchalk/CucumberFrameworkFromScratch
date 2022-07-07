package com.test.openmrs.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "target/uiFailedTests.txt",
        glue = {"com/test/openmrs/stepdefinitions","com/test/openmrs/hook"},
        dryRun = false,
        tags = "@smoke",
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)

public class OpenMrs_ReRunner {
}
