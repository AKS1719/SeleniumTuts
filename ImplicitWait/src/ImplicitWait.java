
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImplicitWait {

	public static WebDriver driver;
	WebElement Nametxt;
	String baseUrl = "https://webapps.tekstac.com/PurchaseApp/";
	static String text;

	public ImplicitWait(WebDriver driver) {
		this.driver = driver;
	}

	public ImplicitWait() {
	}

	public WebDriver setupDriver() {
		//Create driver,store it in static variable driver, navigate to baseUrl and return it
		driver = DriverSetup.getDriver();
		driver.get(baseUrl);
        return driver;
	}

	public String getPageTitle() {
		// get the page title
        //return pageTitle;
		return driver.getTitle();
	}

	public WebElement clickBtn() {
		//Locate Corresponding Web Element and Enter quantity in the input field
		//Locate Corresponding Web Element and Click on the checkbox
        //Locate Corresponding Web Element and Click on the show button
        //Set an implicit wait of 50 seconds to handle dynamic content loading
        //Find and return the table values that describe the purchased items as WebElement.
        WebElement we = driver.findElement(By.id("ComputerQuantity"));
        we.sendKeys("5");
        driver.findElement(By.id("ComputerCheck")).click();
        driver.findElement(By.id("show")).click();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		return driver.findElement(By.xpath("(//table)[2]"));
	}
	public static void main(String[] args) {
		ImplicitWait locator = new ImplicitWait();
		locator.setupDriver();
		locator.getPageTitle();
		locator.clickBtn();
	}
}
