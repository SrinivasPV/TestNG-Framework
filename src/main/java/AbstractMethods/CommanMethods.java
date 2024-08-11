package AbstractMethods;

import java.awt.Window;
import java.awt.event.WindowEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommanMethods {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public CommanMethods(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public void scrollWindow(int x, int y)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Object executeScript = js.executeScript("window.scrollBy("+x+","+y+")");
		System.out.println(executeScript);
	}
	
	public void waits(By loc)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(loc));
	}
	
   
	public void getFocusToNewWindow()

	{
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		
	}
	
	public void waitForWindows()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	}
	

}
