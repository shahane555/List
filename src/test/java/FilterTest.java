import listAmTests.DriverSetup;
import org.example.list.Am.Category;
import org.example.list.Am.FilteredItem;
import org.example.list.Am.FilterResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FilterTest extends DriverSetup {
    FilterResultsPage filterResultsPage;

    @Test
    public void filterTest() {
        homePage.selectLanguage("English");
        Category category = new Category(driver, action, wait);
        category.chooseCategory("Electronics", "Computers", "Notebooks");
        category.chooseFromDropDown("Location", "Kentron");
        category.setPrice("200000", "500000");
        filterResultsPage = new FilterResultsPage(driver, "/category/116?n=8&bid=0&price1=200000&price2=500000&crc=&_a24=0");
        filterResultsPage.open();
        List<FilteredItem> filteredItems = filterResultsPage.getAllSearchedItems();
        for (FilteredItem searchItem : filteredItems) {
            Assert.assertEquals(searchItem.getLocation(), "Kentron", "Actual location doesn't match expected location");
            Assert.assertTrue(searchItem.IsItemPriceLessThan(500000), "Actual price is more than expected price");
            Assert.assertTrue(searchItem.isItemPriceMoreThan(200000), "Actual price is less than expected price");
        }
    }
}
