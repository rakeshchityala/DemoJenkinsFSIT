package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FirstTest {
	WebDriver driver;
	  @Test(dataProvider = "dp")
	  public void f(String un, String pwd) throws InterruptedException {
		  driver.findElement(By.id("txtUsername")).sendKeys(un);
		  driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		  driver.findElement(By.id("btnLogin")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("welcome")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//a[@href=\"/index.php/auth/logout\"]")).click();
		  
	  }
	  
	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "Admin", "admin123" },
	      new Object[] { "linda.anderson", "linda.anderson" },
	    };
	  }
	  @BeforeTest
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver", "D://JigSaw Learning//Selenium//Drivers//Chrome Driver 85.0.4183.87//chromedriver_win32//chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		  driver.manage().window().maximize();
	  }

	  @AfterTest
	  public void afterTest() throws InterruptedException {
		 driver.close();
	  }


}
