package tests;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.Main;
import pages.Registration;
import utilites.GetDriver;
import utilites.Utilities;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;


public class RegistrationTest {

	// Global variables 
	// Add extent reports
	private ExtentReports extent;
	private ExtentTest myTest;
	private static String reportPaht = System.getProperty("user.dir") + "\\test-output\\reportRegistration.html";

	private WebDriver driver;
	private String baseUrl;
	
	
	//pages
	private Main main;
	private Registration registration;
	
	//Registration details:
	private final String fullName = "אליאב שרון";
	private final String mail = "testpro3645@test.com";
	private final String phone = "0547629478";

	private static final Logger logger = LogManager.getLogger(RegistrationTest.class);

	
	@BeforeClass
	public void beforeClass() throws ParserConfigurationException, SAXException, IOException {
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");

		extent = new ExtentReports(reportPaht);
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\resources\\extent-config.xml"));
		
		baseUrl = Utilities.getDataFromXML("info.xml", "website", 0);
		String browser =Utilities.getDataFromXML("info.xml", "browser", 0);;
		
		driver = GetDriver.getDriver(browser, baseUrl);
		
		main = new Main(driver);
		registration = new Registration(driver);

	}

	@BeforeMethod
	public void beforeMethod(Method method) throws IOException {
		myTest = extent.startTest(method.getName());
		myTest.log(LogStatus.INFO, "Starting test", "Start test");
	}
	
	
	/*  Prerequisite: getting into https://www.10bis.com/
	 * 		Given: Client is in site 
	 * 		When: click register link
	 *  	Then: Getting into Registration page
	 */
	
	@Test(priority = 1, enabled = true, description = "verify registration page")
	public void goToRegister() throws InterruptedException, IOException {
		logger.info("Going to registration page");
		Assert.assertTrue(main.register());
		logger.info("Successfully Get Register page");

	}
	
	
	/*  Prerequisite: getting into https://10bis.co.il, click Registration button
	 * 		Given: client is in registration page
	 * 		When: fill registration details
	 *  	Then: details are being typed
	 */
	
	@Test(dependsOnMethods = { "goToRegister" },  enabled = true, description = "verify insert details in registration page")
	public void fillRegistrationDetails() throws InterruptedException, IOException {
		logger.info("Begin to fill registration");
		Assert.assertTrue(registration.fill_registration(fullName, mail, phone));
		logger.info("Successfully Get Register page");

	}
	
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			myTest.log(LogStatus.FAIL, "Test failed: " + result.getName());
			myTest.log(LogStatus.FAIL, "Test failed reason: " + result.getThrowable());
			myTest.log(LogStatus.FAIL, myTest.addScreenCapture(Utilities.takeScreenShot(driver)));
		}
		else {
			myTest.log(LogStatus.PASS, result.getName(), "Verify successful ");
			myTest.log(LogStatus.PASS, myTest.addScreenCapture(Utilities.takeScreenShot(driver)));

		}

		myTest.log(LogStatus.INFO, "Finish test", "Finish test ");
		extent.endTest(myTest);
	
		//return to base URL 
		//driver.get(baseUrl);
	}

	@AfterClass
	public void afterClass() {
		extent.flush();
		extent.close();
		driver.quit();

	}
	
}
