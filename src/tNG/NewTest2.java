package tNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest2 {
	WebDriver driver;
	@Parameters({"BrowserName"}) 
	@Test(invocationCount=1, threadPoolSize=4)
  public void f(String BrowserName) {
	  try{
		  if(BrowserName.equals("Crome")){
			  System.setProperty("webdriver.chrome.driver","O:\\QA Courses\\54919.1\\Selenium Gil\\Resources\\Exe\\chromedriver.exe");
			  driver = new ChromeDriver();
			  System.out.println("Chrome");
		  }
		  else if (BrowserName.equals("Firefox")){
			  System.setProperty("webdriver.chrome.driver", "O:\\QA Courses\\54919.1\\Selenium Gil\\Resources\\Exe\\geckodriver.exe");
			  driver = new FirefoxDriver();
			  System.out.println("Firefox");
		  }
		  WebDriverWait wait = new WebDriverWait(driver, 20);
		  long id = Thread.currentThread().getId();
		  System.out.println("Thread id is: " + id);
		  Reporter.log("blabla");
		  
		  if (id == 11){
			  driver.get("http://www.johnbryce.co.il/");
			  System.out.println("AAA");
		  }
		  else {
			  driver.get("http://marketplace.eclipse.org/");
			  System.out.println("BBBBB");
		  }
		  Thread.sleep(5000);
	  }
	  catch(Exception e){
		  System.out.println("Error: " + e.getMessage());
		  
	  }
	}

	 
	  
  @BeforeMethod
  public void beforeMethod() {
//	  System.setProperty("webdriver.chrome.driver","O:\\QA Courses\\54919.1\\Selenium Gil\\Resources\\Exe\\chromedriver.exe");
//	  driver = new ChromeDriver();
//	  System.setProperty("webdriver.chrome.driver", "O:\\QA Courses\\54919.1\\Selenium Gil\\Resources\\Exe\\geckodriver.exe");
//	  driver = new FirefoxDriver();
//	  System.out.println("Chrome");
//	  System.out.println("Firefox");
  
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Close");
	  long id = Thread.currentThread().getId();
	  System.out.println("Thread: " + id);
	  driver.quit();
  }

	@DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
	}
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }
  public WebDriver getWebDriver(String type){
	  
	  WebDriver driver = null;
	  
	  if(type.equals("Chrome")){
		  driver.set(new ChromeDriver());
		  driver = driver.get();
	  }
	  
	  if(type.equals("Firefox")){
		  FirefoxDriver.set(new FirefoxDriver());
		  driver = firefoxDriver.get();
	  }
	  
	  return driver;
	  
  }
}
