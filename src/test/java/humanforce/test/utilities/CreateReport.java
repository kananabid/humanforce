package humanforce.test.utilities;


import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CreateReport {

    public static void make(String reportFolder) {
        File reportOutputDirectory = new File(reportFolder);
        if (!reportOutputDirectory.exists()) {
            reportOutputDirectory.mkdirs();
        }
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/Cucumber.json");
        String projectName = "Humanforce";
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
        configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
        configuration.addClassifications("Platform", "Chrome");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
    }


}