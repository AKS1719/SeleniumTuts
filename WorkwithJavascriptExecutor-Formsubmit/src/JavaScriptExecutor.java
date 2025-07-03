//import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class JavaScriptExecutor{    //Do not change the class name
	
	//Use the below declarations
	public static WebDriver driver;
	public static Object jsname,jshod, jsphone, jsemaiId, jscount, jsstatus,jsadd;
	String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/SmartUniversity/add_dept.html";
	
	public WebDriver createDriver() { // DO NOT CHANGE THE METHOD SIGNATURE 
		// Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate and return it
	    driver = DriverSetup.getWebDriver();
	    
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
		
		return driver;
	
	}
 
 
    public void submitForm(String name,String hod, String phone, String email, int count,String status) { // DO NOT CHANGE THE METHOD SIGNATURE
	    JavascriptExecutor jse = ((JavascriptExecutor)driver);
	    
	    //Using javascript executor, locate the elements of 'name','hod','phone','email'
	    //'count','status' and send the received values.
	    //Submit the form
	    jse.executeScript("document.getElementById('deptName').value='"+ name+"';");
	    jse.executeScript("document.getElementById('deptHead').value='"+ hod+"';");
	    jse.executeScript("document.getElementById('phoneNo').value='"+ phone+"';");
	    jse.executeScript("document.getElementById('emaiId').value='"+ email+"';");
	    jse.executeScript("document.getElementById('studentCount').value='"+ count+"';");
	    jse.executeScript("document.getElementById('status').value='"+ status+"';");
	    jse.executeScript("document.getElementById('addDept-now').click();");

	       
                
  }
  
  
  public String getMessage() {
      
	  JavascriptExecutor jse = ((JavascriptExecutor)driver);
	  //Using javascript executor, locate the name displayed and return it
	  return  (String)jse.executeScript("return document.querySelector('#deptTable tbody tr:last-child td:nth-child(1)').textContent;") +"\n"+
	  (String)jse.executeScript("return document.querySelector('#deptTable tbody tr:last-child td:nth-child(2)').textContent;")+"\n"+
	  (String)jse.executeScript("return document.querySelector('#deptTable tbody tr:last-child td:nth-child(3)').textContent;") +"\n"+
	  (String)jse.executeScript("return document.querySelector('#deptTable tbody tr:last-child td:nth-child(4)').textContent;")+"\n"+
	  (String)jse.executeScript("return document.querySelector('#deptTable tbody tr:last-child td:nth-child(5)').textContent;") +"\n"+
	  (String)jse.executeScript("return document.querySelector('#deptTable tbody tr:last-child td:nth-child(6)').textContent;")+"\n"
	  ;
    
  }
  
  
  public static void main(String[] args) {
	    JavaScriptExecutor at=new JavaScriptExecutor();
		at.createDriver();
		//Use this values to submit the form
		at.submitForm("cse","akshat","1234567890","email@email.com",20,"Active");
		System.out.println(at.getMessage());

	}
  
}