package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {



        //https://www.selenium.dev/documentation/webdriver/getting_started/first_script/

        CaseKing rtx4090 = new CaseKing("https://www.caseking.de/pc-komponenten/grafikkarten/nvidia?ckFilters=10691-16893&ckTab=0&sSort=103", 1799, "4090");
        rtx4090.start();

        CaseKing rx7900xtx = new CaseKing("https://www.caseking.de/pc-komponenten/grafikkarten/amd/radeon-rx-7900-xtx", 1082, "7900 XTX");
        rx7900xtx.start();

/*        AlphaCool eisblock = new AlphaCool("https://shop.alphacool.com/shop/gpu-wasserkuehlung/amd/11953-alphacool-eisblock-aurora-acryl-gpx-a-radeon-rx-6800-xt/6900xt-red-devil-mit-backplate?c=1465", 80, "Eisblock");
        eisblock.start();*/





    }






}