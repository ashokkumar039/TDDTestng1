package parallelExecution2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeExecution {
	
	public WebDriver driver = null;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "./BrowserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}
	
	@Test
	public void run() throws InterruptedException
	{
		driver.get("https://www.flipkart.com");
		System.out.println("Chrome Driver Execution:-\n"+driver.getTitle()+"\n"+driver.getCurrentUrl());
		System.out.println("Thread is : "+Thread.currentThread().getId());
		//Thread.sleep(2000);
	}
	
	@AfterTest
	public void exit()
	{
		System.out.println("Closing Chrome Browser.");
		driver.close();
	}
	
}
