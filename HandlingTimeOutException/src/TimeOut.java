
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeOut {
	public static WebDriver driver;
	String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/SmartUniversity/add_stud.html";
	static String text;

	public TimeOut(WebDriver driver) {
		this.driver = driver;
	}

	public TimeOut() {
	}

	public WebDriver setupDriver() { // Do not change the method signature

		// Invoke the getDriver() method from the DriverSetup File
		// Store it in static variable 'driver' and return it
        return null;
	}
	
	public String getPageTitle() {

		// get the page title
        //return pageTitle;
		return null;
	}
	
	public Exception clickPhotoUploadBtn() throws TimeoutException {
		     // Initialize WebDriverWait
		     // Click on the element with Locate Corresponding Web Element
		     // Wait until the element is visible
		     // Retrieve the text from the element
		    // Return null to indicate success
		    // Return the TimeoutException for further handling
		    return null;

	}
	
	
	public static void main(String[] args) { // Do not change the method signature
		TimeOut reg = new TimeOut();
		reg.setupDriver();
		reg.getPageTitle();
		reg.clickPhotoUploadBtn();
	}
}
