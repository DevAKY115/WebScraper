package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface Shop {



    double getPrice(WebElement element);

    String getAvailability(WebElement element);

    WebElement getProduct(WebDriver driver);
}
