package Module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RecapTablePractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize();

        // checked ex -> compile time
        // unchecked ex -> runtime
        driver.get("https://testautomationpractice.blogspot.com/");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        printColumnFromTable(driver, 2);
        driver.quit();
    }
    public static void printColumnFromTable(WebDriver driver, int position){
        List<WebElement> authors = driver.findElements(By.xpath("//*[@name = 'BookTable']/tbody//td["+position+"]"));
        for(WebElement element : authors){
            System.out.println(element.getText());
        }

    }
}
