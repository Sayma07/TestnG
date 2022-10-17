package util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserFactory {
	 static WebDriver driver;
static String browser;
static String url;
		



	 public static void readConfig() {
		 
		 
//InputStream    //BufferedReader		//Scanner    //file nput 
		 try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			Properties prop = new Properties();
			prop.load(input);
			browser = prop.getProperty("browser");
			url = prop.getProperty("url");

		} catch (Exception e) {
			e.printStackTrace();
		}
 }
	
	 

		public static  WebDriver init() {

		/*System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();*/
			
	
	/*System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
	
		driver=new FirefoxDriver();*/
	
			readConfig();
	
			if(browser.equalsIgnoreCase("chrome")) {
				
				System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
				driver = new ChromeDriver();
			
	}else if(browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
	
		driver=new FirefoxDriver();
	}
			
			
			
			driver.get("http://techfios.com/test/101/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//return driver;
			return driver;
		}

		public static void tearDown() {
			driver.close();
			driver.quit();
		}

	}


