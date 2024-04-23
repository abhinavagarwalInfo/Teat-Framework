# Selenium Automation Framework with Cucumber BDD

## Overview
This repository contains a robust and scalable automation framework built using Selenium WebDriver and Cucumber for automating web applications. The framework is designed to provide a structured approach to automate web UI testing using Behavior-Driven Development (BDD) principles.
## Features
- _Modular Architecture:_ The framework follows a modular approach, allowing easy maintenance and scalability.
- _Page Object Model (POM):_ Implements the Page Object Model design pattern to enhance code reusability and maintainability.
- _Cucumber Integration:_ Utilizes Cucumber for defining test scenarios in a human-readable format (Gherkin syntax) and running tests.
- _TestNG Integration:_ Integrates with TestNG for test case management, parallel execution, and reporting.
- _Logging and Reporting:_ Integrated with logging frameworks like Log4j and reporting tools like ExtentReports for comprehensive test reporting.
- _Configuration Management:_ Centralized configuration management using properties files for easy configuration changes.
- _Cross-browser Testing:_ Supports cross-browser testing on major browsers like Chrome, Firefox, and Safari.
- _Parallel Execution:_ Enables parallel execution of tests to reduce overall execution time.
- _Screenshot Capture:_ Automatically captures screenshots on test failure for better debugging and reporting.
- _CI/CD Integration:_ Seamlessly integrates with popular CI/CD tools like Jenkins for continuous testing.

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- Maven
- WebDriver executables for target browsers (ChromeDriver, GeckoDriver, etc.)
- IDE (Eclipse, IntelliJ IDEA, etc.)

## Getting Started
- _Clone the repository:_ `git clone https://github.com/abhinavagarwalInfo/Teat-Framework`
- _Import the project:_ Import the project into your preferred IDE.
- _Install dependencies:_ Execute `mvn clean install` to install all project dependencies.
- _Update configuration:_ Update config.properties file with necessary configurations like browser type, URL, etc.
- _Run tests:_ Execute Cucumber feature files using TestNG or your IDE's test runner.

## Project Structure
```
├── README.md
├── Webdriver-Framework.iml
├── pom.xml
├── src
│   ├── main
│   │   └── resources
│   │       └── log4j2.xml
│   └── test
│       ├── java
│       │   └── awesomecucumber
│       │       ├── apis
│       │       ├── constants
│       │       ├── context
│       │       ├── customtype
│       │       ├── domainobjects
│       │       ├── enums
│       │       ├── factory
│       │       ├── hooks
│       │       ├── java_Mail_API
│       │       ├── pages
│       │       ├── runners
│       │       ├── stepdefinitions
│       │       └── utils
│       └── resources
│           ├── config
│           │   ├── int_config.properties
│           │   ├── prod_config.properties
│           │   ├── qa_config.properties
│           │   └── stg_config.properties
│           ├── cucumber.properties
│           ├── features
│           │   └── login_to_app.feature
│           └── products.json
└── testng
    └── testng.xml
```
## Running Tests
- _Using TestNG:_ Right-click on test suite XML file or test class, then select `"Run As" > "TestNG Test"`.
- _Using Cucumber:_ Execute feature files using Cucumber test runner.

## Reporting
>Test execution reports are generated in HTML format using ExtentReports or Cucumber's built-in >reporting. Reports are saved under the target directory.

## Installation
```sh
$ brew install allure
```

## Plugins
> To identify the locatoers of the web-elements, install chrome browser expension `ChroPath`


------------------------------------------------------------
------------------------------------------------------------





# Test-Framework
With further updates - This project is designed and developed with the help of -
1. Udemy course (OmPrakash Chavan - Cucumber BDD Masterclass with Selenium WebDriver & Java) - 
[Learnings From Course.pdf](https://github.com/rajatt95/MasterSeleniumFramework_BDD/files/7998307/Learnings.From.Course.pdf)
![image](https://user-images.githubusercontent.com/26399692/152515639-83ff0b6e-3148-4c4c-821b-491c4d1f415e.png)
![image](https://user-images.githubusercontent.com/26399692/152515700-e7f086cf-4ed9-469c-b65c-51aeb841e783.png)
![image](https://user-images.githubusercontent.com/26399692/152515746-35b19cb5-9fcc-4304-9abd-1e9b872bf18f.png)

![image](https://user-images.githubusercontent.com/26399692/152515304-c933c4e0-f085-4b60-be3d-144caf9d9054.png)
![image](https://user-images.githubusercontent.com/26399692/152515549-abcc6a1e-4d54-4eba-b741-8b1910aee102.png)

<img width="717" alt="Screenshot by Snip My at 04-Feb-2022 at 2_41_05 AM" src="https://user-images.githubusercontent.com/26399692/152430606-3a88d967-4ebd-4976-a601-c75f2477d79d.png">

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
It has a concept of Atomic tests (Achieved by Selenium WebDriver API and RestAssured API)
------------------------------------------------------------
# Atomic Tests:
![image](https://user-images.githubusercontent.com/26399692/138962929-70094e77-ff3c-405e-95f8-c91c4e0912a6.png)
------------------------------------------------------------
Updations done:
------------------------------------------------------------
**Reports (me.jvt.cucumber -> reporting-plugin) ** 
![image](https://user-images.githubusercontent.com/26399692/152516617-160ec7de-c330-490e-9cb9-78b7d50cbe5d.png)
------------------------------------------------------------
**Screenshot on failure to Reports** 
![image](https://user-images.githubusercontent.com/26399692/152516718-701a6cc9-bf46-475f-824f-406413fa8288.png)
------------------------------------------------------------
**Zip reports**
------------------------------------------------------------
**Browser instances from pom.xml**
![image](https://user-images.githubusercontent.com/26399692/152516862-973ca6e9-bf4e-45de-85f5-f7fba24f4927.png)
------------------------------------------------------------
**Execution**
1. mvn clean test (This will execute with default env (Stg) and browser (Edge))
2. mvn clean test -Denv=INT -Dbrowser=firefox (his will execute with on Int and Firefox browser)
3. mvn clean test -Denv=INT -Dbrowser=firefox -Dcucumber.filter.tags@smoke (This will execute with on Int and Firefox browser and scenarios tagged as smoke)
------------------------------------------------------------

[Cucumber_Reports_Local.pdf](https://github.com/rajatt95/MasterSeleniumFramework_BDD/files/7998343/Cucumber_Reports_Local.pdf)
![image](https://user-images.githubusercontent.com/26399692/152431537-75cab046-67a6-4387-a980-f3dc19031f5c.png)
------------------------------------------------------------
[Cucumber_Reports_Cloud.pdf](https://github.com/rajatt95/MasterSeleniumFramework_BDD/files/7998338/Cucumber_Reports_Cloud.pdf)
![image](https://user-images.githubusercontent.com/26399692/152431482-e010a8c0-25b8-425f-be92-83d0f9a52fb2.png)

