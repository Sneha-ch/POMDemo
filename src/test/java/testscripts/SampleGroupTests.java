package testscripts;

import org.testng.annotations.Test;

public class SampleGroupTests {
	
  @Test(groups= {"featureOne"})
  public void addTest() {
		System.out.println("Add test");
	}
  
  @Test(groups= {"featureTwo"})
  public void subtractTest() {
		System.out.println("Subtract test");
	}
  
  
  @Test(groups= {"featureOne"})
  public void divideTest() {
		System.out.println("Divide test");
	}
  
  
  @Test(groups= {"featureTwo"})
  public void multiplyTest() {
		System.out.println("Multiply test");
	}
  
  
  @Test
  public void ModulusTest() {
		System.out.println("Modulus test");
	}
}
