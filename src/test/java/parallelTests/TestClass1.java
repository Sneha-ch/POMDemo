package parallelTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass1 {

@BeforeMethod	
public void beforeMethod() {
	long id = Thread.currentThread().getId();
	System.out.println("Before Test method1. Test id is: "+id);
}

@Test
public void TestOne() {
	long id = Thread.currentThread().getId();
	System.out.println("TestOne1. Test id is: "+id);
}

@Test	
public void TestTwo() {
	long id = Thread.currentThread().getId();
	System.out.println("TestTwo1. Test id is: "+id);
}

@Test	
public void TestThree() {
	long id = Thread.currentThread().getId();
	System.out.println("TestThree1. Test id is: "+id);
}

@AfterMethod	
public void afterMethod() {
	long id = Thread.currentThread().getId();
	System.out.println("After Test method1. Test id is: "+id);
}
}
