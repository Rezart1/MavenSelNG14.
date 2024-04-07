package Module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetPageInformation {

    public static void main(String[] args) {
        WebDriver driver =new ChromeDriver();

        driver.manage().window().maximize();
        String url="https://www.google.com/";
        driver.get(url);

        // next we can get usefull information about the webpage we are interacting with
        //driver.getTitle();
        // it returns a String so we can assing a variable name as String
        String title= driver.getTitle();
        System.out.println("Page title is: "+ title);

        // another verification point will be the current url
        String currentUrl =driver.getCurrentUrl();
        System.out.println("Actual URL: "+ currentUrl);

        driver.quit();

    }
}
