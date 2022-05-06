package parallelExecution2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirefoxExecution {
	
	public WebDriver driver = null;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", "./BrowserDriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}
	
	@Test
	public void run() throws InterruptedException
	{
		driver.get("https://www.snapdeal.com");
		System.out.println("Firefox Driver Execution:-\n"+driver.getTitle()+"\n"+driver.getCurrentUrl());
		System.out.println("Thread is : "+Thread.currentThread().getId());
		//Thread.sleep(2000);
	}
	
	@AfterTest
	public void exit()
	{
		System.out.println("Closing Firefox Browser.");
		driver.close();
	}
}



