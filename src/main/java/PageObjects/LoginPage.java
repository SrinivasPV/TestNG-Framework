package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractMethods.CommanMethods;

public class LoginPage extends CommanMethods{
	
	public WebDriver driver;
	public ProductPage p;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[contains(text(),'Hello, sign')]")
	WebElement signin;
	
	@FindBy(css=".a-input-text")
	WebElement id;
	
	@FindBy(css=".a-button-input")
	WebElement login;
	
	@FindBy(id="ap_password")
	WebElement pass;
	
	@FindBy(id="signInSubmit")
	WebElement passLogin;
	
	public void goToPage()
	{
		driver.get("https://www.amazon.in/");
		signin.click();
	}

	public ProductPage enterCredentials(String number, String passd)
	{
		id.sendKeys(number);
		login.click();
		pass.sendKeys(passd);
		passLogin.click();
		Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		return new ProductPage(driver);
	}

}
