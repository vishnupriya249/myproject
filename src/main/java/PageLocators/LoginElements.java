package PageLocators;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Classes.ReadDetails;

public class LoginElements {
	
	WebDriver driver;
	int n,p;
		
		public LoginElements(WebDriver driver)
		{
			this.driver = driver;
		}
		ReadDetails r = new ReadDetails();
		public void Login(String user, String pass) throws IOException
		{
			
			r.getElementInfo("username", driver).sendKeys(user);
			r.getElementInfo("password", driver).sendKeys(pass);
		    r.getElementInfo("login", driver).click();
			
			
			
		}

}
