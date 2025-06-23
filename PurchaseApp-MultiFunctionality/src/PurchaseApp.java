import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchaseApp {	//DO NOT change the class name

    //Use the below declared variable
    private static WebDriver driver;
    private String baseUrl = "https://webapps.tekstac.com/PurchaseApp/";
	
	public PurchaseApp() {}
	public PurchaseApp(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebDriver createDriver()
	{
	   //Create driver,store it in static variable driver, navigate to baseUrl and return it
	    driver = DriverSetup.getDriver();
	    driver.get(baseUrl);
		return driver;
	}
	
	public String chooseItemPreQuantity() {
		// Clicks on the "Computer" checkbox to select it
        // Retrieves the error message element for displaying any errors related to item selection
        // Gets the text of the error message element and returns it
		driver.findElement(By.id("ComputerCheck")).click();
		
		return driver.findElement(By.id("errormsg")).getText();
	}
	
	public void chooseItemPostQuantity(String computerQuantity, String laptopQuantity,String mobileQuantity,String televisionQuantity,String refrigeratorQuantity)
	{
		
		
	// Sets the quantity for the computer item and selects its checkbox
		driver.findElement(By.id("ComputerQuantity")).sendKeys(computerQuantity);
		driver.findElement(By.id("ComputerCheck")).click();
    // Sets the quantity for the laptop item and selects its checkbox

		driver.findElement(By.id("LaptopQuantity")).sendKeys(laptopQuantity);
		driver.findElement(By.id("LaptopCheck")).click();
		
    // Sets the quantity for the mobile item and selects its checkbox
		driver.findElement(By.id("TelevisionQuantity")).sendKeys(televisionQuantity);
		driver.findElement(By.id("TelevisionCheck")).click();
    // Sets the quantity for the television item and selects its checkbox
		driver.findElement(By.id("MobileQuantity")).sendKeys(mobileQuantity);
		driver.findElement(By.id("MobileCheck")).click();
    // Sets the quantity for the refrigerator item and selects its checkbox
		driver.findElement(By.id("RefrigeratorQuantity")).sendKeys(refrigeratorQuantity);
		driver.findElement(By.id("RefrigeratorCheck")).click();

	}	 	  	      		      	   	     	     	 	

	public void enablePurchasedProduct()
	{
		//Find the show radio button and click it
		driver.findElement(By.id("show")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	
	}
	
	public String getComputerQuantity() {
		//Locate the Computer quantity in the resultant table
	    // Use WebDriverWait to wait for the element to be visible
	    // Return the text of the located element
	    
	    return driver.findElement(By.xpath("//body[1]/div[1]/div[2]/p[2]/table[1]/tbody[1]/tr[2]/td[2]")).getText();
	    
	}
	
	public String getLaptopQuantity() {
		//Locate the Laptop quantity in the resultant table and return it
		return driver.findElement(By.xpath("//body[1]/div[1]/div[2]/p[2]/table[1]/tbody[1]/tr[3]/td[2]")).getText();
	    
	}
	
	public String getMobileQuantity() {
		//Locate the Mobile quantity in the resultant table and return it
		return driver.findElement(By.xpath("//body[1]/div[1]/div[2]/p[2]/table[1]/tbody[1]/tr[4]/td[2]")).getText();
		
	}
	
	public String getTelevisionQuantity() {
		//Locate the Television quantity in the resultant table and return it
		
		return driver.findElement(By.xpath("//body[1]/div[1]/div[2]/p[2]/table[1]/tbody[1]/tr[5]/td[2]")).getText();
	}
	
	public String getRefrigeratorQuantity() {	 	  	      		      	   	     	     	 	
		//Locate the Refrigerator quantity in the resultant table and return it
		
		return driver.findElement(By.xpath("//body[1]/div[1]/div[2]/p[2]/table[1]/tbody[1]/tr[6]/td[2]")).getText();
	}
	public void disablePurchasedProduct()
	{
		//Find the hide radio button and click it
		driver.findElement(By.id("hide")).click();
		
	}
	public String getTotalPrice()
	{
		//Locate the total purchased cost and return it
		
		return driver.findElement(By.id("result")).getText();
	}
	
	public static void main(String[] args) {
		
	 PurchaseApp obj1 = new PurchaseApp();
    WebDriver driver = obj1.createDriver();
    String res = obj1.chooseItemPreQuantity();
	System.out.println("Error message: "+res);
    obj1.chooseItemPostQuantity("2", "7", "10", "4", "3");
    obj1.enablePurchasedProduct();
    String compQuantity = obj1.getComputerQuantity();
    System.out.println(compQuantity);
    obj1.disablePurchasedProduct();
    System.out.println(obj1.getTotalPrice());
	}
}
	 	  	      		      	   	     	     	 	
