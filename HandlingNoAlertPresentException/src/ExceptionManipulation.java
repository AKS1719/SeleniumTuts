import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

public class ExceptionManipulation {
	
	public static WebDriver driver; 
	static String baseUrl = "https://webapps.tekstac.com/HotelApplication/booking.html";
	
	public ExceptionManipulation() {}
	public ExceptionManipulation(WebDriver driver)
	{
		this.driver=driver;
	}
	

	public WebDriver createDriver() {
       //Create driver by calling 'getDriver' method,store it in static variable driver, navigate to baseUrl and return it
       
		driver = DriverSetup.getDriver();
		driver.get(baseUrl);
       
        return driver;
    }	
	
	public Exception handleException() {
	    // Attempt to switch to an alert
	    // If an alert is present, return null
	    // If no alert is present, then catch the NoAlertPresentException and return it
	    try {
	    	driver.switchTo().alert();
	    }
	    catch(NoAlertPresentException e) {
	    	return e;
	    }
	    return null;
	    
	}
	
	
	public static void main(String[] args) throws Exception {
		ExceptionManipulation mainObj = new ExceptionManipulation();
		mainObj.createDriver();
		System.out.println(mainObj.handleException());
         
     
    }
	
}
