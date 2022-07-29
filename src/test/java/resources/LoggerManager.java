package resources;

import org.apache.log4j.Logger;

public class LoggerManager extends ExtentManager{
	
	static Logger logger;
	
	//Method to start the Logger
	public void startLogger() {
		System.setProperty("log4j.configurationFile",config.get("log4j.configurationFile"));
		logger = Logger.getLogger(LoggerManager.class);
	}
	
	//Method takes Test Details as argument and logs it to the Log File
	public void logStartTest(String TestName) {
		logger.info("New Test - "+ TestName);
	}
	
	//Method logs the END of the Test to the Log File
	public void logEndTest() {
		logger.info("-------------------------------------------- Test Ended --------------------------------------------");
	}
	
	//Method to log a message(usually a passed Step) to the Log File
	public void logInfo(String message) {
		logger.info(message);
	}
	
	//Method to log a failed Step along with its Error Message to the Log file
	public void logError(String step, String message) {
		logger.error(step);
		logger.info(message);
	}

}
