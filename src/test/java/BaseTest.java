import BrowserFactory.BrowserFactory;
import BrowserFactory.ResultPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by sergey on 17.07.2017.
 */
public class BaseTest {

    protected WebDriver driver;
    protected ResultPage resultPage;

    @BeforeSuite
    public void beforeSuite() {
        driver = BrowserFactory.getInstance().initBrowser("firefox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @AfterSuite
    public void afterSuite() { driver.quit(); }
}
