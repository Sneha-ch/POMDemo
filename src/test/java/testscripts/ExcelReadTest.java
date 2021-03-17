package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelReadTest {
 WebDriver driver;
 Properties prop;
 
 @BeforeMethod
	public void setup() throws IOException {
	 
	 WebDriverManager.chromedriver().setup();
	 driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//FileInputStream in= new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//ExcelData.xlsx");
	//	FileInputStream in= new FileInputStream("D://Automation//Selenium workshop//SeleniumInputData//ExcelData.xlsx");
		
		
	}
 @Test
 public void loginTest() throws IOException {
	 driver.get("https://the-internet.herokuapp.com/login"); 
	
  driver.findElement(By.id("username")).sendKeys(readExcelData("username"));
  driver.findElement(By.id("password")).sendKeys(readExcelData("password"));
  driver.findElement(By.xpath("//button[@type='submit']")).click();
  
 }
 
 public static String readExcelData(String colName) throws IOException {
	 String filepath= System.getProperty("user.dir")+"//src//test//resources//ExcelData.xlsx";
	 FileInputStream in = new FileInputStream(filepath);
	 XSSFWorkbook workbook= new XSSFWorkbook(in);
	 XSSFSheet loginSheet= workbook.getSheet("loginData");
	 String colValue="";
	 for (int i=1; i<=loginSheet.getLastRowNum(); i++) {
		 XSSFRow row = loginSheet.getRow(i);
		 if(row.getCell(0).getStringCellValue().equalsIgnoreCase(colName)) {
			 colValue= row.getCell(1).getStringCellValue();
		 }
	 }
	
	 workbook.close();
	 return colValue;
	 
 }
 
 @AfterMethod
	public void teardown() {
		//driver.close();
	}
}
