package skeleton;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(plugin= {"pretty","html:src/cucumber-options"},features= {"src\\test\\resources\\skeleton\\CaseStudy1.feature"},monochrome=true,dryRun=false)
public class RunCucumber {

}






