package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class CaseKing implements Shop{

    // TODO eine Methode für einzelne Produkte und eine für Listen von Produkten implementieren
    // TODO Tests schreiben

    private String url;
    private int uvp;
    private String productname;
    protected CaseKing(String url, int uvp, String productName){
        this.url = url;
        this.uvp = uvp;
        this.productname = productName;
    }

    public void start(){

        String result = this.productname + "\n";

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--user-data-dir=C:\\Users\\B\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
        //options.addArguments("--headless");

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

        List<WebElement> listOfProducts = getListOfProducts(driver);
        for(WebElement element : listOfProducts){

            double price = getPrice(element);
            String availability = getAvailability(element);
            boolean belowUvp = price <= this.uvp;
            result = result.concat("\t" + price + "\t" + belowUvp + "\t" + availability + "\n");

            if(belowUvp && availability.equals("lagernd")){
                //SoundPlayer.alarm();
            }
        }

        System.out.println(result);

        driver.quit();
    }

    public void handleCookie(WebDriver driver){



        WebElement cookieWindow = driver.findElement(By.id("cookie_consent_modal"));

        if(cookieWindow.isDisplayed()) {
            List<WebElement> cookieButtons = cookieWindow.findElements(By.tagName("button"));

            for(WebElement button : cookieButtons){
                if(button.getText().equals("Ich mag Cookies")){
                    button.click();
                }
            }
        }
    }

    public void addToBasket(WebDriver driver){

        WebElement basketButton = driver.findElement(By.id("basketButton"));

        basketButton.click();
    }

    @Override
    public double getPrice(WebElement element){

        String price = element.findElement(By.className("price")).getText();
        price = price.substring(0, price.length() - 2);
        price = price.replace(".", "");
        price = price.replace(",", ".");

        return Double.parseDouble(price);
    }

    @Override
    public String getAvailability(WebElement element){
        return element.findElement(By.className("delivery_container")).findElement(By.tagName("p")).getText();
    }

    @Override
    public WebElement getProduct(WebDriver driver) {
        return null;
    }

    public List<WebElement> getListOfProducts(WebDriver driver){
        List<WebElement> list = driver.findElement(By.id("listing-1col")).findElements(By.className("artbox"));
        return list;
    }

}
