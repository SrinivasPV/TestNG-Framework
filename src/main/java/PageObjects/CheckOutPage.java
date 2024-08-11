package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractMethods.CommanMethods;

public class CheckOutPage extends CommanMethods{
	public WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="nav-cart")
	WebElement cart;
	
	@FindBy(xpath="//li[@class='a-spacing-mini sc-item-product-title-cont']//span[@class='a-truncate-cut']")
	WebElement productOrdered;
	
	@FindBy(css="input[name=quantityBox]")
	WebElement quantity;
	
	public void checkOut()
	{
		
		cart.click();
		//waitFor(By.xpath("div[data-asin='B0B3VY7K63']"));
	}
	
	public void productCheck(String actualText)
	{
		String text = productOrdered.getText();
		Assert.assertEquals(actualText, text);
	}
	
	public void quantityCheck(String number)
	{
	
		String attribute = quantity.getAttribute("value");
		Assert.assertEquals(number, attribute);
	}
	

}
