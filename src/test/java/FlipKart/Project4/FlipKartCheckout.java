package FlipKart.Project4;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Classes.Screenshot;
import PageLocators.LoginElements;
import PageLocators.LoginSearchElements;
import PageLocators.PlaceOrderElements;
import PageLocators.UserDetailsPageElements;
import TestData.ReadExcel;


public class FlipKartCheckout {
	
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
	
	
  @Test(priority=1)
  public void Login() throws IOException, InterruptedException {
	  
	  ReadExcel r = new ReadExcel();
	  
	 LoginElements l = new LoginElements(driver);
	 Thread.sleep(3000);
	 String user =  r.getExcelData(1, 0, 0);
	 String pass =  r.getExcelData(1, 0, 1);
	 System.out.println(user+" "+pass);
	  
	  l.Login(user, pass);
	  
	
  }
 

@Test(priority=2)
  public void search() throws IOException, InterruptedException
  {
	  Thread.sleep(10000);
	  LoginSearchElements ls = new LoginSearchElements(driver);
	  ReadExcel r = new ReadExcel();
	  String searchtext = r.getExcelData(2, 0, 0);
	  ls.search(searchtext);
	  Thread.sleep(3000);
	 // ls.filter();
	    
	  WebDriverWait w = new WebDriverWait(driver,5);
	  w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ls.pathString("product"))));
	  ls.product();
	  
	  
  }
  @Test(priority=3)
  public void addToCart() throws IOException, InterruptedException
  {
	  WebDriverWait w = new WebDriverWait(driver,5);
	  Set<String> loop = driver.getWindowHandles();
		Iterator i = loop.iterator();                                
	    String mainID = (String) i.next();
	    String ID1 = (String) i.next();
	    
		driver.switchTo().window(ID1);
		Thread.sleep(3000);
		LoginSearchElements ls = new LoginSearchElements(driver);
		PlaceOrderElements pe = new PlaceOrderElements(driver);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath(ls.pathString("add"))));
		pe.addToCart();
		System.out.println("added to cart...");
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ls.pathString("order"))));	
		pe.placeOrder();
		Thread.sleep(3000);	
		
  }
  @Test(priority=4)
  public void addAddress() throws IOException, InterruptedException
  {
	  
	  UserDetailsPageElements us = new UserDetailsPageElements(driver);
	  LoginSearchElements ls = new LoginSearchElements(driver);
	  WebDriverWait w = new WebDriverWait(driver,5);
	  w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ls.pathString("addressadd"))));	
	  us.addNew();
	  ReadExcel r = new ReadExcel();
	  for(int i =0; i<5;i++)
	  {
		  
		  String data = r.getExcelData(3, 1, i);
		  String field = r.getExcelData(3, 0, i);
		  us.fillForm(field, data);
	  }
	 	
	 // us.state();
	  us.save();
	  
	  w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ls.pathString("continue"))));	
	  us.continue1();
	  w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ls.pathString("verify"))));
	  if(us.verify())
		  System.out.println("Sucessfully Completed..."+us.verify());
	  else 
		  System.out.println("Error! page not reached..."+us.verify());
    
	  
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
