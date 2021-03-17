package testscripts;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonUtils.Utility;

public class ExtentTestReportTest {
	WebDriver driver;
	ExtentTest extentTest;
	ExtentReports reports;
	ExtentHtmlReporter htmlReport;


	@BeforeTest
	public void setExtentReport() {
		System.out.println("Before Test");
		reports= new ExtentReports();
		htmlReport= new ExtentHtmlReporter("D:\\Automation\\Selenium workshop\\Screenshot\\ExtentReport12.html");
		reports.attachReporter(htmlReport);
	}

	@BeforeMethod
	public void beforeTest() {
		System.out.println("Before method");
		System.setProperty("webdriver.chrome.driver",
				"D:\\Automation\\Selenium workshop\\SeleniumDrivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com"); 
	}

	@Test
	public void searchJavaTest() {
		System.out.println("Test 1");
		extentTest = reports.createTest("Search Java Test");
		WebElement searchBox = driver.findElement(By.name("q")); 
		searchBox.sendKeys("Java Tutorial");
		searchBox.submit();
		Assert.assertEquals("Java Tutoria - Google Search", driver.getTitle());
	}

	@Test
	public void searchCucumberTest() {
		System.out.println("Test 2");
		extentTest = reports.createTest("Search Cucumber Test");
		WebElement searchBox = driver.findElement(By.name("q")); 
		searchBox.sendKeys("Cucumber Tutorial");
		searchBox.submit();
		Assert.assertEquals("Cucumber Tutorial - Google Search", driver.getTitle());

	}

	//	@AfterMethod
	//	public void teardown(ITestResult result) throws IOException {
	//		if(ITestResult.FAILURE== result.getStatus()) {
	//			System.out.println("ITestResult.FAILURE: "+ITestResult.FAILURE);
	//			System.out.println("result.getStatus(): "+result.getStatus());
	//		String path= Utility.getScreenshot(driver);
	//		extentTest.fail(result.getName());
	//		System.out.println("text: "+result.getName());
	//		System.out.println("result.getThrowable().getMessage(): "+result.getThrowable().getMessage());
	//		extentTest.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	//		}
	//		driver.close();
	//	}
	//	
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {	
		String path= Utility.getScreenshot(driver);
		if(ITestResult.FAILURE== result.getStatus()) {
			extentTest.fail(result.getName());
			extentTest.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}else if(ITestResult.SUCCESS== result.getStatus()){
			extentTest.pass(result.getName());
			extentTest.pass("Test Passed!!! ", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		driver.close();
	}



	@AfterTest
	public void finishReport() {
		reports.flush();
	}


}
