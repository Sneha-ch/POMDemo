package parallelTests;

import org.testng.annotations.Test;

public class IndependantThread {
    @Test(threadPoolSize = 2, invocationCount=4, timeOut=1000)
    public void testMethod() {
         long id = Thread.currentThread().getId();
          System.out.println("Test Method executing on thread with ID : "+id);
    }
}
