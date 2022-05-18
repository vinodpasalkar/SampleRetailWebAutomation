# SampleRetailWebAutomation

Sample UI automation of testscriptdemo site
This repo consists a customized automation framework for executing the test cases on web browser , 
the framework uses Serenity BDD libraries for integrating Jbehave and Selenium.
This maven project demonstrates various styles of writing jbehave scenarios within Serenity BDD framework


Please Install below
# Install java
# Install brew or home-brew:
# Install Maven


Set up instructions :

1. Download and install IntelliJ Idea Community version 

2. Clone the below repository in IntelliJ Idea : https://github.com/vinodpasalkar/SampleRetailWebAutomation (Just clone this project in InteliJ idea community Edition 
and Go to Menu > Build > Build Project Once the build is completed/compiled successfully)

3. Ensure you have maven installed in your system - command from terminal -> brew install maven

4. Install below IntelliJ plugins by going to below navigation ( This will help in code navigation)

IntelliJ Idea > Menu > IntelliJ Idea > Preferences > Plugins > Marketplace 

Search below plugins one by one and install them 
>Cucumber for java 
>Gherkin
>Jbehave BDD Plugin
>Jbehave Support 


5. Running your first test

Please download the appropriate chromedriver file depending on your OS type and provide correct path for the same in the serenity.properties file.

To execute a particular test by tag run below command on terminal by going to the project directory

mvn clean verify -Dmetafilter="+scenario name"

For e.g. In our framework to execute the scenario 001 , Execute below command

mvn clean verify -Dmetafilter="+001"

Multiple scenarios can be run with below command:

mvn clean verify -Dmetafilter="+001 && +002 && +003"

Meta filtering the stories/scenario mvn clean verify -Dmetafilter="+SmokeTest" -- This command will run the scenarios with the tag, "SmokeTest" This way we can use this on CI-CD by tagging the test case under the different tags like regression , smoke , sanity etc...

To see the Results after execution

Go to /Root directory/Reports/Today's date time For E.g the folder name will be "report - 09-11-2019_16-06-36" Every time you run a scenario or scenarios , it will generate the report folder with current date and time

Open index.html file in any browser to see the results.

Below are sample report snapshots

![screencapture-localhost-63342-SampleRetailWebAutomation-Reports-report-18-05-2022-23-02-42-9cd3e9850546fb126bf091f71329f8e4a4917c19f06f72692fd5528552b702e4-html-2022-05-18-23_07_33](https://user-images.githubusercontent.com/9302926/169169180-90d55bcc-78b9-4de9-8a1c-144308e26e39.jpg)

I have used serenity framework here.

Serenity documentation Below can be referred for a further reading on serenity libraries http://thucydides.info/docs/serenity-staging/

