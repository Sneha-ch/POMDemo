package testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;



public class RemoteDriverTestGrid {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		
		String strHub= "http://192.168.43.238:4444/wd/hub";
		
		//WebDriver driver = new RemoteWebDriver(new URL(strHub, options));
		
		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		driver.get("https://demo.opencart.com/");
//		WebElement searchBox= driver.findElement(By.name("search"));
//		searchBox.sendKeys("phone");
//		driver.findElement(By.xpath("//*[@id='search']/span/button"));
//		System.out.println(driver.getTitle());
	}

}
