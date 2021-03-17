package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropReadTest {
 WebDriver driver;
 Properties prop;
 
 @BeforeMethod
	public void setup() throws IOException {
	 
	 WebDriverManager.chromedriver().setup();
	 driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		FileInputStream in= new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//login.properties");
		prop=new Properties();
		prop.load(in);
		
	}
 @Test
 public void loginTest() {
	 driver.get("https://the-internet.herokuapp.com/login"); 
	
  driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
  driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
  driver.findElement(By.xpath("//button[@type='submit']")).click();
  
 }
 
 @AfterMethod
	public void teardown() {
		//driver.close();
	}
}
