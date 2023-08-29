import listAmTests.DriverSetup;
import org.example.list.Am.SearchedItem;
import org.example.list.Am.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FilterTest extends DriverSetup {
    SearchResultsPage searchResultsPage;

    @Test
    public void filterTest() {
        homePage.selectLanguage("English");
        homePage.chooseCategory("Electronics", "Computers", "Notebooks");
        homePage.chooseFromDropDown("Location", "Kentron");
        homePage.setPrice("200000", "500000");
        searchResultsPage = new SearchResultsPage(driver, "/category/116?n=8&bid=0&price1=200000&price2=500000&crc=&_a24=0");
        searchResultsPage.open();
        List<SearchedItem> searchedItems = searchResultsPage.getAllSearchedItems();
        for (SearchedItem searchItem : searchedItems) {
            Assert.assertEquals(searchItem.getLocation(), "Kentron", "Actual location doesn't match expected location");
            Assert.assertTrue(searchItem.IsItemPriceLessThan(500000), "Actual price is more than expected price");
            Assert.assertTrue(searchItem.isItemPriceMoreThan(200000), "Actual price is less than expected price");
        }
    }
}
