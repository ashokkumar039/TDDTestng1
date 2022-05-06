package Loginpage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	
	public static WebDriver driver = null;
	
	@BeforeTest
	public void blogin()
	{
		System.setProperty("webdriver.chrome.driver", "./BrowserDriver/chromedriver.exe");
		ChromeOptions c = new ChromeOptions();
		c.addArguments("--incognito");
		DesiredCapabilities d = DesiredCapabilities.chrome();
		d.setCapability(ChromeOptions.CAPABILITY, c);
		driver = new ChromeDriver(c);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	}
	
	@Test(priority=1)
	public void login()
	{	
		driver.get("https://demo.guru99.com/V1/index.php");
		System.out.println(driver.getTitle());
	}
	
	@Test(priority=2)
	public void enterCredentials() 
	{	
		driver.findElement(By.name("uid")).sendKeys("mngr394612");
		driver.findElement(By.name("password")).sendKeys("veremUt");
		driver.findElement(By.name("btnLogin")).click();
		driver.findElement(By.xpath("//a[@href='addcustomerpage.php']")).click();
		System.out.println(driver.getTitle());
	}
	
	@Test(priority=3)
	public void newCustomer()
	{
		driver.findElement(By.name("name")).sendKeys("LuisTaylor");
		driver.findElement(By.xpath("//input[@type='radio'][1]")).click();
		driver.findElement(By.name("dob")).sendKeys("23-06-1988");
		driver.findElement(By.xpath("//*[@name='addr']")).sendKeys("ABC Park\n, Tower2\n, Boston USA");
		driver.findElement(By.name("city")).sendKeys("Boston");
		driver.findElement(By.name("state")).sendKeys("SFO");
		driver.findElement(By.name("pinno")).sendKeys("991008");
		driver.findElement(By.name("telephoneno")).sendKeys("9876543210");
		driver.findElement(By.name("emailid")).sendKeys("acb@gmail.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("sub")).click();
		
	}
	
	@AfterTest
	public void alogin()
	{
		driver.close();
	}
	
}
