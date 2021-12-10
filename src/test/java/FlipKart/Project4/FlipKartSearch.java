package FlipKart.Project4;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Classes.Screenshot;
import PageLocators.SearchElements;
import TestData.ReadExcel;

public class FlipKartSearch {
	
	WebDriver driver;
	@Parameters({"browser","App"})
	@BeforeClass
	public void Launch(String browser,String App) 
	{
		
		switch(browser)
		{
		case "chrome":
			 System.setProperty("webdriver.chrome.driver", "src\\main\\java\\Drivers\\chromedriver.exe");
			 driver = new ChromeDriver();
			 break;
		case "firefox":
			 System.setProperty("webdriver.gecko.driver", "src\\main\\java\\Drivers\\geckodriver.exe");
			 driver = new FirefoxDriver();
			 break;
		default: System.out.println("Invalid Input...");
		}
		driver.get(App);
		driver.manage().window().maximize();
	}
	@Test(priority = 6)
	public void search() throws IOException, InterruptedException
	{
		SearchElements s = new SearchElements(driver);
		s.search("Mobile Phones");
		Thread.sleep(5000);
		List<String> name = s.name();
		List<String> price = s.price();
		int count = name.size();
		int count1 = price.size();
	
		print(count,name,"phonename");
		print(count1,price,"price"); 
		
	}
	
	public void print(int count, List<String> name1, String field) throws IOException
	{
		
		
		ReadExcel r = new ReadExcel();
		r.row(field);
		for (int i = 0; i<count; i ++)
		{
			String text = name1.get(i);
			//System.out.println(text);
			 r.write(i,text);
		}
		
	}
	 @AfterSuite
	  public void close()
	  {
		  driver.quit();
	  }
	 @AfterMethod
		public void close(ITestResult R) throws IOException
		{
			int ActualStatus = R.getStatus();
			int ExpectedStatus = ITestResult.SUCCESS;
			
			
			
			if(ActualStatus == ExpectedStatus)
			{
				System.out.println("Tc Passed...");
				Screenshot s = new Screenshot(driver);
				
				s.screenshot();
			}
			else
			{
				System.out.println("Tc Failed...");
				Screenshot s = new Screenshot(driver);
			
				s.screenshot();
			}
		}

}
