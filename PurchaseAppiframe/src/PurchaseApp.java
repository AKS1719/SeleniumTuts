import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PurchaseApp { // Do not change 
    
    // Use the below declarations
    static WebDriver driver;
    
    static String frameText;
	static int frameSize;  
	String baseUrl = "https://webapps.tekstac.com/PurchaseApp/";

    
	public WebDriver createDriver() {   // Do not change the method signature
	    
		// Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate and return it
	    driver = DriverSetup.getWebDriver();
	    
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
		
		return driver;
		
	}
	
	
	public String LocateIFrameText() {  // Do not change the method signature  
	    
	    
	    // Locate and identify the total number of iframes
		frameSize = driver.findElements(By.tagName("iframe")).size();
	    // Store it in a globally declared static variable 'frameSize'
        // Print it
		System.out.println(frameSize);
	    

        // Get the WebElement object of the iframe using the id of the iframe.
        // Switch to the iframe using the WebElement object
		
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
        
        // Locate the <h2> element inside the iframe
		
		WebElement h2 = driver.findElement(By.tagName("h2"));
		frameText = h2.getText();
        // Get the text and store it in a static variable 'frameText'
        // print the text present on the iframe,
		System.out.println(frameText);
        
        // Switch to the defaultContent  (to move back to most parent or main frame)
        driver.switchTo().defaultContent();
	    // Return the frameText
	    return frameText;
	    
	}
	
	public void closeBrowser() {  // Do not change the method signature
	     
		// close the browser
		if(driver !=null) {
			driver.close();
		}
	}


	public static void main(String[] args){
		
		PurchaseApp app = new PurchaseApp();  
		
		// Add your code here
		app.createDriver();
		app.LocateIFrameText();
//		app.closeBrowser();
		
	}	 	  	  		 	     	     	      	 	

}




