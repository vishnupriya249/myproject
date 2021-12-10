package Classes;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshot {

	 WebDriver  driver;
	
	
	public Screenshot(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void screenshot() throws IOException
	{
		Date d = new Date();
		DateFormat df  = new SimpleDateFormat("dd hh-mm-ss");
		
	  String value = df.format(d);
		
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File f2= new File("src\\test\\output\\img"+value+".png"); 
		 
		FileUtils.copyFile(f, f2);
	}
	
	
	

}
