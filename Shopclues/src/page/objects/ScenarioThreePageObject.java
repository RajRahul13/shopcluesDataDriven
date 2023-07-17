package page.objects;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScenarioThreePageObject {
	WebDriver driver;
	Logger logger=Logger.getLogger("ScenarioTwoPageObjects");
	
	@FindBy(xpath = "//button[@class='moe-chrome-style-notification-btn moe-btn-close moe-block-class']")
	WebElement DonnOTAllowBTN;
	
	@FindBy(xpath = "//*[@id='autocomplete']")
	WebElement searcBOX;
	
	@FindBy(xpath = "//*[@id='instdcnt']")
	WebElement CountOfSearchResults;
	
	public ScenarioThreePageObject(WebDriver d){
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void searcBOX(String prod) {
		searcBOX.sendKeys(prod);
	}
	
	public void CountOfSearchResults() {
		logger.info("Total count of product :"+ CountOfSearchResults.getText());
		logger.info("count value is greater than 0");
	}
}
