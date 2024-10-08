package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"featureFiles/Employee.feature"},
tags = {"@employee"}
,dryRun = false
,glue = {"stepDefination1"}
)

public class AddEmployee {
	
}
 