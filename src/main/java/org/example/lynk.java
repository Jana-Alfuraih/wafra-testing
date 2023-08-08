package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class lynk {

    @BeforeClass

    private static void deleteText(WebElement... fields) {
        for (WebElement field : fields) {
            field.sendKeys(Keys.COMMAND + "a");
            field.sendKeys(Keys.DELETE);
        }
    }
    @Test(priority = 1)
    public static void test1(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://dev-lender.uselynk.com");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement nameInput = driver.findElement(By.name("unique_name"));
        //-----------------------------------------------------------------------------------------------------
        deleteText(passwordInput, emailInput, nameInput);
        nameInput.sendKeys("ali_c");
        emailInput.sendKeys("janaalfuraih@gmail");
        passwordInput.sendKeys("12345678");
        passwordInput.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//p[contains(text(), 'This field should be email')]"));
        deleteText(emailInput);
        emailInput.sendKeys("wrongemail@gmail.com");
        passwordInput.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//p[contains(text(), 'These credentials do not match our records.')]"));
        deleteText(emailInput, nameInput);
        emailInput.sendKeys("janaalfuraih@gmail.com");
        nameInput.sendKeys("wrong-company-name");
        passwordInput.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//p[contains(text(), 'The selected unique name is invalid.')]"));
        deleteText(passwordInput, nameInput);
        passwordInput.sendKeys("green");
        passwordInput.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//p[contains(text(), 'Must be 8 characters or more')]"));
        //------------------------------------------------------------------------------------------------------
        deleteText(passwordInput, emailInput, nameInput);
        List<WebElement> verifyText = driver.findElements(By.xpath("//p[contains(text(), 'This field is required')]"));
        if (verifyText.size() != 3) {
            System.out.println("Failed at obtaining 3 field is required");
        }
        nameInput.sendKeys("lynktest");
        emailInput.sendKeys("ahmad@ahmad.com");
        passwordInput.sendKeys("Aa123456@");
        passwordInput.sendKeys(Keys.ENTER);

//        driver.quit();
    }
    @Test(priority = 2)
    public void test2() throws InterruptedException {
  //      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

}














