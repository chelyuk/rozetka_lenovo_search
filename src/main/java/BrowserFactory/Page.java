package BrowserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by sergey on 17.07.2017.
 */
public class Page {
    protected WebDriver driver = BrowserFactory.getInstance().getDriver();
}
