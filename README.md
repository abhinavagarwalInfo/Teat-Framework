# MasterSeleniumFramework_BDD
------------------------------------------------------------
**Framework features:**
1. Uses Domain objects
2. Support multiple Runners - TestNG, JUnit, CLI
3. Uses Dependency Injection Framework
4. Supports parallel execution
5. Uses API to setup the Application state
6. Captures screenshot on Scenario Failure
7. Supports command line execution using Maven
8. Supports CI/CD integration
------------------------------------------------------------
**Execution**
1. mvn clean test (This will execute with default env (Stg) and browser (Edge))
2. mvn clean test -Denv=INT -Dbrowser=firefox (his will execute with on Int and Firefox browser)
3. mvn clean test -Denv=INT -Dbrowser=firefox -Dcucumber.filter.tags@smoke (This will execute with on Int and Firefox browser and scenarios tagged as smoke)
------------------------------------------------------------
**Key Feature**
1. log4j
2. Cucumber reporting
3. Email reporting
4. allure reporting
5. slack notification - Pending
6. Multiple Browser support
7. Fail test cases screenshort
8. Browserstack integration
9. Headless Browser
10. Fail test case gif recording - Pending
11. Fail test case rerun - Pending
12. Fail test case direct log bug on Jira - Pending
------------------------------------------------------------
**chropath**
https://chromewebstore.google.com/detail/chropath/ljngjbnaijcbncmcnjfhigebomdlkcjo?hl=en&pli=1
------------------------------------------------------------
**Command to clear Allure report**
allure generate allure-results --clean -o allure-report
------------------------------------------------------------
**Create bashprofile**
1. touch ~/.bash_profile 
2. open -e ~/.bash_profile
------------------------------------------------------------
**Create New feature file**
1. User should navigate to src/test/resources/features
2. Create new feature file
3. Add scearios , Given, And and Then statements
------------------------------------------------------------
**Create New stepDefination file**
1. User should navigate to src/test/java/awesomecucumber/stepdefinitions
2. Create new stepDefination file
3. Make entry of new page under "PageFactoryManager"
------------------------------------------------------------
**Run Project**
1. Navigate to this file testng/testng.xml
2. Select class to run
3. Right click and run
------------------------------------------------------------
**Run on parallel execution**
1. Navigate to file src/test/java/awesomecucumber/runners/MyTestNGRunnerTest.java
2. @DataProvider(parallel = false) - parallel execution off
3. @DataProvider(parallel = true) - parallel execution on
------------------------------------------------------------
**How to update base url**
1. Navigate to src/test/resources/config/prod_config.properties file
2. Update baseUrl
------------------------------------------------------------
**HOW TO USE CONSTENT IN OTHER FILES**
import static awesomecucumber.constants.FrameworkConstants.*;
import static awesomecucumber.constants.FrameworkConstants.EXPLICIT_WAIT;
wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
------------------------------------------------------------

