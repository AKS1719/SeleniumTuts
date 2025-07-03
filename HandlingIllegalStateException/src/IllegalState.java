
import org.openqa.selenium.WebDriver;

public class IllegalState {
    private static WebDriver driver;
    private String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/SmartUniversity/add_stud.html";

    public IllegalState(WebDriver driver) {
        this.driver = driver;
    }

    public IllegalState() {
    }

    public Exception setupDriver(){ // Do not change the method signature
    // Attempt to perform the following operations:
    
    // Invoke the getDriver() method from the DriverSetup file
    // Store the returned WebDriver instance in the static variable 'driver'
    // Navigate to the URL specified by the 'baseUrl' variable
    // If any exception occurs during the operations in the try block:
    // Print the stack trace of the caught exception
    // Return the caught exception
    
        try{
            driver = DriverSetup.getDriver();
            driver.get(baseUrl);
            System.out.println("true");
            return null;
        }
        catch(IllegalStateException e){
            e.printStackTrace();
            return e;
        }
        
    }

    public static void main(String[] args) { // Do not change the method signature
        IllegalState reg = new IllegalState();
            reg.setupDriver();
    }
}