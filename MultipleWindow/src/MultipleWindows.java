import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleWindows { // Do not change the class name

    static String parentWinHandle, parentWinTitle;
    static String childWinHandle, childWinTitle;
    Set<String> winHandles;

    static WebDriver driver;
    String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/TrainReservation/login.html";

    public WebDriver createDriver() { // Do not change the method signature
        driver = DriverSetup.getWebDriver(); // You need to implement this method in DriverSetup
        driver.get(baseUrl);
        return driver;
    }

    public String getParentWindow() throws Exception { // Do not change the method signature
        parentWinHandle = driver.getWindowHandle();
        parentWinTitle = driver.getTitle();
        return parentWinHandle;
    }

    public String getChildWindow() throws Exception { // Do not change the method signature
        driver.findElement(By.id("gmailsignin")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(2000); // Optionally wait for new window to open

        winHandles = driver.getWindowHandles();

        for (String handle : winHandles) {
            if (!handle.equals(parentWinHandle)) {
                childWinHandle = handle;
                driver.switchTo().window(childWinHandle);
                childWinTitle = driver.getTitle();
                break;
            }
        }

        return childWinHandle;
    }

    public static void main(String[] args) throws Exception { // Do not change the method signature
        MultipleWindows win = new MultipleWindows();
        win.createDriver();
        System.out.println("Parent Window Handle: " + win.getParentWindow());
        System.out.println("Child Window Handle: " + win.getChildWindow());

        System.out.println("Parent Title: " + parentWinTitle);
        System.out.println("Child Title: " + childWinTitle);

        driver.quit();
    }
}
