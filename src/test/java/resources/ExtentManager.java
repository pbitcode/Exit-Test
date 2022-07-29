package resources;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentManager extends ExcelManager {
	
	static ExtentReports extrep;
	static ExtentTest extest;
	
	//Method to initialize the ExtentReports Object
	public void startExtentManager() {
		extrep = new ExtentReports(System.getProperty("user.dir")+ config.get("ExtentReportPath"), true);
		extrep.addSystemInfo("Host Name", config.get("Host Name"));
		extrep.addSystemInfo("Environment",config.get("Environment"));
		extrep.addSystemInfo("Username", config.get("Username"));
		extrep.loadConfig(new File(System.getProperty("user.dir")+config.get("ExtentReportConfigurationFilePath")));
	}
	
	//Method for the ExtentReports teardown
	public void stopExtentManager() {
		extrep.flush();
		extrep.close();
	}
	
	
	//Method to start an Extent Test
	public void extentStartTest(String TestName) {
		extest = extrep.startTest(TestName);
	}
	
	//Method to end a Test
	public void extentEndTest() {
		extrep.endTest(extest);
	}
	
	//Method to log a Passed Step in the Extent Report
	public void extentPass(String message) {
		extest.log(LogStatus.PASS, message);
	}
	
	//Method to log Information about the test in the Extent Report
	public void extentInfo(String message) {
		extest.log(LogStatus.INFO, message);
	}
	
	//Method to log the step along with the error Message
	public void extentError(String Step, String errorMessage) {
		extest.log(LogStatus.FAIL, Step);
		Exception ex = new Exception(errorMessage);
		extest.log(LogStatus.ERROR, ex);
	}

}
