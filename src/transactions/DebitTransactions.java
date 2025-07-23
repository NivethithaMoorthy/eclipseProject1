package transactions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DebitTransactions 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","E:\\Batch30Automation\\BankingApplication\\Chromedriver\\chromedriver.exe");
        WebDriver cd = new ChromeDriver(); //opens new chrome window
        cd.manage().window().maximize();   //maximizes the window size
		cd.get("https://www.amazon.in/");
		System.out.println("Website opened");
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions a = new Actions(cd);
	
		Thread.sleep(2000);
		a.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).build().perform(); //scroll down
		Thread.sleep(2000);
		a.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).keyUp(Keys.CONTROL).build().perform(); //scroll up
		
		Thread.sleep(2000);
		a.keyDown(Keys.CONTROL).sendKeys(Keys.F5).keyUp(Keys.CONTROL).build().perform(); //refresh
		
	
		
		WebElement srch = cd.findElement(By.name("field-keywords"));
		//a.sendKeys(srch,"computers").build().perform();
		
		a.keyDown(srch,Keys.SHIFT).sendKeys("computers").keyUp(srch,Keys.SHIFT).build().perform();
		Thread.sleep(1000);
		a.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform(); //select
		Thread.sleep(1000);
		a.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform(); //copy
		Thread.sleep(1000);
		a.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).build().perform(); //cut
		Thread.sleep(1000);
		a.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform(); //paste
		
		
		cd.findElement(By.id("nav-search-submit-button")).click();
		
		
	

	}

}
