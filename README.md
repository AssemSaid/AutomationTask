# Automation Task
- This is project represents a testing scenario for some user actions on 'automationpractice' website
- It's a Maven Java project with Selenium Webdriver and Cucumber BDD
- Page Object Model (POM) design pattern is used to create an Object Repository for Web UI elements. Every page has its own locators and methods that interact with those locators to do specific actions on the browser
- Scenario steps are written in a simple english using Gherkin Syntax in the feature file

## Notes
- Test can be run on multiple browsers (IE, FireFox, Chrome) and on multiple platforms (Mac, Win, Linux). and user pass the browser name and platform name in the feature file (Given step). Default values are Chrome browser and Windows platform
- All inputs in the scenario like (first name, last name, email, password,..) are generated with methods in related page class (they change everytime the code runs). Those inputs aren't added as parameter as I believe the main scope of this scenario not to test the sign up functionality but testing adding items in Cart and check if the added items have the correct names and amounts
- The script has the capability to generate reports in the form of HTML, XML, JSON and pretty monochrome mode (can be checked in "target/cucumber-reports" directory)
- The script has the capability to generate logs descripting all steps done on the browser (can be checked in "logs" directory). Every log file is saved with the date/time (they don't overwrite each other)
- TestRunner class can be run from CLI as follows:
1. Navigate to project directory from command line
2. Then this command: mvn test
