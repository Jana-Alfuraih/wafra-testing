package org.example;


import com.beust.ah.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class page {

    private static void deleteText(WebElement... fields) {
        for (WebElement field : fields) {
            field.sendKeys(Keys.COMMAND + "a");
            field.sendKeys(Keys.DELETE);
        }
    }

    private static void sleepTimer(int myTime) throws InterruptedException {
        TimeUnit.SECONDS.sleep(myTime);
    }


    WebDriver driver = new ChromeDriver();


    @BeforeClass
    public void setup() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("Opening Url");
        driver.get("http://bugsoup.usewafra.com/");
        driver.manage().window().maximize();

    }
}
