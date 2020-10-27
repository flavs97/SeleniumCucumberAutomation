package model;

import org.openqa.selenium.WebDriver;

public class DriverContext {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
            DriverContext.setDriver(driver);
        }
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverContext.driver = driver;
    }
}
