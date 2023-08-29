package org.example.list.Am;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    protected static final String URL= "https://www.list.am/";

    private String endPoint;

    protected WebDriver driver;

    public BasePage(WebDriver driver, String endpoint) {
        this.driver = driver;
        this.endPoint = endpoint;
        PageFactory.initElements(driver, this);
    }

    protected Actions action;

    protected WebDriverWait wait;

    public void open() {
        driver.get(URL);
    }


    public BasePage(WebDriver driver, Actions action, WebDriverWait wait) {
        this.driver = driver;
        this.action = action;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
}


