package scenario.test.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.objects.ScenarioTwoPageObjects;

public class ScenarioTwo {
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
	public void scenarioTwoTest() {
		ScenarioTwoPageObjects sb = new ScenarioTwoPageObjects(driver);
		//sb.DonnOTAllowBTN();
		sb.searcBOX("nike shoes");
		sb.searchBTN();
		sb.CountOfSearchResults();
		sb.firstProd();
		sb.productName();
		sb.productPrice();
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
}
