# CucumberParallelScenarioRun_withMaven-Junit-TestNG--Rerun
***
The Cucumber BDD automation suite is designed based on Hybrid Framework with design patter[Page Object Model].

**IDE:** Intellij

**In this Framework, i implemented the following components:**
1. Feature Files
2. Step Definition Classes
3. Configuration Files
4. Cucumber Hooks with before and after
5. Element Utilities/Libraries/Generic Functions
6. Cucumber 6 Extent Report Adaptor for Spark HTML / PDF Reports
7. Test Runners in JUnit
8. Page Classes for POM
9. Maven with pom.xml with different dependencies and plugins
10. Parallel Execution
11. Cucumber 6 Web HTML Reports
12. Screenshot for Failure scenarios
13. Test Runners in TestNG
14. Step Definition Classes group in TestNG

**Technologies Used:**
1. Selenium WebDriver with Java Language binding
2. Cucumber 6.x JVM library
3. WebDriverManager
4. JDK 1.8
5. Maven (Build tool)
6. Maven Plugins
7. Cucumber extent report 6 adapter
8. JUnit 4.x library
9. TestNG
10.Pagefactory

**Suite Folder Structure:**
1. src/main/java			: This directory maintain the faremwork related to java files and application
	- com.auto.unit 		- here we creating webdriver, invoking browser & devices views using config property  
	- com.auto.util 		- common resuable methods based on webelements, action methods, appication managing methods, excel reader, DB connection/execution  
	- com.pageobjects 	- application pages are maintained as separate java file and each file has locators & activity methods
2. src/test/java			: Suite initiator will control the cucumber run
	- JUnit:AppHooks  	- While running test, Hooks help to maintain the Application or features related to pre-requiste and post-requiste 
	- JUnit:steps			- here we maintain the feature steps relate the scenarios
	- JUnit:TestRunner	- here we configure the cucumber runner which holds features files and reports and rerun scenarios
	- TestNG:parallel 	- its collection of Steps/Hooks(before&After)/Runners files for TestNG
3. src/test/resources
	- JUnit:config		- maintain faremwork test related details like browsername, app view based on devices
	- JUnit:features		- BDD features file where business person can update
	- TestNG:parallel 	- collection of feature file. need to maintain same foldername as steps - for TestNG. failrunner also there to rerun the fail test.
	- testdata			- test data are maintained in excel file(sheet wise)
	- extent.properties 	- Enviroment infomartion are updated for html/pdf report.
	- extent-config.xml	- enabled the features which are useful for report view
4. target/					- failed scenarios details are update here  which can be used for scenario rerun.
5. test reports/			- test run reports
	- Html				- here html reports are generated and saved 
	- pdf					- here pdf reports are generated and saved 
	- screenshots			- fail scenario screenshot are saved here
6. test-output-thread		- support for parallel execution
	- index.html			- can find the parallel execution reports based on threads sceanrio.
7. pom.xml					- implemented cucumber dependencies and plugin which are necessary for the suite.

***This project can enchance on the following topics:***
1. tagname implementation in feature file
2. skipping scenarios
3. SERENITY​ HTML Report
4. running test cases from Jenkins
5. running test cases on Dockerized Selenium GRID
6. create Makefile to configure the parallel runs 

***Test Scenario coverage:***
*GENERIC NOTE:* PHP travel application is not stable and sometimes loading homepage takes longer time.

| SCENARIO'S | AUTOMATED | COMMENTS | FEATURE FILE |
| ----- | ------ | ------ | ------ |
| Scenario 1 | **[Automated]**|Not able to login the assignment application with given credentails. so created new profile. Logged in with new user and update the profile & validated | **Login.feature** |
| Scenario 2 |  | Identifying restricted section for the non-login user is hard because application is not stable and takes long to load. | |
|Scenario 3| **[Automated]** | booked a hotel with roomtype and validate the accounts booking section | **Booking.feature** |
| Scenario 4|| I am not able to perform the scenario by manual testing and i felt dont have enough credentails.||
| Scenario 5|| CMS login is not working||

**Suite running commands**
run all features : 
```sh
mvn test
```
running regression set:
```sh
mvn test -Dcucumber.options="--tags @Regression"
```

***-MMM***
