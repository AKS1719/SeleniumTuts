import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeOut {
    public static WebDriver driver;
    String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/SmartUniversity/add_stud.html";

    public TimeOut(WebDriver driver) {
        this.driver = driver;
    }

    public TimeOut() {
    }

    public WebDriver setupDriver() {
        // Get driver from DriverSetup and open the baseUrl
        driver = DriverSetup.getDriver();
        driver.get(baseUrl);
        return driver;
    }

    public String getPageTitle() {
        // Return current page title
        return driver.getTitle();
    }

    public Exception clickPhotoUploadBtn() throws TimeoutException {
        try {
            // Click on button with id "file1"
            WebElement uploadBtn = driver.findElement(By.id("file1"));
            uploadBtn.click();

//            WebDriverWait wait = new WebDriverWait(driver, 1);
//            WebElement filename = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(By.id("filename"))
//            );

//            System.out.println(filename.getText());

            return null;
        } catch (TimeoutException e) {
            // Print stack trace and return the exception
            e.printStackTrace();
            return e;
        }
    }
}
