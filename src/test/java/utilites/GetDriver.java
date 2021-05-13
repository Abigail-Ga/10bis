package utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class GetDriver {

	

	// Method for getting WebDriver
	public static WebDriver getDriver(String browser) {
		WebDriver driver = null;

		if (browser.toLowerCase().equals("chrome")) {
			// Set the location of the Google Chrome driver exe file by set the system
			System.setProperty("webdriver.chrome.driver", "C:\\jars\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.toLowerCase().equals("firefox")) {
			// Set system property
			System.setProperty("webdriver.gecko.driver", "C:\\jars\\firefox\\geckodriver.exe");
			// Initialize web driver
			driver = new FirefoxDriver();
		}
		
		//add general wait for elements
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		// maximize window
		driver.manage().window().maximize();
		return driver;

	}
	
	
	// Method for getting WebDriver with get baseURL 
		public static WebDriver getDriver(String browser, String baseUrl) {
			WebDriver driver = null;

			if (browser.toLowerCase().equals("chrome")) {
				// Set the location of the Google Chrome driver exe file by set the system
				System.setProperty("webdriver.chrome.driver", "C:\\jars\\chrome\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.toLowerCase().equals("firefox")) {
				// Set system property
				System.setProperty("webdriver.gecko.driver", "C:\\jars\\firefox\\geckodriver.exe");
				// Initialize web driver
				driver = new FirefoxDriver();
			}
			
			//add general wait for elements
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			
			
			//add maximu time waiting for page to load
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			
			// maximize window
			driver.manage().window().maximize();
			
			//Get baseURL
			driver.get(baseUrl);
			return driver;

		}
		
		// Method for getting WebDriver with get baseURL + user data 
				public static WebDriver getDriver(String browser, String baseUrl, String user) {
					WebDriver driver = null;

					if (browser.toLowerCase().equals("chrome")) {
						// Set the location of the Google Chrome driver exe file by set the system
						System.setProperty("webdriver.chrome.driver", "C:\\jars\\chrome\\chromedriver.exe");

						ChromeOptions options = new ChromeOptions();
						
						if (user.toLowerCase().equals("incognito"))
							options.addArguments("--incognito");
						//else
							//options.addArguments("user-data-dir=C:/Users/UseR/AppData/Local/Google/Chrome/User Data2");
						
						driver = new ChromeDriver(options);
						
						
					} else if (browser.toLowerCase().equals("firefox")) {
						// Set system property
						System.setProperty("webdriver.gecko.driver", "C:\\jars\\firefox\\geckodriver.exe");
						// Initialize web driver
						driver = new FirefoxDriver();
					}
					
					//add general wait for elements
					driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
					
					
					//add maximu time waiting for page to load
					driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
					
					// maximize window
					driver.manage().window().maximize();
					
					//Get baseURL
					driver.get(baseUrl);
					return driver;

				}
				
				
		
	

}
