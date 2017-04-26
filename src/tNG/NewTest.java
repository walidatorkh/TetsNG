package tNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String n, String s) {
	driver.get(n);
	
	try {
		Thread.sleep(1000);
	}catch (InterruptedException e){
		e.printStackTrace();
	}
  }
//  public class NewTest1 {
//		WebDriver driver;
//	  @Test(dataProvider = "browsers")
//	  public void f(String url1, String url2) {
//		driver.get(url1);
//		driver.get(url2);
//		
//		try {
//			Thread.sleep(1000);
//		}catch (InterruptedException e){
//			e.printStackTrace();
//		}
//	  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","O:\\QA Courses\\54919.1\\Selenium Gil\\Resources\\Exe\\chromedriver.exe");
	  driver = new ChromeDriver();
	 // System.setProperty("webdriver.chrome.driver", "O:\\QA Courses\\54919.1\\Selenium Gil\\Resources\\Exe\\geckodriver.exe");
	  //driver = new FirefoxDriver();
	  System.out.println("Chrome");
	 // System.out.println("Firefox");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
//  @DataProvider(parallel=true)	
//  public Object[][] browsers() {
//    return new Object[][] {
//      new Object[] { "Chrome" },
//      new Object[] { "Firefox" },
//    };
//  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "https://www.yahoo.com/", "n" },
      new Object[] { "https://www.google.co.il/", "s" },
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
  }

