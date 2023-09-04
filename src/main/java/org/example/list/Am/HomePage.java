package org.example.list.Am;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver, Actions action, WebDriverWait wait) {
        super(driver, action, wait);
    }

    String languageLocatorText = "//div[@class='bar']//a/div[text()='%s']";

    public void selectLanguage(String language) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By langLocator = By.xpath(String.format(languageLocatorText, language));
        wait.until(ExpectedConditions.elementToBeClickable(langLocator));
        driver.findElement(langLocator).click();
    }
}
