package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class AlphaCool extends Thread implements Shop {

    private String url;
    private int uvp;
    private String productname;

    protected AlphaCool(String url, int uvp, String productName){
        this.url = url;
        this.uvp = uvp;
        this.productname = productName;
    }

    public void run(){
        String result = this.productname + "\n";

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        System.out.println(getPrice(getProduct(driver)));
    }


    @Override
    public double getPrice(WebElement element) {
        String price = element.findElement(By.className("price--content")).getText();
        price = price.substring(0, price.length() - 4);
        price = price.replace(",", ".");

        return Double.parseDouble(price);
    }

    @Override
    public String getAvailability(WebElement element) {
        return null;
    }

    @Override
    public WebElement getProduct(WebDriver driver) {

        return driver.findElement(By.className("product--details"));
    }
}
