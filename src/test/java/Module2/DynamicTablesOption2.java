package Module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.NoSuchElementException;

public class DynamicTablesOption2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/tables");

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        printEmailByFullName(driver, "Frank", "Bach");

        driver.quit();
    }

    public static void printEmailByFullName(WebDriver driver, String fName, String lName) {
        try {

            // Find rows where first name and last name match the provided arguments
            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr/td[1][text()='"+lName+"']/../td[2][text()='"+fName+"']"));

            // Check if any matching row is found
            if (!rows.isEmpty()) {
                WebElement emailElement = rows.get(0).findElement(By.xpath("./following-sibling::td[1]"));
                String email = emailElement.getText();
                System.out.println("Email for " + fName + " " + lName + ": " + email);
            } else {
                System.out.println("No such record found in table.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No such record found in table.");
        }
    }
}
