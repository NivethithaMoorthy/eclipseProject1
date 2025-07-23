package transactions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreditAnnotations 
{	
	public static WebDriver cd;
	public static JavascriptExecutor js;
	
	public static void captureScreenShot(WebDriver cd) 
	{
		File src=((TakesScreenshot)cd).getScreenshotAs(OutputType.FILE);
		try 
		{
		FileHandler.copy(src, new File("E:\\Batch30Automation\\BankingApplication\\screenshots\\"+System.currentTimeMillis()+"AZB"+".jpg"));
		}
		catch (IOException e)
		{ 
			System.out.println(e.getMessage());
	    }
	}
	
	@BeforeTest
	public void browserOpen()
	{
		System.setProperty("webdriver.chrome.driver","E:\\Batch30Automation\\BankingApplication\\Chromedriver\\chromedriver.exe");
        cd = new ChromeDriver(); 
        cd.manage().window().maximize();   
		cd.get("https://www.amazon.in/");
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority=2)
	public void tc001_search() throws InterruptedException
	{
		cd.findElement(By.name("field-keywords")).sendKeys("smartwatch");
		captureScreenShot(cd);
		cd.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority=1)
	public void tc002_scrollClickElement() throws InterruptedException
	{
		js = (JavascriptExecutor)cd;
		js.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-3000)");
		Thread.sleep(2000);
	}

	@AfterTest
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		cd.close();
	}

}
