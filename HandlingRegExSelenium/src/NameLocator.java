import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NameLocator {      //DO NOT change the class name
 
    //Use the below declared variable
    public static WebDriver driver;
    String baseUrl = "https://webapps.tekstac.com/Handling_Regular_Expression/";
	
	public WebDriver createDriver() {   // DO NOT CHANGE THE METHOD SIGNATURE
	    // Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate and return it
	    
	    
	    // Please do NOT remove the below URL navigation code
	    driver = DriverSetup.getWebDriver();
	    driver.get(baseUrl);
		
		return driver;
	}
	
   	public void setFormValues(WebDriver driver) {   // DO NOT CHANGE THE METHOD SIGNATURE
	    //set the value for 'Shipment for user' and submit form
	    driver.findElement(By.id("userId")).sendKeys("Shamili");
	    driver.findElement(By.id("track")).click();
	    
	}

    
    public WebElement getEmailResultElement(WebDriver driver) { // DO NOT CHANGE THE METHOD SIGNATURE
        
        //Find the element of 'shamili93@gamil.com' and return it
        return driver.findElement(By.id("e- mail"));
       
    }
    
    public boolean validateEmail(String eMailID) {  // DO NOT CHANGE THE METHOD SIGNATURE
       //Validate email using regex. 
       return eMailID.matches("\\b[A-Z0-9a-z-]+@[a-z]+\\.[a-z]{2,4}\\b");
        
    }
    
  
    public static void main(String[] args) {    // DO NOT CHANGE THE METHOD SIGNATURE
	    NameLocator reg=new NameLocator();
	     //Add required code here
	     WebDriver d = reg.createDriver();
	     reg.setFormValues(d);
	     WebElement we = reg.getEmailResultElement(d);
//	     System.out.println(we);
//	     System.out.println(we.getText());
	   System.out.println(reg.validateEmail(we.getText()));
	}

  
}
