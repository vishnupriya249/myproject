package PageLocators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Classes.ReadDetails;


public class SearchElements {
WebDriver driver;
int n,p;
	
	public SearchElements(WebDriver driver)
	{
		this.driver = driver;
	}
	ReadDetails r = new ReadDetails();
	public void search(String searchtext) throws IOException
	{
		
		r.getElementInfo("close", driver).click();
		r.getElementInfo("searchtext", driver).sendKeys(searchtext);
	    r.getElementInfo("search", driver).click();
		
		
		
	}
	public  List<String> name() throws IOException
	{
		List<WebElement> name = r.getElementsInfo("phonename", driver);
		 n = name.size();
		 List<String> data = new ArrayList<>(); 
			for(int a = 0; a<n;a++)
			{
				String text = name.get(a).getText();
				 data.add(text);
				 
			}
			System.out.println(data);
			return data;
		
		
	}
	public List<String> price() throws IOException
	{
		List<WebElement> price = r.getElementsInfo("price", driver);
		 p = price.size();
		 List<String> data = new ArrayList<>(); 
			for(int a = 0; a<p;a++)
			{
				String text = price.get(a).getText();
				String text1 = text.substring(1);
				 data.add(text1);
				 
			}
			//System.out.println(data);
			return data;	
	}


}
