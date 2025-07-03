import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private static final Logger logger = LogManager.getLogger(LoginPage.class);

	private WebDriver driver;
	public static final String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/SmartUniversity/login.html";

	public LoginPage() {
	}

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	

	public WebDriver createDriver() {
		try {
			driver = DriverSetup.getDriver(); 
			driver.get(baseUrl);
			logger.info("Driver initialised and navigated to {}", baseUrl);
		} catch (Exception e) {
			logger.error("Driver creation / navigation failed", e);
		}
		return driver;
	}


	public void setUsername() {
		try {
			driver.findElement(By.id("username")).sendKeys("admin");
			logger.info("Username entered");
		} catch (Exception e) {
			logger.error("Unable to locate or set Username field", e);
		}
	}

	public void setPassword() {
		try {
			driver.findElement(By.id("password")).sendKeys("admin#123");
			logger.info("Password entered");
		} catch (Exception e) {
			logger.error("Unable to locate or set Password field", e);
		}
	}

	public void solveCaptcha() {
		try {
			
			String captchaResult = driver.findElement(By.id("result"))
					.getText().trim();
			driver.findElement(By.id("captcha")).sendKeys(captchaResult);
			logger.info("Captcha solved with value {}", captchaResult);
		} catch (Exception e) {
			logger.error("Unable to solve captcha", e);
		}
	}

	public void submitLogin() {
		try {
			driver.findElement(By.id("submit")).click();
			logger.info("Submit button clicked");
		} catch (Exception e) {
			logger.error("Unable to click Submit button", e);
		}
	}

	public String alertHandle() {
		try {
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			logger.info("Alert appeared with text: {}", text);
			alert.accept();
			return text;
		} catch (NoAlertPresentException e) {
			logger.error("No alert present", e);
			return null;
		}
	}


	public static void main(String[] args) throws Exception {
		
		Configurator.initialize(null, "src/main/resources/log4j2.xml");

		LoginPage lp = new LoginPage();
		lp.createDriver();
		lp.setUsername();
		lp.setPassword();
		lp.solveCaptcha();
		lp.submitLogin();
		lp.alertHandle();
	}
}
