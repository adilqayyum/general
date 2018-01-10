package AmazonScraperDemo;

public class ASDUtility {
	
	//Variables
	public static int interval = 5000;
	
	public static String AMZ_URL = "https://www.amazon.com";
	
	public static String AMZ_BestSeller_URL = "https://www.amazon.com/Best-Sellers-Electronics-Digital-Cameras/zgbs/electronics/281052/ref=zg_bs_unv_e_3_330405011_1";
	
	//Methods
	public static void wait(int interval)
	{
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void DOMCheck()
	{
		System.out.println("Can't fetch the component, DOM might have changed.\nExiting Program.");
		System.exit(0);
	}
}