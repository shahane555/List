package org.example.list.Am;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FilterResultsPage extends BasePage {

    private final By item = By.xpath("//div[@class='gl']//a[@class='h']");

    public FilterResultsPage(WebDriver driver, String endPoint) {
        super(driver, endPoint);
    }

    public List<FilteredItem> getAllSearchedItems() {
        List<FilteredItem> allFilteredItems = new ArrayList<>();
        List<WebElement> elements = driver.findElements(item);
        for(WebElement e : elements) {
            allFilteredItems.add(new FilteredItem(e, driver));
        }
        return allFilteredItems;
    }
}
