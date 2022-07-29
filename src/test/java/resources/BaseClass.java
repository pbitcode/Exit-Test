package resources;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.Scenario;
import cucumber.runtime.ScenarioImpl;
import gherkin.formatter.model.Result;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class BaseClass extends AppiumAndroidResources{
	
	public static String Step;
	
	public String ScenarioName;
	
	//The following variable helps us in automatic logging of passed steps to the log and extent report
	public static boolean testStarted = false;
	
	//Method start all the Services needed for the test except Android Driver
	public void setup() {
		Step = "Loading Excel Files Data";
		ExcelManager.loadExcelFiles();
		
		Step = "Starting Logger";
		startLogger();
		
		Step = "Starting Extent Report";
		startExtentManager();
		
		Step = "Starting Appium";
		startAppium();
		
		Step = "Deleting Previous Screenshots";
		Screenshot.deleteScreenshots();
		
	}
	
	//Method start all the Services needed for the test except Android Driver
	public void teardown() {
		Step = "Stopping Appium";
		stopAppium();
		
		Step = "Stopping Extent Report";
		stopExtentManager();
	}
	
	//Method to extract the error information from Scenario object and call the fail method with 
	//errorMessage as its argument
	public void logError(Scenario scenario) {
		Field field = FieldUtils.getField(((ScenarioImpl) scenario).getClass(), "stepResults", true);
		field.setAccessible(true);
		try {
			ArrayList<Result> results = (ArrayList<Result>) field.get(scenario);
			
			for(Result result : results){
				if(result.getError()!=null) 
					fail(result.getErrorMessage());
			}
			
		}catch(Exception e) {
				e.printStackTrace();
		}
		
	}
	
	//Method to log START of a test in the Extent Report and the log file
	public void startTest(String TestName) {
		ScenarioName = TestName;
		extentStartTest(TestName);
		logStartTest(TestName);
	}
	
	//Method to log END of a test in the Extent Report and the log file
	public void endTest() {
		extentEndTest();
		logEndTest();
		testStarted = false;
	}
	
	//Method to get an Element by its Xpath
	//I did not return the webElement by converting it to MobileElement as it gave errors in some test cases
	public MobileElement getElement(String XPATH) {
		//wait Until the element is present
		webdriverwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH)));
		
		//Once the element is present, method returns the MobileElement
		return  driver.findElement(By.xpath(XPATH));
	}
	
	//Method to get an Element by its Xpath
	//I did not return the WebElement by converting it to MobileElement as it gave errors in some test cases
	public List<MobileElement> getElements(String XPATH) {
		//wait Until the elements are present
		webdriverwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(XPATH)));
		
		//Once the element is present, method returns the MobileElements List
		return driver.findElements(By.xpath(XPATH));
	}
	
	//Method Automatically logs the previous passed step to the log and the extent report files
	//while also storing the Current Step Details in the Step Variable 
	public void newStep(String NewStepDetails) {
		if(!testStarted) {
			Step = NewStepDetails;
			testStarted = true;
			return;
		}
		
		pass();
		Step = NewStepDetails;		
	}
	
	//Method to log a passed Step into the Log file and the Extent Report
	public void pass() {
		logInfo(Step);		//Log the passed step into the log file.
		extentPass(Step);	//Log the passed step into the Extent Report		
	}
	
	//Method to log information during a test to the Log and Extent Report file
	public void info(String message) {
		logInfo(message);		//Log the information into the log file.
		extentInfo(message);	//Log the information into the Extent Report
	}
	
	//Method to log a failed Step into the Log file and the Extent Report, and also call the ScreenShot method
	public void fail(String errorMessage) {
		logError("Failed - "+Step, errorMessage);		//Log the error Step and the Exception into the log file.
		extentError("Failed - "+Step, errorMessage);
		
		String FileName = ScenarioName + "-" + Step + ".png";		
		Screenshot.takeScreenshot(FileName);
	}
	
	//Method to wait for a certain time before proceeding further
	public void waitToLoad(long time) {
		try {
			Thread.sleep(time);
		}catch(Exception e) {}
	}
	
	//Method to press the back Button
	public void backbutton() {
		AndroidDriver<MobileElement> android_driver = (AndroidDriver<MobileElement>) driver;
		android_driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	//Method takes Starting Y Coordinate percentage(say y1), ending Y Coordinate percentage(say y2) and 
	//the X Coordinate percentage(say x) and Swipe from Coordinates (y1,X) to (y2,X) 
	public void verticalSwipeByPercentage (double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);
        new TouchAction(driver)
            .press(point(anchor, startPoint))
            .waitAction(waitOptions(ofMillis(1000)))
            .moveTo(point(anchor, endPoint))
            .release().perform();  
    }

}
