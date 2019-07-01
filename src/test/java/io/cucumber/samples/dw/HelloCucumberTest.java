package io.cucumber.samples.dw;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;

public class HelloCucumberTest {

    @Test
    public void generateDemoReport() throws IOException {
//        File reportOutputDirectory = new File("target/demo");
//        List<String> jsonFiles = new ArrayList<>();
//        jsonFiles.add("target/json-report/do.json");
//
//        String buildNumber = "1";
//        String projectName = "dw";
//        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
//        configuration.setBuildNumber(buildNumber);
//
//        configuration.addClassifications("Browser", "Firefox");
//        configuration.addClassifications("Master", "release/1.0");
//        configuration.setSortingMethod(SortingMethod.NATURAL);
//        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
//        configuration.setTrendsStatsFile(new File("target/json-report/demo"));
//
//        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
//        reportBuilder.generateReports();
    }
}