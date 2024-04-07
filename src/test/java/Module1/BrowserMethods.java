package Module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Remember: You need a class to execute a code
public class BrowserMethods {
    // To kick out - start a program with java code you will need a main method
    // JVM - it looks for specific combination of keywords for main() method (public, static, void)
    public static void main(String[] args) throws InterruptedException {


        // First we need to create a driver instance that will force our (corresponding) browser to do actions
        //WebDriver driver = new ChromeDriver(); // Upcasting - Polymorphism
        WebDriver driver = new ChromeDriver();
        //usually when we start the session of driver we want to maximize it
        driver.manage().window().maximize();
        // Once you create a driver object you can access the methods and variables from it
        // To navigate to a web application we use 2 methods
        // driver.get() - requires url as String argument

//       We have to similar 2 similar ways to navigate to a web application
//
//        option 1: using driver.get()
//        option 2: using navigate().to():
        driver.get("http://dev-hrm.yoll.io/");
        Thread.sleep(3000);
        driver.navigate().refresh();
        // Once we navigated to the URL
        // We can start interacting with web application
        String url = "https://www.google.com/";
        //driver.navigate().to(url);
        driver.get(url);
        Thread.sleep(3000);
        driver.get("https://www.bestbuy.com/");
        driver.manage().window().minimize();
        // The getTitle() method will return you the page title as a string
        // String title = driver.getTitle();
        Thread.sleep(3000);
//        driver.navigate().refresh();
//        Thread.sleep(3000);
        for (int i = 0; i < 2; i++) {
            driver.navigate().back();
            Thread.sleep(3000);
        }
        // driver.navigate().back();
        // Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);

//        or directly put driver.getTitle(); in the system.outÍ
        // We will simply print the title in the console
        // System.out.println(driver.getTitle());
        // System.out.println(title);
        //driver.close(); closes only the current window on which Selenium is running automated tests.
        // The WebDriver session, however, remains active.

        //On the other hand, the driver. quit() method closes
        // all browser windows and ends the WebDriver session
        driver.quit();
        //driver.close();
//        cmd +alt(option)+L for beautifying in MAC
//        ctrl + ALT + L for windows
    }
}
