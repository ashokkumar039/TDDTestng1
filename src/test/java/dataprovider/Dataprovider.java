package dataprovider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {
	public WebDriver driver = null;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "./BrowserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider="testdata")
	public void login(String uid, String pass) throws InterruptedException
	{
		driver.get("https://demo.guru99.com/V1/index.php");
		driver.findElement(By.name("uid")).sendKeys(uid);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("btnLogin")).click();
		try {
			driver.switchTo().alert().accept();
		}
		catch(Exception e)
		{
			
		}
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
	}

	@DataProvider(name="testdata")
	public Object[][] Testdata()
	{
		Object[][] data = new Object[3][2];
		data[0][0] = "mngr402287";
		data[0][1] = "erunytu";
		
		data[1][0] = "mcdsc4612";
		data[1][1] = "vsdvcsUt";
		
		data[2][0] = "asdfq4612";
		data[2][1] = "2342rmUt";
		
		return data;
	}
	
	@AfterTest
	public void exit()
	{
		if(driver != null)
		{
			driver.close();
		}
	}
}
