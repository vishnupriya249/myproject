package PageLocators;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Classes.ReadDetails;

public class UserDetailsPageElements {
	
	WebDriver driver;
	int n,p;
		
		public UserDetailsPageElements(WebDriver driver)
		{
			this.driver = driver;
		}
		ReadDetails r = new ReadDetails();
		public void addNew() throws IOException
		{
			
			r.getElementInfo("addressadd", driver).click();		
		}
		public void fillForm(String field,String data) throws IOException
		{
			r.getElementInfo(field, driver).sendKeys(data);
		}
//		public void state() throws IOException
//		{
//			WebElement state = r.getElementInfo("state",driver);
//			Select a = new Select(state);
//			a.selectByValue("Telangana");
//		}
		public void save() throws IOException, InterruptedException
		{
			
			r.getElementInfo("home", driver).click();	
			r.getElementInfo("save", driver).click();
		
			
		}
		public void continue1() throws IOException
		{
			r.getElementInfo("continue", driver).click();
		}
		
		public boolean verify() throws IOException
		{
			boolean phonepay = r.getElementInfo("verify", driver).isDisplayed();
			return phonepay;
		}

}
