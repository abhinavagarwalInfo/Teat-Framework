package awesomecucumber.utils;

import ru.yandex.qatools.allure.report.AllureReportBuilder;
import java.io.File;

public class onGenerateAllureReport {
        public void run() {
            try {
                new AllureReportBuilder("1.5.4", new File("target/allure-report")).unpackFace();
                new AllureReportBuilder("1.5.4", new File("target/allure-report")).processResults(new
                        File("C:/Workspace/Webdriver-Framework/allure-results"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
