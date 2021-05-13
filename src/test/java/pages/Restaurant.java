package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.xml.LaunchSuite.ExistingSuite;

public class Restaurant extends Base {

	public Restaurant(WebDriver driver) {
		super(driver);
	}

	// restaurant search
	public boolean verifySearch(String nameRest) throws InterruptedException {

		Thread.sleep(2000);
		// tab search and insert name of restaurant
		click(By.xpath("//*[@id=\"root\"]/div[2]/header/div[2]/div/div[4]/div/div[1]/input"));

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/header/div[2]/div/div[4]/div/div[1]/input"))
				.sendKeys(nameRest);
		Thread.sleep(2000);

		// click restaurant
		click(By.xpath("//div[@id=\"searchResults\"]/div/a[1]/div/div[1]/div"));
		if (isExist(By.cssSelector("styled__Img-h0boa1-0 ncRqM DiagonalHeaderView__CircleImage-lrita-3 hZTTFi")))
			return true;
		else
			return false;
	}

	// order page
	public boolean selectDish() throws InterruptedException {

		// click dish1
		click(By.id("dishName_1423097_0"));
		// click select dish
		click(By.xpath("//*[@id=\"modals\"]//div[contains(text(),'מנה')]"));
		Thread.sleep(2000);

		// click dish2
		click(By.id("dishName_1423108_0"));
		// click select dish
		click(By.xpath("//*[@id=\"modals\"]//div[contains(text(),'מנה')]"));
		Thread.sleep(2000);

		// click dish3
		click(By.cssSelector("#dishName_1423075_0"));
		Thread.sleep(2000);
		// click select dish
		click(By.xpath("//*[@id=\"modals\"]//div[contains(text(),'מנה')]"));

		Thread.sleep(4000);

		// Button of payment
		click(By.xpath("//*[@id=\"menu-body-wrapper\"]/div[2]/aside/div/div[2]/div[1]/button"));

		Thread.sleep(4000);

		if (isExist(By.xpath("//*[@id=\"root\"]/div[2]/div[1]//div/h1")))
			return true;
		else
			return false;
	}

	// restaurant search
	public boolean orderErrorMsg(String restName2) throws InterruptedException {

		Thread.sleep(3000);
		// click search
		click(By.xpath("//*[@id=\"root\"]/div[2]/header/div[2]/div/div[4]/div/div[1]/input"));
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/header/div[2]/div/div[4]/div/div[1]/input")).sendKeys(restName2);
		Thread.sleep(2000);
		
		click(By.xpath("//*[@id=\"searchResults\"]/div/a/div/div[1]/div"));
		Thread.sleep(2000);

		// choice dish
		click(By.xpath("//*[@id=\"dishName_2117081_0\"]/div"));
		Thread.sleep(2000);
		
		// button select dish
		click(By.xpath("//*[@id=\"modals\"]/div/div/div/div/div/div[4]/div/button/div"));
		Thread.sleep(2000);

		// button of payment
		click(By.xpath("//*[@id=\"menu-body-wrapper\"]/div[2]/aside/div/div[2]/div[1]/button"));
		
		Thread.sleep(1000);

		String errorMsg = driver.findElement(By.cssSelector("#modal-content > div:nth-child(1)")).getText();

		if (errorMsg.equals("ההזמנה שלך לא עברה את המינימום"))
			return true;
		else
			return false;
	}

}
