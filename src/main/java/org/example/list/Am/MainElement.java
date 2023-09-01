package org.example.list.Am;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

public class MainElement implements WrapsElement {
    public MainElement(WebElement e) {
        e = element;
    }

    protected WebElement element;

    @Override
    public WebElement getWrappedElement() {
        return null;
    }

}
