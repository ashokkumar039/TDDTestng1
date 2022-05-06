package demo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
	static WebDriver driver = null;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./BrowserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement> ll = driver.findElements(By.tagName("a"));
		System.out.println(ll.size());
		
		int b_link = 0;
		int v_link = 0;
		for(int i=0;i<ll.size();i++)
		{
			String url = ll.get(i).getAttribute("href");
			if(url.isEmpty()) {
				System.out.println(url);
			}
			URL u = new URL(url);
			try {
				HttpURLConnection http = (HttpURLConnection) u.openConnection();
				http.connect();
				if(http.getResponseCode() == 200) {
					System.out.println("This is valid url - "+url);
					v_link++;
				}
				else
					System.out.println("This is not valid url - "+url);
					b_link++;
			}
			catch(Exception e)
			{
				
			}
		}
		System.out.println("Total number of broken links : "+b_link);
		System.out.println("Total number of valid links : "+v_link);
		//Thread.sleep(3000);
		driver.close();
	}
}
