package scenario.test.scripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.objects.ScenarioThreePageObject;
import page.objects.ScenarioTwoPageObjects;

public class ScenarioThree {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void launchbrowser() {

		String exePath = "C:\\Users\\rahul\\eclipse-workspace\\Shopclues\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();

		driver.get("https://www.shopclues.com/");

		//maximizing window
		driver.manage().window().maximize();
	}
	@Test
	public void scenarioTwoTest() throws AWTException {
		ScenarioThreePageObject sp = new ScenarioThreePageObject(driver);
		
		sp.searcBOX("headphones");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		sp.CountOfSearchResults();
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
}


