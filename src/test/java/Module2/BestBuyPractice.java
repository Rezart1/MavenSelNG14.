package Module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BestBuyPractice {
    public static void main(String[] args) throws InterruptedException {
        //create a driver object: will name the object driver
        WebDriver driver =new ChromeDriver();

       // navigate to bestby
        driver.get("https://www.bestbuy.com/");
        // locate the element we want to interact

        WebElement searchInput= driver.findElement(By.className("search-input"));
        WebElement searchButton= driver.findElement(By.className("header-search-icon"));
        // --------------- Do the actions with these elements -------------//
        searchInput.clear();
        searchInput.sendKeys("iPhone 15");
        Thread.sleep(5000);

        searchButton.click();
        Thread.sleep(4000);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        if(currentUrl.contains("searchpage")){
            System.out.println("TEST: PASS");
        } else {
            System.out.println("TEST: FAIL");
        }

        driver.quit();
    }
}
