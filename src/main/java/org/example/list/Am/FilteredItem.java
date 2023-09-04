package org.example.list.Am;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilteredItem extends BaseElement {

    WebDriver driver;

    public FilteredItem(WebElement e, WebDriver driver) {
        super(e);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static final String PRICE = "//div[@class='p']";
    private static final String LOCATION = "//div[@class='gl']//div[@class='at']";

    @FindBy(xpath = PRICE)
    WebElement price;

    public boolean IsItemPriceLessThan(int endPrice) {

        return Integer.parseInt(price.getText().replaceAll(",| ֏", "")) <= endPrice;
    }

    public boolean isItemPriceMoreThan(int startPrice) {
        return Integer.parseInt(price.getText().replaceAll(",| ֏", "")) >= startPrice;
    }

    @FindBy(xpath = LOCATION)
    WebElement location;

    public String getLocation() {
        String[] s = location.getText().split(",");
        return s[0];
    }
}
