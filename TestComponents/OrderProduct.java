package TestComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.google.common.base.Preconditions;

import PageObjects.CheckOutPage;
import PageObjects.ProductPage;

public class OrderProduct extends BaseClass {
	
	public WebDriver driver;
	public OrderProduct(WebDriver driver)
	{
		this.driver=driver;
	}

	@Test
	public void TestCase001() throws InterruptedException
	{
		ProductPage p = l.enterCredentials("8248607808","Santyvas@1203");
		p.searchProduct();
		p.scrollWindow(0, 2000);
		CheckOutPage c = p.addProductToCart();
		//Thread.sleep(3000);
		p.scrollWindow(0, -2000);
		c.checkOut();
		c.productCheck("Saiga Parts TankTie for Jawa 42 (Matte Black)");
		c.quantityCheck("1");
	}
	
//	@Test
//	pubilc void TestCase002()
//	{
//		driver.get("https://www.testgorilla.com/blog/sql-queries-interview-questions/");
//	}
}
