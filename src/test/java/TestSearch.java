import BrowserFactory.SearchPage;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

/**
 * Created by sergey on 17.07.2017.
 */
public class TestSearch extends BaseTest {

    private static final String SEARCH_STRING = "Lenovo IdeaPad 110-15ACL";
    private SearchPage searchPage;

    @BeforeMethod
    public void beforeMethod() {
        searchPage = new SearchPage();
        searchPage.open();
    }

    @Test
    public void testFirstLink() {
        resultPage = searchPage.setSearchValue(SEARCH_STRING);
        String expected = resultPage.searchResult().get(0).getText();
        assertEquals(expected, "Lenovo IdeaPad 110-15ACL (80TJ00F4RA) Black Суперцена!!!");
    }

    @Test
    public void testItem() {
        resultPage = searchPage.setSearchValue(SEARCH_STRING);
        String expected = resultPage.searchItem().getText().trim();
        assertEquals(expected, "Lenovo IdeaPad 110-15ACL (80TJ00F4RA) Black Суперцена!!!");
    }

    @AfterMethod
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }
}
