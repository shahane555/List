package org.example.list.Am;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

public class BaseElement implements WrapsElement {
    public BaseElement(WebElement element) {
        this.element = element;
    }

    protected WebElement element;

    @Override
    public WebElement getWrappedElement() {
        return null;
    }

}
