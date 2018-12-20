package main.java.com.onetec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PathPages {

    static String url = "https://www.pluralsight.com/product/paths";
    static String title = "Java | Pluralsight";
    static Browser browser = new Browser();

    public void goTo() {
        browser.goTo(url);
    }

    public void goToJavaPath() {

        WebElement enlace = browser.driver.findElement(By.xpath("//*[@id=\"pathContent\"]/div[96]/a/div[contains(.,'Java')]"));

        browser.driver.findElement(By.linkText("Accept cookies and close this message")).click();


        WebDriverWait wait = new WebDriverWait(browser.driver, 60);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div.cookie_notification.options[style='display: none;']")));

        enlace.click();

    }

    public boolean isAt() {
        return browser.title().equals(title);
    }



}
