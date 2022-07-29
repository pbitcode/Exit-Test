package resources;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot {	
	
	//Method to take ScreenShot in case a test fails
	public static void takeScreenshot(String FileName) {
		String FilePath = System.getProperty("user.dir") + ExcelManager.config.get("ErrorScreenshotFolder") + FileName;
		try {
			File file  = ((TakesScreenshot)AppiumAndroidResources.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(FilePath));
		}catch(Exception e) {
			System.out.println("Error Occured while taking Screenshot");
		}
	}
	
	//Method to delete previously taken screenshots.
	public static void deleteScreenshots() {
		File file = new File(ExcelManager.config.get("ErrorScreenshotFolder"));
		
		try {
			for(File subFile : file.listFiles())
				subFile.delete();
		}catch(Exception e) {
		}
		file.delete();			
	}
	

}
