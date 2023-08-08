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



public class assessment {

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
        driver.get("https://sandbox-i23ert-admin.usewafra.com/sign-in");
        driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys("admin@bimventures.com");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//*[@id=\":r3:\"]")).click();
    }

    @Test(priority = 1)
    public void test1() throws InterruptedException {

        driver.findElement(By.cssSelector("a[href='/groups']")).click();
        sleepTimer(2);
        driver.findElement(By.id("create_group")).click();
        sleepTimer(2);
        WebElement inputValue = driver.findElement(By.name("label.ar"));
        inputValue.click();
        inputValue.sendKeys("اسئلة شخصية");
        WebElement Value = driver.findElement(By.name("label.en"));
        Value.click();
        Value.sendKeys("Group testing");
        WebElement Ar = driver.findElement(By.name("description.ar"));
        Ar.click();
        Ar.sendKeys("اختبارات");
        WebElement En = driver.findElement(By.name("description.en"));
        En.click();
        En.sendKeys("Assessment");
        sleepTimer(2);
        //--------------------------------------First File Attached-------------------------------------------------
        WebElement Ph = driver.findElement(By.xpath("(//input[@type='file'])[1]"));
        Ph.sendKeys("/Users/jana/Desktop/wafrah/src/main/resources/3.png");
        System.out.println("First File Attached Successfully");
        sleepTimer(2);
        //--------------------------------------Second File Attached-------------------------------------------------
        WebElement Ph2 = driver.findElement(By.xpath("(//input[@type='file'])[2]"));
        Ph2.sendKeys("/Users/jana/Desktop/wafrah/src/main/resources/3.png");
        System.out.println("Second File Attached Successfully");
        sleepTimer(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        WebElement CreateButton = driver.findElement(By.xpath("//button[@id='CREATE_UPDATE_GROUP']"));
        CreateButton.click();
        String ExactedName = driver.findElement(By.xpath("//h4[contains(text(),'Groups')]")).getText();
        Assert.assertTrue(ExactedName.contains("Group"));
        System.out.println("User Account is created & navigated Successfully to group page");
        sleepTimer(2);
    }


    @Test(priority = 2)

    public void test2() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("settings")).click();
        sleepTimer(2);
        //--------------------------------------Select Elements-------------------------------------------------
        WebElement GroupTitle = driver.findElement(By.xpath("//h4[text()='Groups Settings']"));
        Assert.assertEquals(GroupTitle.getText(), "Groups Settings");
        WebElement GroupTag = driver.findElement(By.xpath("//div[@id='Groups'][@role='button']"));
        Assert.assertTrue(GroupTag.isDisplayed());
        WebElement button = driver.findElement(By.name("main_goal_question"));
        button.click();
        WebElement Q1 = driver.findElement(By.xpath("//li[contains(text(),'10- How much money do you have to pay for your debt every month?')]"));
        Q1.click();
        sleepTimer(2);
        WebElement P = driver.findElement(By.name("goal_answers[0].percentage"));
        P.click();
        P.sendKeys("30");
        WebElement F = driver.findElement(By.name("goal_answers[1].percentage"));
        F.click();
        F.sendKeys("40");
        WebElement A = driver.findElement(By.name("goal_answers[2].percentage"));
        A.click();
        A.sendKeys("50");
        WebElement N = driver.findElement(By.name("goal_answers[3].percentage"));
        N.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        N.sendKeys("60");
        WebElement R = driver.findElement(By.name("goal_answers[4].percentage"));
        R.click();
        R.sendKeys("70");
        System.out.println("Select element Successfully");
        WebElement select = driver.findElement(By.name("main_year_question"));
        select.click();
        WebElement Q2 = driver.findElement(By.xpath("//li[contains(text(),'14- Have you ever experienced a 20% or more decline in the value of your investments in one year?')]"));
        Q2.click();
        sleepTimer(2);
        JavascriptExecutor up = (JavascriptExecutor) driver;
        up.executeScript("window.scrollBy(0,-250)", "");
        WebElement S = driver.findElement(By.id("SAVE_GROUPS_SETTINGS"));
        S.click();
        System.out.println("Create Goal Question Successfully ");
        driver.findElement(By.cssSelector("a[href='/groups']")).click();
    }

    @Test(priority = 3)

    public void test3() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement I = driver.findElement(By.id("expand_hide_group_2"));
        I.click();

        sleepTimer(2);
        WebElement E = driver.findElement(By.id("edit_question_11"));
        E.click();
        sleepTimer(2);
        JavascriptExecutor up = (JavascriptExecutor) driver;
        up.executeScript("window.scrollBy(0,170)", "");
        sleepTimer(2);
        WebElement scoreInput = driver.findElement(By.name("answers[0].score"));
        deleteText(scoreInput);
        //------------ Enter a new number for the score-----------------------------------
        scoreInput.sendKeys("3");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        WebElement U = driver.findElement(By.id("CREATE_UPDATE_QUESTION"));
        U.click();


    }

    @Test(priority = 4)

    public void test4() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        WebElement I = driver.findElement(By.id("Risk Scores"));
        I.click();
        WebElement C = driver.findElement(By.id("create_range"));
        C.click();
        WebElement startInput = driver.findElement(By.name("start"));
        WebElement endInput = driver.findElement(By.name("end"));
        deleteText(startInput, endInput);
        startInput.sendKeys("20");
        endInput.sendKeys("44");
        sleepTimer(2);
        WebElement start = driver.findElement(By.name("is_start_included"));
        start.click();
        WebElement end = driver.findElement(By.name("is_end_included"));
        end.click();
        WebElement create = driver.findElement(By.id("ADD_RANGE"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ADD_RANGE"))).click();
//---------------------------change the number-----------------------------------------------------
        deleteText(startInput);
        startInput.sendKeys("24");
        if (!create.isEnabled()) {
            System.out.println("disabled here");
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ADD_RANGE"))).click();
        sleepTimer(5);
        C.click();
        //----------------------Add another Range----------------------------------------------------------
        WebElement sttInput = driver.findElement(By.name("start"));
        WebElement enInput = driver.findElement(By.name("end"));
        deleteText(sttInput, enInput);
        //------------------Test case take the same number include----------------------------------------
        sttInput.sendKeys("24");
        enInput.sendKeys("50");
        sleepTimer(2);
        WebElement st1 = driver.findElement(By.name("is_start_included"));
        st1.click();
        WebElement end1 = driver.findElement(By.name("is_end_included"));
        end1.click();
        WebElement create1 = driver.findElement(By.id("ADD_RANGE"));
        create1.click();
        Thread.sleep(2);
        driver.findElement(By.xpath("//div[contains(text(), 'The score range is overlapping with another score range')]"));
        System.out.println("The test case it is correct");
        deleteText(sttInput);
        sleepTimer(2);
        sttInput.sendKeys("45");
        WebElement createe1 = driver.findElement(By.id("ADD_RANGE"));
        createe1.click();
        sleepTimer(2);
        //-------------------Add anther range test case unclouded ----------------------------------------------------------
        WebElement Addrange = driver.findElement(By.id("create_range"));
        Addrange.click();
        WebElement stInput = driver.findElement(By.name("start"));
        WebElement eInput = driver.findElement(By.name("end"));
        deleteText(stInput, eInput);
        stInput.sendKeys("50");
        eInput.sendKeys("55");
        sleepTimer(5);
        WebElement en1 = driver.findElement(By.name("is_end_included"));
        en1.click();
        WebElement creat1 = driver.findElement(By.id("ADD_RANGE"));
        creat1.click();
        Thread.sleep(7);
        WebElement Edit = driver.findElement(By.xpath("//tbody/tr[3]/td[4]/button[1]"));
        Edit.click();
        WebElement ednum = driver.findElement(By.name("end"));
        ednum.click();
        Thread.sleep(2);
        deleteText(ednum);
        Thread.sleep(6);
        ednum.sendKeys("54");
        Thread.sleep(5);
        WebElement up1 = driver.findElement(By.id("ADD_RANGE"));
        up1.click();
        sleepTimer(3);
        WebElement delet = driver.findElement(By.xpath("//tbody/tr[3]/td[4]/button[2]"));
        delet.click();
        sleepTimer(3);
        WebElement continu = driver.findElement(By.xpath("//button[@id='DELETE_SCORE_RANGE']"));
        continu.click();
    }

    @Test (priority = 5)

    public void test5() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        WebElement I = driver.findElement(By.id("Risk Scores"));
        I.click();
        sleepTimer(1);
        WebElement createRisk = driver.findElement(By.xpath("//button[@id='create_risk_score']"));
        createRisk.click();
        WebElement En = driver.findElement(By.name("name.en"));
        En.click();
        En.sendKeys("Good");
        WebElement Ar = driver.findElement(By.name("name.ar"));
        Ar.click();
        Ar.sendKeys("جيد");
        WebElement Score = driver.findElement(By.name("score"));
        Score.click();
        Score.sendKeys("10");
        WebElement Ph1 = driver.findElement(By.xpath("(//input[@type='file'])[1]"));
        Ph1.sendKeys("/Users/jana/Desktop/wafrah/src/main/resources/f.jpeg");
        System.out.println("First File Attached Successfully");
        WebElement Ph2 = driver.findElement(By.xpath("(//input[@type='file'])[2]"));
        Ph2.sendKeys("/Users/jana/Desktop/wafrah/src/main/resources/f.jpeg");
        System.out.println("Second File Attached Successfully");
        sleepTimer(1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        WebElement Ph3 = driver.findElement(By.xpath("(//input[@type='file'])[3]"));
        Ph3.sendKeys("/Users/jana/Desktop/wafrah/src/main/resources/f.jpeg");
        System.out.println("Third File Attached Successfully");
        WebElement Ph4 = driver.findElement(By.xpath("(//input[@type='file'])[4]"));
        Ph4.sendKeys("/Users/jana/Desktop/wafrah/src/main/resources/f.jpeg");
        System.out.println("Forth File Attached Successfully");
        WebElement Active = driver.findElement(By.name("is_active"));
        Active.click();
        WebElement creat = driver.findElement(By.id("CREATE_UPDATE_RISK_SCORE"));
        creat.click();
    }

    @Test(priority = 6)

    public void test6() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        WebElement I = driver.findElement(By.id("Risk Scores"));
        I.click();
        WebElement incl = driver.findElement(By.id(":ra:"));
        incl.click();
        sleepTimer(1);
        WebElement good = driver.findElement(By.id(":ra:-option-0"));
        good.click();
        WebElement Exu = driver.findElement(By.id(":re:"));
        Exu.click();
        sleepTimer(1);
        WebElement Ex = driver.findElement(By.id(":re:-option-1"));
        Ex.click();
        WebElement No = driver.findElement(By.id(":rc:"));
        No.click();
        sleepTimer(1);
        WebElement E = driver.findElement(By.id(":rc:-option-1"));
        E.click();
        sleepTimer(1);
        WebElement K =driver.findElement(By.id(":rg:"));
        K.click();
        WebElement KE = driver.findElement(By.id(":rg:-option-0"));
        KE.click();
        WebElement clear = driver.findElement(By.cssSelector("#root > div > div.MuiBox-root.css-fwi0lb > main > div > div.space-y-4.MuiBox-root.css-0 > div > div > div > table > tbody > tr.MuiTableRow-root.Mui-selected.MuiTableRow-hover.css-uim1rd > td:nth-child(3) > div > div > div > div > button.MuiButtonBase-root.MuiIconButton-root.MuiIconButton-sizeMedium.MuiAutocomplete-clearIndicator.css-mc4196"));
        clear.click();
        WebElement save = driver.findElement(By.id("save_risk_score"));
        save.click();
        sleepTimer(1);
        WebElement Delet = driver.findElement(By.xpath("//tbody/tr[1]/td[4]/button[2]//*[name()='svg']"));
        Delet.click();
        WebElement Cont = driver.findElement(By.id("DELETE_SCORE_RANGE"));
        Cont.click();
        WebElement save1 = driver.findElement(By.id("save_risk_score"));
        save1.click();

    }
    //------------------------------------------------------Industries-------------------------------------------------------------------------------------------------------------------------
    @Test(priority = 7)

    public void test7() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        WebElement in = driver.findElement(By.id("Industries"));
        in.click();
        WebElement indus = driver.findElement(By.id("create_industry"));
        indus.click();
        sleepTimer(2);
        WebElement En = driver.findElement(By.name("name.en"));
        En.click();
        En.sendKeys("US market");
        WebElement Ar = driver.findElement(By.name("name.ar"));
        Ar.click();
        Ar.sendKeys("السوق الأمريكي");
        WebElement Act = driver.findElement(By.name("is_active"));
        Act.click();
        WebElement sub = driver.findElement(By.id("CREATE_UPDATE_INDUSTRY"));
        sub.click();
        sleepTimer(2);
        WebElement show = driver.findElement(By.xpath("//button[@id='show_industry_8']//*[name()='svg']"));
        show.click();
        WebElement close = driver.findElement(By.cssSelector("#\\:rf\\:"));
        close.click();
        sleepTimer(1);
        WebElement edit = driver.findElement(By.id("edit_industry_8"));
        edit.click();
        JavascriptExecutor up = (JavascriptExecutor) driver;
        up.executeScript("window.scrollBy(0,170)", "");
        sleepTimer(2);
        WebElement scoreInput = driver.findElement(By.name("name.ar"));
        deleteText(scoreInput);
        //------------ Enter a new name -----------------------------------
        scoreInput.sendKeys("السوق المصري");
        WebElement update = driver.findElement(By.id("CREATE_UPDATE_INDUSTRY"));
        update.click();

}
    @Test(priority = 8)

    public void test8() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        WebElement asset = driver.findElement(By.xpath("//span[normalize-space()='Asset Providers']"));
        asset.click();
        WebElement creat = driver.findElement(By.id("create_asset_provider"));
        creat.click();
        WebElement en = driver.findElement(By.name("name.en"));
        en.click();
        sleepTimer(2);
        en.sendKeys("جيد");
        WebElement ar = driver.findElement(By.name("name.ar"));
        ar.click();
        ar.sendKeys("جيد");
        sleepTimer(2);
        WebElement cr = driver.findElement(By.id("CREATE_UPDATE_ASSETS_PROVIDER"));
        cr.click();
        WebElement review = driver.findElement(By.id("show_asset_2"));
        review.click();
        WebElement close = driver.findElement(By.id(":rf:"));
        close.click();



    }
    //-------------------------------Asset classes----------------------------------------------------------------------
    @Test(priority = 9)

    public void test9() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        WebElement Asset = driver.findElement(By.id("Asset Classes"));
        Asset.click();
        WebElement creat = driver.findElement(By.id("create_asset_class"));
        creat.click();
        sleepTimer(2);
        WebElement En = driver.findElement(By.name("name.en"));
        En.click();
        En.sendKeys("US Market ");
        WebElement Ar = driver.findElement(By.name("name.ar"));
        Ar.click();
        Ar.sendKeys("السوق الأمريكي");
        WebElement index = driver.findElement(By.name("index"));
        index.click();
        index.sendKeys("US");
        WebElement DE = driver.findElement(By.name("description.en"));
        DE.click();
        sleepTimer(2);
        DE.sendKeys("NNN");
        WebElement DA = driver.findElement(By.name("description.ar"));
        DA.click();
        DA.sendKeys("استثمارات غير سائلة تهدف الى تحقيق دخل مستقر على المدى الطويل");
        WebElement Act = driver.findElement(By.name("is_active"));
        Act.click();
        WebElement Cr = driver.findElement(By.id("CREATE_UPDATE_ASSET_CLASS"));
        Cr.click();
    }
