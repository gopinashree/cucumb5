package case1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class drivers {
	public static WebDriver getDriver(String Browser)
	{
		if(Browser.equals("chrome"))
		{
			 System.setProperty("webdriver.chrome.driver", "C:\\vidhya1\\RemoteSystemsTempFiles\\chromedriver_win32\\chromedriver.exe");
			 return new ChromeDriver();
			 
		}
		else if(Browser.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\vidhya1\\drivers\\iedriver.exe");
			 return new InternetExplorerDriver();
			
		}
			return null;
	}

  
}
