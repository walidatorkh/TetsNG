package Grid;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Grid {

	WebDriver driver;
	DesiredCapabilities capability;
	String id;

	@Test(invocationCount = 1, threadPoolSize = 4)
	public void f() {

		try {

//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\jbt\\Desktop\\Grid\\chromedriver.exe");
			System.out.println("Thread ID:" + Thread.currentThread().getId());
			driver.get("http://www.google.co.il");
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(id)).click();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		

	}

	@Parameters({ "browserName" })
	@BeforeMethod
	public void beforeMethod(@Optional("Firefox") String browserName) {

		try {

			// System.setProperty("webdriver.chrome.driver","C:\\Users\\jbt\\Desktop\\Grid\\IEDriverServer.exe");

			if (browserName.equals("Chrome")) {
				// System.setProperty("webdriver.chrome.driver","C:\\Resources\\Exe\\chromedriver.exe");
				capability = DesiredCapabilities.chrome();
				System.out.println("Running CHROME");
				id = "//img[@id='hplogo']";
			}

			// else if(browserName.equals("Firefox")) {
			//// System.setProperty("webdriver.gecko.driver","C:\\Resources\\Exe\\geckodriver.exe");
			// capability = DesiredCapabilities.firefox();
			// System.out.println("Running FIREFOX");
			// }
			else if (browserName.equals("IE")) {
				// System.setProperty("webdriver.gecko.driver","C:\\Resources\\Exe\\geckodriver.exe");
				capability = DesiredCapabilities.internetExplorer();
				System.out.println("Running IE");
				id = "//div[@id='hplogo']/a";
			}

			capability.setPlatform(Platform.WIN10);
			capability.setCapability("version", "");

			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
			//driver.get("http://www.google.com");

			//driver.findElement(By.name("q")).sendKeys("Cheese");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@AfterMethod
	public void afterMethod() {

		if (driver != null) {
			System.out.println("Closing Thread: " + Thread.currentThread().getId());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.quit();

		}

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
