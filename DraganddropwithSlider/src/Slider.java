import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.io.IOException;

public class Slider {  //DO NOT Change the class Name
	
	// Use the below declared variables
	public static WebDriver driver;
	public static String productInfo;
    public static String quantityInfo;
    public static String priceInfo;
    String baseUrl = "http://webapps.tekstac.com/OnlineShopping/fashion.html";
    
	
	public WebDriver createDriver() {    //DO NOT change the method signature
	
	    // Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate and return it
	    driver = DriverSetup.getWebDriver();
	    
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
		
		return driver;
	}
	
	public void implDragnDrop() {   //DO NOT change the method signature
	
        // Locate the source web element that needs to be dragged.
		WebElement source = driver.findElement(By.id("Shirts"));
//		System.out.println(source.getText());
        // Locate the target web element that needs to be dropped.      
		WebElement dest = driver.findElement(By.id("droppable"));
//		System.out.println(dest.getText());
        // Creating object of Actions class to build composite actions
		Actions action = new Actions(driver);
        // Performing the drag and drop action
		action.dragAndDrop(source, dest).perform();;
		

	}
	
	public void implMoveSlider()    {   //DO NOT change the method signature
	    // Creating object of Actions class to build composite actions

        // Locate the slider web element

        // Move the slider to '5'

        // For Example

            // You can use the below methods to move the slider

            // * moveToElement(WebElement target)

            // * dragAndDropBy(WebElement source, int xOffset, int yOffset)

            // xOffset value is chosen as given below
                
            //    a. If the ‘quantity’ value is 5 the xOffset is  '-60' or '-10'
            //    b. If the ‘quantity’ value is 4 the xOffset is '-120'
            //    c. If the ‘quantity’ value is 3 the xOffset is  '-240'
            //    d. If the ‘quantity’ value is 6 the xOffset is '60'
            //    e. If the ‘quantity’ value is 7 the xOffset is '120'
            //    f. If the ‘quantity’ value is 8 the xOffset is '240'

            // yOffset value is default ‘0’
		WebElement we = driver.findElement(By.id("myRange"));
		Actions action = new Actions(driver);
		action.moveToElement(we);
		action.dragAndDropBy(we, -10, 0).perform();;
	}
	
	public String getProductDetail()    { //DO NOT change the method signature
    
        // Locate the text displaying the product name. 

        // Assign the displaying text to the static variable 'productInfo'

        // Return the text using getText() method.
			productInfo = driver.findElement(By.id("product")).getText();
            return productInfo;

    }
    
    
    public String getQuantityDetail(){ //DO NOT change the method signature

        // Locate the text displaying the product quantity(No). 

        // Assign the displaying text to the static variable 'quantityInfo'

        // Return the text using getText() method.
    	quantityInfo = driver.findElement(By.id("No")).getText();
        return quantityInfo;
    }
   
   
    public String getPriceDetail(){  //DO NOT change the method signature
        // Locate the text displaying the product price. 

        // Assign the displaying text to the static variable 'priceInfo'

        // Return the text using getText() method.
    	priceInfo = driver.findElement(By.id("price")).getText();
                    return priceInfo;

    }

	public static void main(String[] args){          //DO NOT change the method signature
	    Slider ex =new Slider();
	    
	    //Implement the required code
	    //Close the driver
	    ex.createDriver();
	    ex.implDragnDrop();
	    ex.implMoveSlider();
	    System.out.println(ex.getProductDetail() + " "+ ex.getQuantityDetail()+  "  "+ ex.getPriceDetail());
	    
	}
}

