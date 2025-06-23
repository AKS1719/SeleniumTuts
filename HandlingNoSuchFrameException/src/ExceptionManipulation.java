import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;

public class ExceptionManipulation {
	
	public static WebDriver driver; 
	static String baseUrl = "https://webapps.tekstac.com/PurchaseApp/";
	
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
	
	public Exception handleException(String locator) {
	    
	    // Attempt to switch to a frame by the passed parameter (this will throw NoSuchFrameException if the frame is not found)
		// If the Iframe is found, return null	     
	    // If the Iframe is not found, then catch the NoSuchFrameException and return it
	    try {
	    	driver.switchTo().frame(locator);
	    }
	    catch(NoSuchFrameException e) {
	    	return e;
	    }
	    return null;
	    }	
	
	
	public static void main(String[] args) throws Exception {
		ExceptionManipulation mainObj = new ExceptionManipulation();
		mainObj.createDriver();
		System.out.println(mainObj.handleException("nonFrameElement"));
     
    }
	
}
