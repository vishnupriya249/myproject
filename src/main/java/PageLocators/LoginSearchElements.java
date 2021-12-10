package PageLocators;

import java.io.IOException;


import org.openqa.selenium.WebDriver;

import Classes.ReadDetails;


public class LoginSearchElements {
	
	WebDriver driver;
	
		//String pr = "//div[contains(text(),'APPLE iPhone 12 (Blue, 64 GB)')]";
		
		public LoginSearchElements(WebDriver driver)
		{
			this.driver = driver;
		}
		ReadDetails r = new ReadDetails();
		public void search(String searchtext) throws IOException
		{
			
			r.getElementInfo("searchtext", driver).sendKeys(searchtext);
		    r.getElementInfo("search", driver).click();			
			
		}
		public void product() throws IOException
		{
			 r.getElementInfo("product", driver).click();
		
		}
		public String pathString(String locator) throws IOException
		{
			String text = r.getPath(locator);
			return text;
			
		}
		public void filter() throws IOException
		{
			r.getElementInfo("filter", driver).click();
		}
		
		public String text() throws IOException
		{
			String text = r.getElementInfo("text", driver).getText();
			return text;
		}
		

}
