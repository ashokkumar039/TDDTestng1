package parameter1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Parameterised {

	public static WebDriver driver = null;

	
	@Test(priority=1)
	@Parameters("url1")
	public void param1(String url) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./BrowserDriver/chromedriver.exe");
		ChromeOptions c = new ChromeOptions();
		c.addArguments("--incognito");
		DesiredCapabilities d = DesiredCapabilities.chrome();
		d.setCapability(ChromeOptions.CAPABILITY, c);
		driver = new ChromeDriver(c);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
	}
	
	@Test(priority=2)
	public void searchProduct() throws InterruptedException
	{
		System.out.println(driver.getCurrentUrl());
		WebElement searchbox = driver.findElement(By.name("keyword"));
		searchbox.sendKeys("Home Audio Systems");
		searchbox.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@placeholder='Enter your pincode']")).sendKeys("757048");
		driver.findElement(By.xpath("//button[@class='pincode-check']")).click();
	}
	
	@Test(priority=3)
	public void sorting() throws InterruptedException
	{
		driver.findElement(By.cssSelector("div.sort-selected")).click();
		List<WebElement> sortvalue = driver.findElements(By.xpath("//ul[@class='sort-value']//li"));
		sortvalue.get(3).click();
		Thread.sleep(4000);
		driver.close();
	}
	
}
