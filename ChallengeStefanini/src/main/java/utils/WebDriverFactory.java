package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class WebDriverFactory {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static PropertiesReader propertiesReader;

    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                propertiesReader = new PropertiesReader();
                switch (propertiesReader.getPropValue("webdriver").toUpperCase()) {
                    case "FIREFOX":
                        if (driver == null) {
                            System.setProperty("webdriver.gecko.driver", Constants.PATH_FIREFOXDRIVER);
                            driver = new FirefoxDriver();
                            driver.manage().window().maximize();
                        }
                        break;
                    case "INTERNET_EXPLORER":
                        System.out.println(System.getProperty("os.arch"));
                        if (System.getProperty("os.arch").contains("64")) {
                            System.setProperty("webdriver.ie.driver", Constants.PATH_IEDRIVER64);
                            DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                            caps.setCapability("ignoreZoomSetting", true);
                            driver = new InternetExplorerDriver(caps);
                            driver.manage().window().maximize();
                        } else {
                            System.setProperty("webdriver.ie.driver", Constants.PATH_IEDRIVER32);
                            DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                            caps.setCapability("ignoreZoomSetting", true);
                            driver = new InternetExplorerDriver(caps);
                            driver.manage().window().maximize();
                        }
                        break;
                    default:
                        System.setProperty("webdriver.chrome.driver", Constants.PATH_CHROMEDRIVER);
                        driver = new ChromeDriver();
                        driver.manage().window().maximize();
                        break;
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static WebDriverWait getWaitDriver() {
        if (wait == null) {
            wait = new WebDriverWait(getDriver(),Constants.timeOut);
        }
        return wait;
    }

    public static void killDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}