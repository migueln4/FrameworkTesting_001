package main.java.com.onetec;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class Browser {

    static WebDriver driver;
    private ChromeOptions options;
    //private DesiredCapabilities capabilities;
    //static WebDriverWait wait;

    Browser() {
        options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //capabilities = DesiredCapabilities.chrome();
        //options.addArguments("incognito");
        //capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        //driver = new ChromeDriver(capabilities);
        driver = new ChromeDriver(options);
        //wait = new WebDriverWait(driver,30);
    }

    public void goTo(String url) {
        driver.get(url);
    }

    public String title() {
        return driver.getTitle();
    }

    public static void close() {
        driver.close();
    }

    /*
    public static void waitForLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
        System.out.println("==============He terminado de esperar.===========");
    }
    */

    public void takeScreenshot() {
        File captura = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(captura,new File("C:/TestsQA/captura.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    public WebElement waitToBeClickable(WebElement element) {

        System.out.println("=======ME HAS PEDIDO QUE ESPERE================");
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    */


}
