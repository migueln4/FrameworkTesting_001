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
    private DesiredCapabilities capabilities;
    private WebDriverWait wait;

    Browser() {
        options = new ChromeOptions();
        capabilities = DesiredCapabilities.chrome();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver,60);
    }

    Browser(String[] arguments) {
        this();
        for(String argument : arguments) {
            options.addArguments(argument);
        }
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
    }

    Browser(String argument) {
        this();
        options.addArguments(argument);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
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

    public static void takeScreenshot(String path) {
        File captura = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(captura,new File("C:/TestsQA/Proyecto/Capturas/"+path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitToBePresent(By by) {
        System.out.println("=======ME HAS PEDIDO QUE ESPERE================");
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


}