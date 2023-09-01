package org.example.list.Am;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Category extends Filter{
    public Category(WebDriver driver, Actions action, WebDriverWait wait) {
        super(driver, action, wait);
    }

    String categoryLocatorText = "//div[@id='menu']//div[@data-c='4']/a[contains(text(), '%s')]";
    String subCategoryLocatorText = "//div[@class='pane']//b[contains(text(), '%s')]//..//a[contains(text(), '%s')]";

    public void chooseCategory(String category, String subCategory, String item) {
        By categoryLocator = By.xpath(String.format(categoryLocatorText, category));
        By subCategoryLocator = By.xpath(String.format(subCategoryLocatorText, subCategory, item));
        action.moveToElement(driver.findElement(categoryLocator)).build().perform();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until((ExpectedConditions.elementToBeClickable(subCategoryLocator)));
        driver.findElement(subCategoryLocator).click();
    }
}
