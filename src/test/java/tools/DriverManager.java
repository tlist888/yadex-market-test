package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

/**
 * Driver manager (Singleton)
 *
 */
public class DriverManager {
    private static DriverManager instance;
    private WebDriver driver;
    private static OperaOptions options;

    private DriverManager() {}

    public static WebDriver getDriver() {
        if (instance == null) {
            instance = new DriverManager();
            options = new OperaOptions();
            options.setBinary("C:\\Program Files\\Opera\\launcher.exe");
            System.setProperty("webdriver.opera.driver", "C:\\Users\\tanya\\Documents\\Selenium\\operadriver.exe");

            instance.driver = new OperaDriver(options);
        }
        return instance.driver;
    }
}