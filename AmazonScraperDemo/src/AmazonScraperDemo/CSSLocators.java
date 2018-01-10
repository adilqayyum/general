package AmazonScraperDemo;

public class CSSLocators {
	
	//Ids
	
	public static String itemPriceID = "priceblock_ourprice";
	
	public static String quantitySelector = "quantity";
	
	public static String addToCartBtn = "add-to-cart-button";
	
	public static String rejectOfferBtn = "siNoCoverage-announce";
	
	public static String viewCartBtn = "huc-v2-button-view-cart";
	
	public static String itemName = "productTitle";
	
	//XPaths
	
	public static String fifthItemXPath = "//*[@id=\"zg_centerListWrapper\"]/div[6]";
	
	public static String totalPrice = "//*[@id=\"gutterCartViewForm\"]/div[3]/div[2]/div/div[1]/p/span/span[2]";
	//CSSSelector
	
	public static String itemInCart = "div.sc-list-item-content a.sc-product-link:nth-child(1)>span";
}
