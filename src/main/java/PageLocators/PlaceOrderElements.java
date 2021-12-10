package PageLocators;

import java.io.IOException;


import org.openqa.selenium.WebDriver;

import Classes.ReadDetails;


public class PlaceOrderElements {
	
	WebDriver driver;
	
		//String pr = "//div[contains(text(),'APPLE iPhone 12 (Blue, 64 GB)')]";
		
		public PlaceOrderElements(WebDriver driver)
		{
			this.driver = driver;
		}
		ReadDetails r = new ReadDetails();
		
		public void addToCart() throws IOException
		{
			 r.getElementInfo("add", driver).click();
		
		}
		public void placeOrder() throws IOException
		{
			r.getElementInfo("order", driver).click();
			
		}
		

}
