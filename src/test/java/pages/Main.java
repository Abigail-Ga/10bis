package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.xml.LaunchSuite.ExistingSuite;

public class Main extends Base {

	public Main(WebDriver driver) {
		super(driver);
	}

	// start registration
	public boolean register() throws InterruptedException {

		if (isExist(By.xpath("//*[@id=\"wm-shoutout-337329\"]/div[1]")))
			click(By.xpath("//*[@id=\"wm-shoutout-337329\"]/div[1]"));

		
		click(By.xpath("//button[text()='הרשמה']"));
		if (isExist(By.id("modal-title")))
			return true;
		else
			return false;

	}
	
	// start login
		public boolean login() throws InterruptedException {
			
			
			if (isExist(By.xpath("//*[@id=\"wm-shoutout-337329\"]/div[1]")))
				click(By.xpath("//*[@id=\"wm-shoutout-337329\"]/div[1]"));

			//Click connection
			click(By.xpath("//button[text()='התחברות']"));
			
			if (isExist(By.xpath("//*[@id=\"modal-title\"][text()='איזה כיף שחזרת אלינו!']")))
				return true;
			else
				return false;

		}

	// select account
	public boolean selectAccount() throws InterruptedException {

		click(By.cssSelector("#other > div.question.first-question > div"));
		click(By.xpath(
				"//div[@class='dropdown custom-select step-one open']//li[@data-value='freelancer-or-smb'][@class='option']"));
		return true;
	}

}
