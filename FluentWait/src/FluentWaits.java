

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaits { // Do not change the class name

	// Use the below declared variables
	public static WebDriver driver;
	WebElement fileNametxt;
    static String Filename;
	String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/SmartUniversity/add_stud.html";

	public FluentWaits(WebDriver driver) {
		this.driver = driver;
	}

	public FluentWaits() {
	}

	public WebDriver setupDriver() { // Do not change the method signature

		//Create driver,store it in static variable driver, navigate to baseUrl and return it
		driver = DriverSetup.getDriver();
		driver.get(baseUrl);
        return driver;
	}

	public String getPageTitle() {

		// get the page title and return the same

		return driver.getTitle();
	}

	public WebElement clickPhotoUploadBtn() {
        // Click the photo upload button
        // Create a FluentWait instance with a timeout of 10 seconds, polling every 1 second
        // Wait for the filename element to become visible
        // Retrieve the text of the filename element
        // Return the WebElement of the filename element
		driver.findElement(By.id("file1")).click();
		
		Wait<WebDriver> wait = new FluentWait<>(driver)
			    .withTimeout(Duration.ofSeconds(10))
			    .pollingEvery(Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filename")));
		fileNametxt  = driver.findElement(By.id("filename"));
	    Filename = fileNametxt.getText();
	    return fileNametxt;
	    
	}

	public static void main(String[] args) { // Do not change the method signature

		FluentWaits reg = new FluentWaits();
		reg.setupDriver();
		System.out.println(reg.getPageTitle());
		reg.clickPhotoUploadBtn();

	}

}
