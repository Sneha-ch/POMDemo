package testscripts;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Test
public class CsvReadTest {
	
	
	WebDriver driver;
	 @BeforeMethod
		public void beforeTest() {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Automation\\Selenium workshop\\SeleniumDrivers\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://the-internet.herokuapp.com/login"); 
		}
	 
	//@Parameters({"uname","pwd"})
	 @Test(dataProvider="login_data")
  public void loginTest(String strName, String strPwd) {
		 System.out.println("strName: "+strName);
		 System.out.println("strPwd: "+strPwd);
	  driver.findElement(By.id("username")).sendKeys(strName);
	  driver.findElement(By.id("password")).sendKeys(strPwd);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  System.out.println(driver.findElement(By.xpath("//i[contains(text(),'Logout')]")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.xpath("//i[contains(text(),'Logout')]")).isDisplayed());
		
				
	}
	
	@DataProvider(name="login_data")
	public Object[][] getLoginData() throws CsvValidationException, IOException {
		String filepath= System.getProperty("user.dir")+"//src//test//resources//CSVData.csv";
		CSVReader reader = new CSVReader(new FileReader(filepath));
		String col[];
		ArrayList<Object[]> datalist= new ArrayList<Object[]>();
		while((col=reader.readNext()) !=null) {
			Object[] record= {col[0], col[1]};
			datalist.add(record);
		}
		reader.close();
		return datalist.toArray(new Object[datalist.size()][]);
}
	
	
	
	 @AfterMethod
		public void teardown() {
			//driver.close();
		}
 
}