//-------------------------------------------US Market (Active)---------------------------------------------------------
    @Test(priority = 10)

    public void test10() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);


        WebElement Asset = driver.findElement(By.id("Asset Classes"));
        Asset.click();
        WebElement show = driver.findElement(By.id("expand_hide_asset_class_6"));
        show.click();
        WebElement new1 = driver.findElement(By.id("create_asset_6"));
        new1.click();
        WebElement En = driver.findElement(By.name("name.en"));
        En.click();
        En.sendKeys("US Market ");
        WebElement Ar = driver.findElement(By.name("name.ar"));
        Ar.click();
        Ar.sendKeys("السوق الأمريكي");
        WebElement Tic = driver.findElement(By.name("tickers"));
        Tic.click();
        Tic.sendKeys("bim");
        WebElement DE = driver.findElement(By.name("description.en"));
        DE.click();
        DE.sendKeys("NNMM");
        WebElement DA = driver.findElement(By.name("description.ar"));
        DA.click();
        DA.sendKeys("السوق الامريكي");
        sleepTimer(2);
        JavascriptExecutor up = (JavascriptExecutor) driver;
        up.executeScript("window.scrollBy(0,-250)", "");
        WebElement S = driver.findElement(By.name("asset_provider"));
        S.click();
        WebElement list = driver.findElement(By.id(":ri:-option-2"));
        list.click();
        JavascriptExecutor down = (JavascriptExecutor) driver;
       down.executeScript("window.scrollBy(0,250)", "");
       WebElement idestory = driver.findElement(By.name("industry"));
       idestory.click();
       WebElement option = driver.findElement(By.id(":rk:-option-1"));
       option.click();
       WebElement act = driver.findElement(By.name("is_active"));
       act.click();
       WebElement creat = driver.findElement(By.id("CREATE_UPDATE_ASSET"));
       creat.click();


    }}