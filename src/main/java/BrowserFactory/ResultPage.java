package BrowserFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by sergey on 18.07.2017.
 */
public class ResultPage extends Page{

    private static final String LINKS_CSS = ".g-i-tile-i-title>a";
    private static final String ITEM_XPATH = "//a[contains(text(),'Lenovo IdeaPad 110-15ACL (80TJ00F4RA) Black Суперцена!!!')]";

    public ResultPage() {
        PageFactory.initElements(driver, this);
    }

    @FindAll(@FindBy(how = How.CSS, using = LINKS_CSS))
    private List<WebElement> links_list;

    @FindBy(how = How.XPATH, using = ITEM_XPATH)
    private WebElement item;

    public List<WebElement> searchResult() {
        return links_list;
    }

    public WebElement searchItem() {
        return item;
    }

}
