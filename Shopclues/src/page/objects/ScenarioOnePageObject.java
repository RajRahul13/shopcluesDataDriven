package page.objects;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScenarioOnePageObject {
	WebDriver driver;
	Logger logger=Logger.getLogger("ScenarioOnePageObject");
	
	@FindBy(xpath = "//button[@class='moe-chrome-style-notification-btn moe-btn-close moe-block-class']")
	WebElement DonnOTAllowBTN;
	
	@FindBy(xpath = "//li[@id='sign-in']")
	WebElement signInBTN;
	
	@FindBy(xpath = "//a[@id='reg_tab']")
	WebElement RegisterBTN;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement emailTXT;
	
	@FindBy(xpath = "//input[@name='phone']")
	WebElement mobileTXT;
	
	@FindBy(xpath = "//a[@id='register_button']")
	WebElement registerBTN;
	
	@FindBy(xpath = "//*[@id=\"register\"]/form/fieldset/div[2]/div/span")
	WebElement emailERR;
	
	@FindBy(xpath = "//*[@id=\"register\"]/form/fieldset/div[3]/div/span")
	WebElement mobERR;
	
	public ScenarioOnePageObject(WebDriver d){
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void DonnOTAllowBTNCLK() {
		DonnOTAllowBTN.click();
	}
	
	public void signInBTNCLK() {
		signInBTN.click();
	}
	
	public void RegisterBTNCLK() {
		RegisterBTN.click();
	}
	
	public void emailTXTbox(String email) {
		emailTXT.clear();
		emailTXT.sendKeys(email);
	}
	
	public void mobileTXTbox(String mobile) {
		mobileTXT.clear();
		mobileTXT.sendKeys(mobile);
	}
	
	public void registerBTNCLK() {
		registerBTN.click();
	}
	
	public void emailERR() {
		logger.info("Error got after wrong email input"+emailERR.getText());
	}
	
	public void mobERR() {
		logger.info("Error got after wrong mobile input"+mobERR.getText());
	}
}
