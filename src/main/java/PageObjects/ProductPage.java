package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractMethods.CommanMethods;

public class ProductPage extends CommanMethods {
	
	public WebDriver driver;
	public CheckOutPage page;

	public ProductPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	}
	
	@FindBy(id="twotabsearchtextbox")
	WebElement text;
	
	@FindBy(css="a[href*='/Saiga-Parts']")
	WebElement product;
	
	@FindBy(css="#add-to-cart-button")
	WebElement cart;
	
	
	public void searchProduct()
	{
		text.sendKeys("Jawa 42",Keys.ENTER);
		waits(By.xpath("//img[contains(@alt,'Saiga Parts')]"));
		//scrollWindow(x,y);
		
	}
	
	public CheckOutPage addProductToCart()
	{
        product.click();
        getFocusToNewWindow();
        waitForWindows();
        cart.click();
		page = new CheckOutPage(driver);
		return page;		
	}

}
