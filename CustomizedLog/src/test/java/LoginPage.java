import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.NoAlertPresentException;
import org.apache.logging.log4j.core.config.Configurator;


public class LoginPage {

	private WebDriver driver;	
	public static String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/SmartUniversity/login.html";
	
	// Initialize a static logger instance for the LoginPage class using Log4j2
	
	
	// Default constructor
	public LoginPage() {	}
	
	// Constructor with WebDriver parameter
	public LoginPage(WebDriver driver) {
		this.driver = driver;
    }
	
	// Method to create and initialize the WebDriver
	public WebDriver createDriver() {
		 // Call the 'getDriver' method to initialize the driver,store it in static variable driver, navigate to baseUrl and return it
		 // Log the successful creation of the driver
		 // Then, Log the error if driver creation or navigation fails
	
        return driver;
	}
	
	// Method to set the Username field
	public void setUsername() {
		// Locate the username field by its ID and enter the value "admin"
		// Log an error message if locating the username field fails
	}
	
	// Method to set the Password field
	public void setPassword() {
	// Locate the password field by its ID and enter the value "admin#123"
	// Log an error message if locating the password field fails
	}
	
	// Method to set the Captcha field
	public void solveCaptcha() {
	// Identify and retrieve the WebElement corresponding to the captcha code generated
	// Set the retrieved captcha code into the input field
	// Log an error message if locating the captcha field fails
	
	}
	
	// Method to set the Submit button field
	public void submitLogin() {
	// Identify and click the WebElement corresponding to the Submit button
	// Log an error message if locating the Submit button fails
	}
	
	// Method to handle the alert
	public String alertHandle() throws Throwable
	{
		 // Switch to the alert
		 // Get the text from the alert
		 // Accept the alert (click OK)
		 // Log the alert text
		 // Log an error message if no alert is present
		 // Return the text from the alert
		 
		 return null;
	
	}
	
public static void main(String[] args) throws Exception
{
    Configurator.initialize(null, "CustomizedLog/src/main/resources/log4j2.xml"); //Do not remove the line
	LoginPage registerObj = new LoginPage();
	
	WebDriver driver = registerObj.createDriver();
	registerObj.setUsername();
	registerObj.setPassword();
	registerObj.solveCaptcha();
	registerObj.submitLogin();
	try {
		registerObj.alertHandle();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	            
	

}
	

}