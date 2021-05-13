package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.xml.LaunchSuite.ExistingSuite;

public class Login extends Base {

	public Login(WebDriver driver) {
		super(driver);
	}

	// start login
	public boolean doLoginFacebook(String user, String password, String name, String location) throws InterruptedException {

		String baseHandle = driver.getWindowHandle();
		
		//Click facebook image
		click(By.xpath("//img[@type='facebook']"));
		
		//switch to Facebook login window
		
		Thread.sleep(1000);
		Set<String> handels = driver.getWindowHandles();

		for (String h : handels) {
			if (!h.equals(baseHandle))
				driver.switchTo().window(h);
		}

		//type user/password
		driver.findElement(By.id("email")).sendKeys(user);
		Thread.sleep(1000);

		driver.findElement(By.id("pass")).sendKeys(password);
		Thread.sleep(1000);
		click(By.name("login"));

		Thread.sleep(4000);
		
		driver.switchTo().window(baseHandle);

		//click(By.xpath("//img[@type='facebook']"));
		Thread.sleep(3000);

		//insert Location
		click(By.id("homePage_SelectAddress"));
		
		Actions action = new Actions(driver);
		action.sendKeys(location).build().perform();
		action.sendKeys(Keys.ENTER).build().perform();
		
		click(By.xpath("//*[@id=\"root\"]/div[2]//section[1]//button"));
		Thread.sleep(1000);
		
		String personalMsg = getText(By.cssSelector(".styled__PrimaryText-zzhidz-4.cfoTPh"));
		
		if (personalMsg.contains(name))
			return true;
		else
			return false;
		
	}
	
	public boolean verifyErrMsg() throws InterruptedException {
		click(By.id("email"));
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(1000);
		
		String err = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		
		if (err.equals("שדה חובה"))
			return true;
		else
			return false;
	}

}
