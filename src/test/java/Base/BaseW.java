package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import utility.Timeout;

public class BaseW {
public static WebDriver driver;
public static Logger logger;
	
	public static Properties prop=new Properties();
	
	public BaseW() {
		try {
			FileInputStream file = new FileInputStream("C:\\Users\\vikram\\eclipse-workspace\\Walmart\\src\\test\\java\\Environment\\config.properties");
			prop.load(file);
		}
	catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException a) {
			a.printStackTrace();
		}
	}
	public static void initiate() {
		
		String browsername= prop.getProperty("browser");
		if(driver==null) {
		if (browsername.equals("Firefox")) {
			System.setProperty("webdriver.firefox.driver","geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if (browsername.equals("Chrome")) {
			System.getProperty("webdriver.chrome.driver", "Chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (browsername.equals("Edge")) {
			System.getProperty("webdriver.msedgedriver.driver", "msedgedriver.exe");
			driver=new ChromeDriver();
		}
		}
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Timeout.timepage));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Timeout.implicit));
		driver.get(prop.getProperty("url"));
		
		
	}
	
	
	public void scrolldown() {
		JavascriptExecutor dn= (JavascriptExecutor) driver;
		dn.executeScript("window.scrollTO(0, document.body.scrollHeight)");
		
	}
	public void scrollup() {
		JavascriptExecutor up= (JavascriptExecutor) driver;
		up.executeScript("window.scrollBy(document.body.scrollHeight, 0)");
	}
	public static void down() {
		for (int i = 0; i < 8; i++) {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ARROW_DOWN).perform();
		System.out.println("Scrolled down " + i + " time");
		}
	}
	public void tsleep() throws InterruptedException {
		Thread.sleep(2000);
		
	}
	
	public void browserclose() {
		driver.quit();
	}
}
