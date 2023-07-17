package scenario.test.scripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.objects.ScenarioOnePageObject;
import page.objects.ExcelUtility;

public class ScenarioOne {
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
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user,String mob)
	{
		ScenarioOnePageObject so = new ScenarioOnePageObject(driver);
		//so.DonnOTAllowBTNCLK();
		so.signInBTNCLK();
		so.RegisterBTNCLK();
	
		so.emailTXTbox(user);
		so.mobileTXTbox(mob);
		
		so.registerBTNCLK(); 
		
		so.emailERR();
		so.mobERR();
		
	}
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path="C:\\Users\\rahul\\eclipse-workspace\\Shopclues\\datafiles\\loginData.xlsx";
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);	
				
		String loginData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) 
		{
			for(int j=0;j<totalcols;j++)
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
				
		}
		
		return loginData;
	}


	@AfterClass
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
}
