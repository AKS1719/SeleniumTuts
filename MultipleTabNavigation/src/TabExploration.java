import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TabExploration { // Do not change the class name

    // Use these declarations to store respective values
    static String parentWinHandle, parentWinTitle;
    
    static WebDriver driver;
    String baseUrl = "https://webapps.tekstac.com/PurchaseApp/";

    public WebDriver createDriver() { // Do not change the method signature

        // Invoke the getDriver() method from the DriverSetup File
        // Store it in static variable 'driver', navigate to baseurl and return it
    	driver = DriverSetup.getDriver();
    	driver.get(baseUrl);
        return driver;
    }

    public String getParentWindow() throws Exception { // Do not change the method signature

        // Get the handle of the parent window as a string and store it in static variable 'parentWinHandle'
        // Get the title of the current page, store it in 'parentWinTitle' and return it.
        parentWinHandle = driver.getWindowHandle();
        parentWinTitle = driver.getTitle();
        return parentWinTitle;

    }

    public WebElement getChildWindow() throws Exception { // Do not change the method signature

    	// Click the href link to open the child window 'Computer'
        // Switch to the child window
        // Wait for the child window to open (adjust the wait time as needed)
        // The WebElement corresponding to the first <h3> tag is retrieved and returned
       driver.findElement(By.xpath("//a[normalize-space()='Computer']")).click();
       Actions action = new Actions(driver);
    	action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(2000);
        Set<String> handles =  driver.getWindowHandles();
        for(String handle : handles) {
        	driver.switchTo().window(handle);
        }
        
    	return driver.findElement(By.tagName("h3"));
    }

   
    public static void main(String[] args) throws Exception { //Do not change the method signature
    	 TabExploration win = new TabExploration();
    	    // Implement code here
    	    win.createDriver(); 
    	    win.getParentWindow();
    	    System.out.println(win.getChildWindow().getText());
    	    
	}
}
