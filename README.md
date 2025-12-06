# Selenium-TestNG-Hybrid-Framework
This repository contains a Selenium Test Automation Framework built with Java, TestNG, Maven, POM, and DDT. It follows industry-level best practices using Singleton and Factory patterns with reusable utilities. The framework automates the demo banking app at https://www.qaplayground.com/bank/ .

Selenium Test Automation Framework - SecureBankDemo

This is a Selenium Test Automation Framework designed for UI automation of SecureBankDemo
 using Java, TestNG, and Maven. The framework follows industry-level best practices, supporting cross-browser testing, data-driven testing (DDT), thread-safe driver management, and design patterns like Singleton and Factory.

# ✅ Key Features

Programming Language: Java

Test Framework: TestNG

Build & Dependency Management: Maven

Automation Design:

Page Object Model (POM)

Singleton Design Pattern (Thread-safe WebDriver)

Factory Design Pattern (Driver Factory)

Utilities Included:

ActionUtility – for advanced user actions

WaitUtility – for explicit & fluent waits

LogUtility – for logging events

ExtentReportUtility – for HTML reports with screenshots

DataProviders – for Excel/CSV data-driven testing

Reporting: Extent Reports stored in /reports folder at project root

# 🗂 Project Structure  High-level 
SecureBankDemo
│
├─ src
│  ├─ main
│  │  ├─ java
│  │  │  ├─ com.securebankdemo.pages        # Page classes
│  │  │  ├─ com.securebankdemo.utilities    # Utilities (Actions, Waits, Logging, Extent, DataProviders)
│  │  │  ├─ com.securebankdemo.driver       # DriverManager (Singleton + Factory)
│  │  │
│  │  └─ resources
│  │     └─ config.properties              # Config file (URL, browser, credentials)
│  │
│  └─ test
│     └─ java
│        ├─ com.securebankdemo.tests       # Test classes
│        └─ com.securebankdemo.base        # BaseTest class
│
├─ reports                                  # Extent reports & screenshots
├─ pom.xml                                  # Maven project descriptor
├─ testng.xml                               # TestNG suite configuration
└─ README.md

# ⚙ Browser & Parallel Execution

The framework supports cross-browser testing. The browser can be passed via:

Maven command line:

mvn test -Dbrowser=chrome
mvn clean test -Dbrowser=firefox


TestNG XML file:
Define <parameter name="browser" value="chrome"/> or <parameter name="browser" value="firefox"/>.
You can run tests:

Sequentially

Parallel by tests (cross-browser)

Parallel by classes or methods

# 🛠 How It Works

Driver Initialization:
DriverManager creates a thread-safe singleton WebDriver instance using Factory Pattern.

Page Object Model (POM):
Each page has a corresponding class with locators & reusable methods.

Data-Driven Testing (DDT):
DataProviders read Excel/CSV test data and inject into test methods using TestNG @DataProvider.

# Utilities:

ActionUtility – hover, drag-drop, right-click, etc.

WaitUtility – implicit, explicit, fluent waits

ExtentReportUtility – generate HTML reports with screenshots

LogUtility – console & file logs

# 💻 Running Tests

Using Maven:

mvn test                       # Runs default browser from config
mvn clean test -Dbrowser=chrome # Runs tests on Chrome
mvn clean test -Dbrowser=firefox # Runs tests on Firefox


Using TestNG XML:

<suite name="SecureBank Suite" parallel="tests" thread-count="2">
    <test name="Chrome Tests">
        <parameter name="browser" value="chrome"/>
        <classes>
            <class name="com.securebankdemo.tests.LoginTestes"/>
        </classes>
    </test>
    <test name="Firefox Tests">
        <parameter name="browser" value="firefox"/>
        <classes>
            <class name="com.securebankdemo.tests.LoginTestes"/>
        </classes>
    </test>
</suite>

# ⚡ Tools Used

Java – Programming language

Selenium WebDriver – Browser automation

TestNG – Test framework

Maven – Build & dependency management

Apache POI – Excel handling for DDT

ExtentReports – HTML reporting

Log4j / Custom Logger – Logging

Git & GitHub – Version control
