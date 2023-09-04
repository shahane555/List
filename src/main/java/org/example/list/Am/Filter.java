package org.example.list.Am;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Filter extends BasePage{
    public Filter(WebDriver driver, Actions action, WebDriverWait wait) {
        super(driver, action, wait);
    }

    String radioButtonLocatorText = "//div[contains(text(), '%s')]/..//div[@class='me']/div";
    String optionLocatorText = "//div[contains(text(), '%s')]";

    public void chooseFromDropDown(String radioButton, String option) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By radioButtonLocator = By.xpath(String.format(radioButtonLocatorText, radioButton));
        By optionLocator = By.xpath(String.format(optionLocatorText, option));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(radioButtonLocator))).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(optionLocator))).click();
    }

    String clickAfterSettingThePriceLocatorText = "//img[@id='gobtn']";

    public void setPrice(String from, String to) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By fromPriceLocator = By.xpath("//div[contains(text(), 'Price')]/..//input[@placeholder='from']");
        By toPriceLocator = By.xpath("//div[contains(text(), 'Price')]/..//input[@placeholder='to']");
        By clickAfterSettingThePriceLocator = By.xpath(clickAfterSettingThePriceLocatorText);
        wait.until(ExpectedConditions.elementToBeClickable(fromPriceLocator)).sendKeys(from);
        wait.until(ExpectedConditions.elementToBeClickable(toPriceLocator)).sendKeys(to);
        wait.until(ExpectedConditions.elementToBeClickable(clickAfterSettingThePriceLocator)).click();
    }
}
