package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import driverManager.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pom.buyDress;

public class Steps {
	 
	buyDress buyDress= new buyDress(DriverManager.getDriver());
	
	@Given("User is on Home Page")
	public void user_is_on_home_page() {
	    String actualUrl= DriverManager.getDriver().getCurrentUrl();
	    Assert.assertTrue("This is not correct URL", actualUrl.contains("https://shop.demoqa.com/"));
	}
	@When("he searches for {string}")
	public void he_searches_for(String args1) throws AWTException {
		buyDress.search.click();
		buyDress.textbox.sendKeys("product");
		Robot robo= new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
		
	}
	@And("choose to buy the first item")
	public void choose_to_buy_the_first_item() {
		 buyDress.products.click();;
		
	    
	}
	@And("moves to checkout from mini card")
	public void moves_to_checkout_from_mini_card() throws InterruptedException {
	    Select selectColor= new Select(buyDress.color);
	    List<WebElement> colors= selectColor.getOptions();
	    		for(int i=0;i<colors.size();i++)
	    		{
	    			if(colors.get(i).equals("Pink"))
	    			{
	    			colors.get(i).click();
	    			Thread.sleep(3000);
	    			}
	    		}
	    Select selectSize= new Select(buyDress.size);
	    List<WebElement> size= selectSize.getOptions();
	    		for(int i=0;i<size.size();i++)
	    		{
	    			if(size.get(i).equals("36"))
	    			{
	    				size.get(i).click();
	    				Thread.sleep(3000);
	    			}
	    		}
	    buyDress.addToCart.click();
	    buyDress.cart.click();
	    buyDress.checkOut.click();
	}
	
	@And("enters personal details on checkout page")
	public void enters_personal_details_on_checkout_page() {
	   buyDress.firstName.sendKeys("Japinder");
	   buyDress.lastName.sendKeys("Kaur");
	   //List<WebElement> countrList= buyDress.country;
	   Select countryList= new Select(buyDress.country);
	   List<WebElement> country= countryList.getOptions(); 
	   for (int i=0; i<=country.size();i++)
	   {
		   if(country.get(i).equals("India"))
		   {
			   country.get(i).click();
			   Select stateList= new Select(buyDress.state);
			   List<WebElement> state= stateList.getOptions();
			   for(int j=0;j<state.size();j++)
			   {
				   if(state.get(j).equals("Delhi"))
				   {
					   state.get(j).click();
				   }
			   }
		   }
	   }
	   buyDress.streetAddress.sendKeys("52 Hummingbird crt");
	   buyDress.city.sendKeys("Delhi");
	   buyDress.pincode.sendKeys("L6Y3N6");
	   buyDress.phone.sendKeys("2898851819");
	   buyDress.email.sendKeys("japinder.kaur7@gmail.com");
	   buyDress.checkbox.click();
	}
	
	@And("place the order")
	public void place_the_order() {
		buyDress.placeOrder.click();
		WebElement actualMessage= buyDress.message;
		String Expectedmessage=actualMessage.toString();
		String message="Thank you. Your order has been received.";
		Assert.assertTrue("The order is not placed.",Expectedmessage.equals(message));
	
	}

	

}
