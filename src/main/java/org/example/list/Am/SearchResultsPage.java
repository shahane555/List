package org.example.list.Am;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {

    private final By item = By.xpath("//div[@class='gl']//a[@class='h']");

    public SearchResultsPage(WebDriver driver, String endPoint) {
        super(driver, endPoint);
    }

    public List<SearchedItem> getAllSearchedItems() {
        List<SearchedItem> allSearchedItems = new ArrayList<>();
        List<WebElement> elements = driver.findElements(item);
        for(WebElement e : elements) {
            allSearchedItems.add(new SearchedItem(e, driver));
        }
        return allSearchedItems;
    }
}
