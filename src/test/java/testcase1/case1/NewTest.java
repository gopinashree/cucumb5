package testcase1.case1;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import case1.drivers;

public class NewTest {
	
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	
@Test(priority=1)
  public void f() throws InterruptedException
  {
	driver.findElement(By.linkText("SignUp")).click();	
	  driver.findElement(By.id("userName")).sendKeys("vidhyaravi");
	  driver.findElement(By.id("firstName")).sendKeys("vidhya");
	  driver.findElement(By.id("lastName")).sendKeys("ravi");
	  driver.findElement(By.id("password")).sendKeys("vidhya1998");
	  driver.findElement(By.id("pass_confirmation")).sendKeys("vidhya1998");
	  
	  driver.findElement(By.xpath("//input[@value='Female']")).click();
	  driver.findElement(By.id("emailAddress")).sendKeys("vidhyashreeravi98@gmail.com");
	  driver.findElement(By.id("mobileNumber")).sendKeys("9940695549");
	  driver.findElement(By.xpath("//img[@title='Ch']")).click();
	  
	  WebElement selmonth= driver.findElement(By.xpath("//select[@data-handler='selectMonth']"));
	  Select month=new Select(selmonth);
	  month.selectByValue("4");
	  
	  WebElement selyear= driver.findElement(By.xpath("//select[@data-handler='selectYear']"));
	  Select year=new Select(selyear);
	  year.selectByValue("1998");
	  
	  WebElement seldate= driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']"));
	 seldate.findElement(By.linkText("1")).click();
	 
	 driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("chennai chrompet");
	 
	 WebElement security=driver.findElement(By.xpath("//select[@id='securityQuestion']"));
	 Select secques=new Select(security);
	 secques.selectByIndex(2);
	 driver.findElement(By.xpath("//input[@id='answer']")).sendKeys("sun");
	 driver.findElement(By.xpath("//input[@type='submit']")).click();
	 
}

  @Test(priority=2)
  public void login()
  {
	  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  driver.findElement(By.xpath("//a[@href='login.htm']")).click();
	  driver.findElement(By.id("userName")).sendKeys("Lalitha");
	  driver.findElement(By.id("password")).sendKeys("password123");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	   }
  
  @Test(priority=3)
  public void addcart() throws InterruptedException
  {
	 driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	
	  Actions act1=new Actions(driver);
	  act1.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span"))).click().build().perform();
	  act1.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/ul/li[2]/a"))).click().build().perform();
	  Thread.sleep(3000);
	  act1.moveToElement(driver.findElement(By.xpath("//*[@id=\"submenuul11292\"]/li[1]/a/span"))).click().build().perform();
	 
	  driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
	 
	  driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]/i")).click();
	  driver.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();
  }
@Test(priority=4)
public void payment() throws InterruptedException


{
	  
	  driver.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label/i")).click();
	  driver.findElement(By.xpath("//*[@id=\"btn\"]")).click();
	  driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[1]")).sendKeys("123456");
	  driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[2]")).sendKeys("pass@123");
	  driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[3]/input")).click();
	  }
  @BeforeTest
  public void BeforeTest() 
  {  
	  driver=drivers.getDriver("chrome");
	  driver.get("http://google.com");
	  driver.get("http://10.232.237.143:443/TestMeApp/");
	  driver.manage().window().maximize();
	  //driver.manage().timeouts().implicitlyWait(10,TimeUnit,SECONDS);
 
	  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/extent-reports/" + new SimpleDateFormat("hh-mm-ss-ms-dd-MM-yyyy").format(new Date())+".html");
	  extent =new ExtentReports();
	  logger = extent.createTest("start report");
	  extent.attachReporter(htmlReporter);
	  extent.setSystemInfo("Host Name", "GFT NexGen Testing Stream");
	  extent.setSystemInfo("Environment", "Automation Testing - Selenium");
	  extent.setSystemInfo("User Name", "Aswani Kumar Avilala");
	  htmlReporter.config().setDocumentTitle("Title of the Report Comes here");
	  htmlReporter.config().setReportName("Name of the Report Comes here");
	  htmlReporter.config().setTheme(Theme.STANDARD);
	   }
	  @AfterMethod
	  public void getResultAfterMethod(ITestResult result) throws IOException {
		 
		  if(result.getStatus() == ITestResult.FAILURE) {
			  logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			      TakesScreenshot snapshot=(TakesScreenshot)driver;
			  File src=snapshot.getScreenshotAs(OutputType.FILE);
			  String path=System.getProperty("user.dir") + "/extent-reports/snapshots/"+result.getName()+".png";
			  FileUtils.copyFile(src, new File(path));
			  logger.addScreenCaptureFromPath(path,result.getName());
			  logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			  }else if(result.getStatus() == ITestResult.SKIP) {
				  logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
				  
			  }
	  }
		  

  @AfterTest
  public void testLast() {
	logger = extent.createTest("end report"); 
	driver.quit();
	extent.flush();
  }
}









