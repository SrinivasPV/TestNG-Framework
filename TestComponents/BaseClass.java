package TestComponents;

import java.awt.ContainerOrderFocusTraversalPolicy;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import PageObjects.LoginPage;

public class BaseClass {
	
	//public WebDriver driver;
	public LoginPage l;
	
	
	@BeforeMethod
	@Parameters("browser")
	public void preConditions(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
		ChromeDriver driver = new ChromeDriver();
		System.out.println(browser);
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			EdgeDriver driver = new EdgeDriver();
			System.out.println(browser);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		l = new LoginPage(driver);
		l.goToPage();
		//OrderProduct od= new OrderProduct(driver);
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.quit();
	}

}
