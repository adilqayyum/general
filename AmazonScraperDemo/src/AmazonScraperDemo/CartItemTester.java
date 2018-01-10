package AmazonScraperDemo;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartItemTester {
	
	public static boolean verifyAddedItem(String item, WebDriver browser)
	{
		String AddedItem = "";
		
		try
		{
			AddedItem = browser.findElement(By.cssSelector(CSSLocators.itemInCart)).getText().toString();
			System.out.println("The Item in the Cart is : " + AddedItem);
		}
		catch (Exception e)
		{
			System.out.println("Problem fetching Added Item.");
			ASDUtility.DOMCheck();
		}
		if( item.equals(AddedItem))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean totalPriceCheck(double itemPrice, WebDriver browser, int quantity)
	{
		NumberFormat format = NumberFormat.getInstance(Locale.US);
		Number priceNum = 0;
		
		try 
		{
			priceNum = format.parse(browser.findElement(By.xpath(CSSLocators.totalPrice)).getText().toString().replace('$', '0'));
		} 
		catch (ParseException e1)
		{
			System.out.println("Problem fetching total Price.");
			ASDUtility.DOMCheck();
		}
		
		Double totalPrice = priceNum.doubleValue();
		Double AddedPrice = (itemPrice*quantity);
		
		System.out.println("Total Price at Amazon cart : " + totalPrice);
		System.out.println("Calculated from the actual price : " + AddedPrice);
		
		if( totalPrice - AddedPrice == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
