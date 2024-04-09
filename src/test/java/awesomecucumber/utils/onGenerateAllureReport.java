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

        public void ExecuteCommand(){
            try {
                String pathCommand = "cd /Users/abhinavagarwal/workspace/Web-Teat-Framework/"; // Example command: list files in current directory
                Process process = Runtime.getRuntime().exec(pathCommand);
                int exitCode = process.waitFor();
                System.out.println("Exited with error code: " + exitCode);

                String AllureReportCommand = "allure generate allure-results --clean -o allure-report"; // Create Allure Report in allure-report folder
                Process process1 = Runtime.getRuntime().exec(AllureReportCommand);
                int exitCode1 = process1.waitFor();
                System.out.println("Exited with error code: " + exitCode1);

                String AllureResultCommand = "allure serve allure-results"; // Create report
                Process process2 = Runtime.getRuntime().exec(AllureResultCommand);
                int exitCode2 = process2.waitFor();
                System.out.println("Exited with error code: " + exitCode2);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
}
