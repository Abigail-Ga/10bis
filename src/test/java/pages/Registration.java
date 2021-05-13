package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.xml.LaunchSuite.ExistingSuite;

public class Registration extends Base {

	public Registration(WebDriver driver) {
		super(driver);
	}

	// start Registration
	public boolean fill_registration(String fullName, String email, String phone) throws InterruptedException {

		driver.findElement(By.id("fullName")).sendKeys(fullName);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("cellPhone")).sendKeys(phone);

		WebElement box = driver.findElement(By.id("agreeToTerms"));
		box.click();
		Thread.sleep(1000);

		if (box.isSelected())
			return true;
		else
			return false;
	}

}
