package AmazonScraperDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonScraperDemo {

	//Variable
	static int Qty = 0;
	
	static String camName = "";
	
	static double price = 0;
	
	static String driverPath = "";
	
	public static void CheckforValidity(WebDriver browser)
	{
		if(browser == null)
		{
			ASDUtility.DOMCheck();
		}
		else
		{
			return;
		}
	}
	
	public static void main(String[] args) 
	{	
		//Initiation.
		driverPath = "C:\\My Stuff\\Coding Stuff\\AmazonScraperDemo\\ChromeDriver\\chromedriver.exe";
		Qty = 8;
		
		WebDriver myBrowser = AmazonScraper.initiateDriver(driverPath);
		
		if(myBrowser == null)
		{
			System.out.println("Exiting Program.");
			return;
		}
		
		//Adding fifth Best Seller Camera from Amazon.
		myBrowser = AmazonScraper.navigateToAmazon(myBrowser);
		
		myBrowser = AmazonScraper.navigateToBestSellerCameras(myBrowser);
		
		myBrowser = AmazonScraper.addFifthItemToCart(myBrowser);
		
		AmazonScraperDemo.CheckforValidity(myBrowser);
		
		try
		{
			camName = myBrowser.findElement(By.id(CSSLocators.itemName)).getText().toString();
			price = Double.parseDouble(myBrowser.findElement(By.id(CSSLocators.itemPriceID)).getText().toString().replace('$', '0'));
		}
		catch(Exception e)
		{
			ASDUtility.DOMCheck();
		}
		System.out.println("Going for the Item : " + camName);
		
		System.out.println("Price : " + price);
		
		myBrowser = AmazonScraper.setQuantity(myBrowser, Qty);
		
		myBrowser = AmazonScraper.addToCart(myBrowser);
		
		AmazonScraperDemo.CheckforValidity(myBrowser);
		
		ASDUtility.wait(ASDUtility.interval);
		
		myBrowser = AmazonScraper.viewCart(myBrowser);
		
		AmazonScraperDemo.CheckforValidity(myBrowser);
		
		ASDUtility.wait(ASDUtility.interval);
		
		//Verification.
		
		boolean AddedItemCheck = CartItemTester.verifyAddedItem(camName, myBrowser);
		
		if(AddedItemCheck == true)
		{
			System.out.println("The Item Added to the cart is Correct.");
		}
		else
		{
			System.out.println("The Item Added is not correct, There might be a problem.");
		}
		
		boolean totalPriceCheck = CartItemTester.totalPriceCheck(price, myBrowser, Qty);
		
		if(totalPriceCheck == true)
		{
			System.out.println("Total is correct.");
		}
		else
		{
			System.out.println("There is a problem with the total price");
		}
		
		ASDUtility.wait(ASDUtility.interval);
	}
}
