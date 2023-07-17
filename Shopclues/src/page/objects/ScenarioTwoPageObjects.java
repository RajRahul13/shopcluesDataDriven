package page.objects;

import java.util.Set;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScenarioTwoPageObjects {
	WebDriver driver;
	Logger logger=Logger.getLogger("ScenarioTwoPageObjects");
	
	@FindBy(xpath = "//button[@class='moe-chrome-style-notification-btn moe-btn-close moe-block-class']")
	WebElement DonnOTAllowBTN;
	
	@FindBy(xpath = "//*[@id='autocomplete']")
	WebElement searcBOX;
	
	@FindBy(xpath = "//*[@onclick='searchTrigger()']")
	WebElement searchBTN;
	
	@FindBy(xpath = "//*[@id=\"product_list\"]/div[3]/div[1]/a/h2")
	WebElement firstProd;
	
	@FindBy(xpath = "//*[@id=\"main_data\"]/div[2]/div[2]/h1")
	WebElement productName;
	
	@FindBy(xpath = "//*[@id=\"main_data\"]/div[2]/div[2]/div[2]/span[1]")
	WebElement productPrice;
	
	@FindBy(xpath = "//*[@id='instdcnt']")
	WebElement CountOfSearchResults;
	
	public ScenarioTwoPageObjects(WebDriver d){
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void DonnOTAllowBTN() {
		DonnOTAllowBTN.click();
	}
	public void searcBOX(String prod) {
		searcBOX.sendKeys(prod);
	}
	public void searchBTN() {
		searchBTN.click();
	}
	public void firstProd() {
		Set<String> windowHandles = driver.getWindowHandles();
		firstProd.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<String> updatedWindowHandles = driver.getWindowHandles();
	    updatedWindowHandles.removeAll(windowHandles);
	    for (String window: updatedWindowHandles) {
	        driver.switchTo().window(window);
	    	}
	}
	public void productName() {
		logger.info("First product displayed :"+productName.getText());
	}
	public void productPrice() {
		logger.info("First product displayed price :"+productPrice.getText());
	}
	public void CountOfSearchResults() {
		logger.info("Total count of product :"+ CountOfSearchResults.getText());
	}
	
}
