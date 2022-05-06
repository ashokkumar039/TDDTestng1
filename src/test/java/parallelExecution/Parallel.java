package parallelExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parallel {
	
	@Test
	@Parameters("newurl1")
	public void browser1(String newurl1) throws InterruptedException
	{	
		System.setProperty("webdriver.chrome.driver", "./BrowserDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(newurl1);
		System.out.println("This is Browser 1 :- \n"+driver.getTitle()+"\n"+driver.getCurrentUrl());
		System.out.println("Thread is : "+Thread.currentThread().getId());
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test
	@Parameters("newurl2")
	public void browser2(String newurl2) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./BrowserDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(newurl2);
		System.out.println("This is browser 2 :- \n"+driver.getTitle()+"\n"+driver.getCurrentUrl());
		System.out.println("Thread is : "+Thread.currentThread().getId());	
		Thread.sleep(3000);
		driver.close();
	}
}
