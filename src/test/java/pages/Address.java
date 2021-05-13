package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.xml.LaunchSuite.ExistingSuite;

public class Address extends Base {

	public Address(WebDriver driver) {
		super(driver);
	}

	// start Registration
	public boolean addAddress() throws InterruptedException {

		Thread.sleep(3000);
		//button search address
		click(By.xpath("//*[@id=\"root\"]/div[2]/header/div[2]/div/div[2]/div/div/button/div[2]/div"));
		Thread.sleep(2000);
		
		//button to Add location
		click(By.xpath("//*[@id=\"dropdown-content\"]/div/div/div/div[2]/button"));
		Thread.sleep(3000);
		
		//click Enter an address
		click(By.xpath("//input[@id=\"homePage_SelectAddress\"]"));
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		
		Thread.sleep(3000);
		//contains Israel in address
		String localName = getText(By.xpath("//input[@id=\"homePage_SelectAddress\"]"));
		
		if(localName.contains("ישראל"))
			return true;
		else
			return false;
	}

}
