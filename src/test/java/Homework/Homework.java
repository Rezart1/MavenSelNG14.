package Homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        String URL=" https://www.facebook.com/ ";
        driver.get(URL);

        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.get("https://www.bestbuy.com/");
        Thread.sleep(3000);
        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);
        String url="http://dev-hrm.yoll.io/";
        driver.navigate().to(url);
        Thread.sleep(3000);
        String fourthWebTitle = driver.getTitle();
        System.out.println("Fourth website title: " + fourthWebTitle);
        Thread.sleep(3000);
        driver.navigate().back();

        String thirdWebTitle= driver.getTitle();
        System.out.println("Third website title: "+thirdWebTitle);
        Thread.sleep(3000);

        driver.navigate().back();
        String secondWebsite= driver.getTitle();
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Second website title: "+secondWebsite);
        System.out.println("Current URL: " + currentUrl);

        if(currentUrl.contains("searchpage")){
            System.out.println("TEST: PASS");
        } else {
            System.out.println("TEST: FAIL");
        }
        System.out.println(currentUrl);
        Thread.sleep(3000);

        driver.navigate().back();
        String firstWebsiteTitle= driver.getTitle();
        System.out.println("First website title: "+firstWebsiteTitle);
        Thread.sleep(3000);
        driver.quit();
    }
}
