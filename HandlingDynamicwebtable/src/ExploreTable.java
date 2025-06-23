
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
 
public class ExploreTable {      // DO NOT CHANGE THE CLASS NAME
 
	// Use the below declared variables 
	public static WebDriver driver;  
	public static int rowCount, colCount, specificRowCellValues, specificColumnCellValue; 
	String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/SmartUniversity/view_dept.html";
 
	 public ExploreTable(WebDriver driver) {
	        this.driver = driver;
	    }
	 
	 public ExploreTable() {
	    }
	 
	public WebDriver createDriver() {    // DO NOT CHANGe THE METHOD SIGNATURE
 
		// Invoke the getDriver() method from the DriverSetup class 
		// Store it in static variable 'driver', navigate and return it
		driver = DriverSetup.getDriver();
		driver.get(baseUrl);
		return driver;
	}
 
	public WebElement sortTable()
	{
		// Locate the webElement 'Sorting table data' , click on it and return the element

		driver.findElement(By.id("sorttable")).click();
		return driver.findElement(By.id("sorttable"));

	}
	public List<WebElement> fetchTableData() {  
	    
		// Finds all the rows of the table with id 'sortingTable' and returns them as a list of WebElements
        // Prints the text of each row
        WebElement table = driver.findElement(By.id("sortingTable"));
        List<WebElement> l = table.findElements(By.tagName("tr"));
        for(int i = 1 ; i < l.size();i++) {
        	List<WebElement> td = l.get(i).findElements(By.tagName("td"));
        	for(int j = 0 ;  j < td.size();j++) {
        		System.out.println(td.get(j).getText());
        	}
        }
        return l;
	}
	public List<WebElement> fetchColumnHeader() {    // DO NOT CHANGe THE METHOD SIGNATURE
 
    // Locate the table and finds all the table header cells (th elements) within the thead element of the table
    // Returns them as a list of WebElements
		List<WebElement> th = driver.findElements(By.tagName("th"));
    
        return th;
	}
 
	public List<WebElement> fetchSpecificRow() {
    
    // Retrieves a specific row (2nd row) from the table
    // Finds all the cells (td elements) within the specified row
    // Prints the values of the cells in the specified row
    // Returns all the rows of the table as a list of WebElements
		List<WebElement> tr = fetchTableData();
		List<WebElement> td = tr.get(1).findElements(By.tagName("td"));
		for(int i = 0 ;i < td.size();i++) {
			System.out.println(td.get(i).getText());
		}
        return td;
		
	}	
 
	public WebElement fetchSpecificColumn() {
		
	// Fetch the cell value of a first column in a third row
    // Finds all the rows in the table,
    // Specifies the row index '2' and column index '0' to retrieve the desired cell,
    // Retrieves the WebElement corresponding to the specified cell
    // Prints the value of the cell
    // Returns the WebElement representing the specific cell
		List<WebElement> tr = fetchTableData();
		List<WebElement> td = tr.get(2).findElements(By.tagName("td"));
		
		System.out.println(td.get(0).getText());
		
		return td.get(0);
	}	
	public static void main(String[] args) {    // DO NOT CHANGe THE METHOD SIGNATURE
 
		ExploreTable table = new ExploreTable();
 
		table.createDriver();
		table.sortTable();
		table.fetchTableData();
        table.fetchColumnHeader();
        table.fetchSpecificRow();
        table.fetchSpecificColumn();
 
	}	 	  	  		 	     	     	      	 	
	
}