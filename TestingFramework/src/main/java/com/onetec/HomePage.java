package main.java.com.onetec;

public class HomePage {

    static String url = "http://www.pluralsight.com";
    static String title = "Unlimited Online Developer, IT and Cyber Security Training | Pluralsight";
    static Browser browser = new Browser();

    public void goTo() {
        browser.goTo(url);
    }

    public boolean isAt() {
        return browser.title().equals(title);
    }

}
