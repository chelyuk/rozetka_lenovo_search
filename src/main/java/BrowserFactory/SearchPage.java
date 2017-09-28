package BrowserFactory;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by sergey on 17.07.2017.
 */
public class SearchPage extends Page {

    private static final String INPUT_NAME = "text";


    public SearchPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = INPUT_NAME)
    private WebElement input;

    public SearchPage open() {
        driver.get("https://rozetka.com.ua");
        return new SearchPage();
    }

    public ResultPage setSearchValue(String name) {
        input.clear();
        input.sendKeys(name);
        input.submit();
        return new ResultPage();
    }
}
