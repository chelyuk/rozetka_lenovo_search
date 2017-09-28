package BrowserFactory;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Created by sergey on 17.07.2017.
 */
public class BrowserFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private final static BrowserFactory INSTANCE = new BrowserFactory();
    public static BrowserFactory getInstance() { return INSTANCE; }

    public WebDriver initBrowser(String nameFromConfig) {
        String browserName = System.getProperty("browserName");
        if (browserName == null){
            browserName = nameFromConfig;
        }
        switch (browserName.toLowerCase()) {
            case "chrome":
                // Running in all modes
                ChromeDriverManager.getInstance().setup();
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                // Running in all modes
                FirefoxDriverManager.getInstance().setup();
                FirefoxProfile firefoxProfile = new FirefoxProfile();
                firefoxProfile.setAcceptUntrustedCertificates(true);
                firefoxProfile.setPreference("security.insecure_field_warning.contextual.enabled", false);
                driver.set(new FirefoxDriver(firefoxProfile));
                break;

            case "msedge":
                // Not running
                EdgeDriverManager.getInstance().setup();
                driver.set(new EdgeDriver());
                break;

            case "ie":
                // Running only with browser configuration
                InternetExplorerDriverManager.getInstance().arch32().setup();
                driver.set(new InternetExplorerDriver());
                break;

            case "safari":
                driver.set(new SafariDriver());
                break;

            default:
                throw new UnsupportedOperationException(String.format("Browser %1$s is not supported!", browserName));
        }

        return driver.get();
    }

    public WebDriver getDriver() { return driver.get(); }

}
