package AmazonScraperDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonScraper {
	
	public static WebDriver initiateDriver(String driverPath)
	{
		WebDriver browser;
		try
		{
		System.setProperty("webdriver.chrome.driver", driverPath);
		browser = new ChromeDriver();
		browser.manage().window().maximize();
		}
		catch(Exception e)
		{
			browser = null;
		}
		return browser;
	}
	
	public static WebDriver navigateToAmazon(WebDriver browser)
	{
		browser.get(ASDUtility.AMZ_URL);
		return browser;
	}
	
	public static WebDriver navigateToBestSellerCameras(WebDriver browser)
	{
		browser.get(ASDUtility.AMZ_BestSeller_URL);
		return browser;
	}
	
	public static WebDriver addFifthItemToCart(WebDriver browser)
	{
		try
		{
			WebElement cam = browser.findElement(By.xpath(CSSLocators.fifthItemXPath));	
			cam.click();
		}
		catch(Exception e)
		{
			System.out.println("Item not found in Best Sellers");
			browser = null;
		}
		return browser;
	}
	
	public static WebDriver setQuantity(WebDriver browser, int quantity)
	{
		try
		{
			WebElement QtyDropDown = browser.findElement(By.id(CSSLocators.quantitySelector));
			QtyDropDown.click();
			QtyDropDown.sendKeys(Integer.toString(quantity));
		}
		catch(Exception e)
		{
			System.out.println("Item is not available in this much quantity.");
		}
		return browser;
	}

	public static WebDriver addToCart(WebDriver browser)
	{
		try
		{
			browser.findElement(By.id(CSSLocators.addToCartBtn)).click();
			ASDUtility.wait(ASDUtility.interval);
		}
		catch(Exception e)
		{
			browser = null;
		}
		try
		{
			browser.findElement(By.id(CSSLocators.rejectOfferBtn)).click();
		}
		catch(Exception e)
		{
			//In case no Offer is made from Amazon and Item is added to cart directly.
		}
		return browser;
	}
	
	public static WebDriver viewCart(WebDriver browser)
	{
		try
		{
			browser.findElement(By.id(CSSLocators.viewCartBtn)).click();
		}
		catch(Exception e)
		{
			browser = null;
		}
		return browser;
	}

}
