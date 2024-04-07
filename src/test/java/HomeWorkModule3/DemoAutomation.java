package HomeWorkModule3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoAutomation {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Register.html");
        WebElement firstName=driver.findElement(By.cssSelector("[ng-model='FirstName']"));
        String fname="Rezart";
        firstName.sendKeys(fname);

        Thread.sleep(2000);
        for (int i=1;i<fname.length(); i++) {
            firstName.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(2000);
        }
        String remainingLetters = firstName.getAttribute("value");
        char firstLetter = remainingLetters.charAt(0);
        System.out.println("First letter after deleting the rest: " + firstLetter);
        driver.quit();

    }
}
