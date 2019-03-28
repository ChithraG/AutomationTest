package qaTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

public class TestProject {
	Properties prop = new Properties();
	public InputStream fis = getClass().getResourceAsStream("datadriven.properties");
	public static WebDriver driver;
	public TestProject()
	{
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = prop.getProperty("url");

		if(prop.getProperty("browser").equals("chrome"))
		{	
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeWebDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
		}
	}
}
