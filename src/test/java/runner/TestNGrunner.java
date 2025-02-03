package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resource/features", glue = {
		"stepdef" },
plugin= {"pretty", // Designing the reports
		"html:reports/cucumber_report.html", // BDD Report
		"json:target/myjson.json", // Json report
		"junit:target/Cucumber.xml",// BDD report in XML format
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}//Extent report)//, tags = "@FilterSelection")
)
public class TestNGrunner extends AbstractTestNGCucumberTests{

}
