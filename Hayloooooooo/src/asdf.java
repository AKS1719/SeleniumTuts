import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class asdf {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium-java-4.33.0\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		System.out.println(driver.findElement(By.xpath("//span[text()='26']")));
	}
}
