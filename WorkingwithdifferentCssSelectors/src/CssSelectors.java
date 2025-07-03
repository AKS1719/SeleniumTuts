import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CssSelectors {
    public static WebDriver driver;
    String baseUrl = "https://webapps.tekstac.com/ItemDetails/";

    public CssSelectors(WebDriver driver) {
        this.driver = driver;
    }

    public CssSelectors() {}

    public WebDriver setupDriver() { // Do not change the method signature
        // Create driver, store it in static variable driver, navigate to baseUrl and return it
        driver = DriverSetup.getDriver();
        driver.get(baseUrl);
        return driver;
    }

    public void setItemId(String itemid) {
        // Locate the WebElement corresponding to 'Item Id' using Id Css Selector.
        driver.findElement(By.cssSelector("input#itemid")).sendKeys(itemid);
    }

    public void setItemName(String itemname) {
        // Locate the WebElement corresponding to 'Item Name' using Class Css Selector.
        driver.findElement(By.cssSelector(".input-product")).sendKeys(itemname);
    }

    public void setItemDescription(String description) {
        // Locate the WebElement corresponding to 'Item Description' using Attribute Css Selector.
        driver.findElement(By.cssSelector("textarea[name='itemdesc']")).sendKeys(description);
    }

    public void setItemCategory(String category) {
        // Locate the WebElement corresponding to 'Item Category' using Tag, Class and Attribute Css selector.
        WebElement drop = driver.findElement(By.cssSelector("select[class='menu-product'][name='itemtype']"));
        Select s = new Select(drop);
        s.selectByVisibleText(category);
    }

    public void setItemQuantity(String quantity) {
        // Locate the WebElement corresponding to 'Item Quantity' using specific locators.
        driver.findElement(By.cssSelector("#itemqty")).sendKeys(quantity);
    }

    public void setPrice(String price) {
        // Locate the WebElement corresponding to 'Price' using specific locators.
        driver.findElement(By.cssSelector("#itemprice")).sendKeys(price);
    }

    public void setSubmit() {
        // Locate the WebElement corresponding to 'confirm' using pseudo-class Css Selector.
        driver.findElement(By.cssSelector("button[type='submit']:last-child")).click();
    }

    public WebElement getMessage() {
        // Retrieve the text from the WebElement

        WebElement dddd = driver.findElement(By.cssSelector("#itemid"));
        WebElement we = driver.findElement(By.cssSelector(".collection-item"));
        String s = we.getText();
        System.out.println(s+" "+ dddd.getText());
        return we;
    }

    public static void main(String[] args) {
        CssSelectors reg = new CssSelectors();
        reg.setupDriver();
        reg.setItemId("32");
        reg.setItemName("Beetroot");
        reg.setItemDescription("Good For Health");
        reg.setItemCategory("Vegetables");
        reg.setItemQuantity("3");
        reg.setPrice("45");
        reg.setSubmit();
        reg.getMessage();
    }
}
