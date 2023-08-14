package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class buyDress {
	
	private WebDriver driver;
	
	public buyDress(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(xpath="//a[contains(text(),'pink drop shoulder oversized t shirt')]")
	public WebElement products; 
	
	@CacheLookup
	@FindBy(id="pa_color")
	public WebElement color;
	
	@CacheLookup
	@FindBy(id="pa_size")
	public WebElement size;
	
	@CacheLookup
	@FindBy(xpath="//button[contains(text(),'Add to cart')]")
	public WebElement addToCart;
	
	@CacheLookup
	@FindBy(xpath="//a[contains(text(),'View cart')]")
	public WebElement cart;
	
	@CacheLookup
	@FindBy(xpath="//a[contains(text(),'Proceed to checkout')]")
	public WebElement checkOut;
	
	@CacheLookup
	@FindBy(id="billing_first_name")
	public WebElement firstName;
	
	@CacheLookup
	@FindBy(id="billing_last_name")
	public WebElement lastName;
	
	@CacheLookup
	@FindBy(id="select2-billing_country-container")
	public WebElement country;
		
	@CacheLookup
	@FindBy(xpath="//input[@id='billing_address_1']")
	public WebElement streetAddress;
	
	@CacheLookup
	@FindBy(id="billing_city")
	public WebElement city;
	
	@CacheLookup
	@FindBy(id="select2-billing_state-container")
	public WebElement state;
	
	@CacheLookup
	@FindBy(id="billing_postcode")
	public WebElement pincode;
	
	@CacheLookup
	@FindBy(id="billing_phone")
	public WebElement phone;
	
	@CacheLookup
	@FindBy(xpath="//input[@id='terms']")
	public WebElement checkbox;
	
	@CacheLookup
	@FindBy(id="billing_email")
	public WebElement email;
	
	@CacheLookup
	@FindBy(id="place_order")
	public WebElement placeOrder;
	
	@CacheLookup
	@FindBy(xpath="//p[contains(text(),'Thank you. Your order has been received.')]")
	public WebElement message;
	
	@CacheLookup
	@FindBy(xpath="//a[@class='noo-search']")
	public WebElement search;
	
	@CacheLookup
	@FindBy(xpath="//input[@type='search']")
	public WebElement textbox;
	
}
