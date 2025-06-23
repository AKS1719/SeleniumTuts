import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class ExceptionManipulation {
	
	public static WebDriver driver; 
	static String baseUrl = "https://webapps.tekstac.com/Users/";
	
	public ExceptionManipulation() {}
	public ExceptionManipulation(WebDriver driver)
	{
		this.driver=driver;
	}
	

	public WebDriver createDriver() {
       //Create driver by calling 'getDriver' method,store it in static variable driver, navigate to baseUrl and return it
       driver = DriverSetup.getWebDriver();
       driver.get(baseUrl);
        return driver;
    }	
	
	public Exception handleException(String invalidLocator) {
	    // Attempts to locate an element using the passed parameter and returns null if no exception found.
	    // Otherwise, catches the NoSuchElementException and returns the same.
	    try {
	    	driver.findElement(By.id(invalidLocator));
	    }
	    catch(NoSuchElementException nsef) {
	    	return nsef;
	    }
	    return null;
	    
	}
	
	
	public static void main(String[] args) throws Exception {
		ExceptionManipulation mainObj = new ExceptionManipulation();
		mainObj.createDriver();
		System.out.println(mainObj.handleException("nonExistentElement"));
         
     
    }
	
}
