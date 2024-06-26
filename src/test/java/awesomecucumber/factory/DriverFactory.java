
package awesomecucumber.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import static awesomecucumber.constants.FrameworkConstants.BROWSER_CHROME;
import static awesomecucumber.constants.FrameworkConstants.BROWSER_FIREFOX;
import static awesomecucumber.constants.FrameworkConstants.BROWSER_SAFARI;
import static awesomecucumber.constants.FrameworkConstants.BROWSER_EDGE;
import static awesomecucumber.constants.FrameworkConstants.BROWSER_OPERA;
import static awesomecucumber.constants.FrameworkConstants.BROWSER_HEADLESS;

public class DriverFactory {

	public static WebDriver initializeDriver(String browser) {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriver driver;
//        switch (browser) {
//            case "chrome" -> {
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//            }
//            case "firefox" -> {
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//            }
//            default -> throw new IllegalStateException("INVALID BROWSER: " + browser);
//        }

		switch (browser) {

		case BROWSER_CHROME: {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}

		case BROWSER_HEADLESS: {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			driver = new ChromeDriver(options);
			break;

		}
		case BROWSER_FIREFOX: {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		case BROWSER_SAFARI: {
			driver = new SafariDriver();
			break;
		}
		case BROWSER_EDGE: {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}
//		case BROWSER_OPERA: {
//			WebDriverManager.operadriver().setup();
//			driver = new OperaDriver();
//			break;
//		}
		default:
			throw new IllegalStateException("INVALID BROWSER: " + browser);
		}
		driver.manage().window().maximize();
		return driver;
	}
}
