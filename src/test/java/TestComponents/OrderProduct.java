package TestComponents;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.CheckOutPage;
import PageObjects.ProductPage;
import resources.jsonToString;

public class OrderProduct extends BaseClass {

	@Test(dataProvider = "getData")
	public void TestCase001(HashMap<String, String> input) throws InterruptedException
	{
		ProductPage p = l.enterCredentials(input.get("name"),input.get("password"));
		p.searchProduct();
		p.scrollWindow(0, 2000);
		CheckOutPage c = p.addProductToCart();
		//Thread.sleep(3000);
		p.scrollWindow(0, -2000);
		c.checkOut();
		c.productCheck("Saiga Parts TankTie for Jawa 42 (Matte Black)");
		c.quantityCheck("1");
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = jsonToString.getJsonData("D:\\test leaf\\practise-testNG\\src\\main\\java\\resources\\data.json");
		return new Object[][] {{data.get(0)}};
	}
}
