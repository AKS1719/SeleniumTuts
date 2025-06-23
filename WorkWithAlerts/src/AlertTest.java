import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;

public class AlertTest {   //DO NOT Change the class Name

    // Use the below declared variables 
	public static WebDriver driver;
	String baseUrl = " http://webapps.tekstac.com/MultipleWindow/";
	
	public WebDriver createDriver() { //DO NOT change the method signature
	
	   // Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate and return it
	    driver = DriverSetup.getWebDriver();
	    
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
		
        return driver;

	}
	
	public Alert getAlertElement(WebDriver driver) {   //DO NOT change the method signature
	
	    //Find the 'click' buttton and click it.
	    //Locate the 'Alert' element and return it
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Alert alert = driver.switchTo().alert();
	    return alert;
	    
	}

	public static void main(String[] args) throws InterruptedException {  //DO NOT change the method signature
	      
	    AlertTest at=new AlertTest();
	    //Implement code here
	    at.createDriver();
	    System.out.println(at.getAlertElement(driver).getText());

	}

}

