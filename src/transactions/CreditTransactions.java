package transactions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class CreditTransactions 
{
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
	
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","E:\\Batch30Automation\\BankingApplication\\Chromedriver\\chromedriver.exe");
        WebDriver cd = new ChromeDriver(); //opens new chrome window
        cd.manage().window().maximize();   //maximizes the window size
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Opening website");
		cd.get("https://www.amazon.in/");
		captureScreenShot(cd);
		System.out.println("screenshot captured");
		cd.findElement(By.name("field-keywords")).sendKeys("smartwatch");
		System.out.println("smartwatch entered in search field");
		captureScreenShot(cd);
		cd.findElement(By.id("nav-search-submit-button")).click();
		System.out.println("search icon is clicked");
		captureScreenShot(cd);
		Thread.sleep(2000);
		captureScreenShot(cd);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)cd;
		
		js.executeScript("window.scrollBy(0,3000)");
		captureScreenShot(cd);
		
		//child window opened
		cd.findElement(By.xpath("//img[@src=\"https://m.media-amazon.com/images/I/61akt30bJsL._AC_UY218_.jpg\"]")).click();
		Thread.sleep(2000);
		captureScreenShot(cd);
		
		ArrayList<String> openTabs = new ArrayList<>(cd.getWindowHandles()); //collect all opened tabs
		cd.switchTo().window(openTabs.get(1)); //switched to child window
		//scrolling in child window
		js.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-2000)");
		Thread.sleep(2000);
		//switched to parent window
		cd.switchTo().window(openTabs.get(0));
		//scrolling in parent window
		js.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,-2000)");
		Thread.sleep(2000);
		captureScreenShot(cd);
        
	}

}
