package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DynamicTable2 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        // Initialize WebDriver
        driver.manage().window().maximize();

        // Access the Web Page
        driver.get("https://practice.expandtesting.com/dynamic-table");

        // Capture and Display Page Title
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Find the row containing the 'Chrome' browser in the dynamic table
        WebElement chromeRow = driver.findElement(By.xpath("//div[@class='table-responsive']//tbody//tr[td[contains(text(), 'Chrome')]]"));

        // Find the actual CPU value associated with Chrome
        WebElement chromeCPUElement = driver.findElement(By.id("chrome-cpu"));
        String actualCPUText = chromeCPUElement.getText();
        System.out.println("Actual CPU Text: " + actualCPUText);

        // Parse the CPU value from the actual text
        String actualCPUValue = actualCPUText.split(": ")[1]; // Extract the numeric portion after ": "
        System.out.println("Actual CPU Value: " + actualCPUValue);

        // Iterate through all cells in the row to find the CPU value
        List<WebElement> cells = chromeRow.findElements(By.tagName("td"));
        String expectedCPUValue = null;
        for (WebElement cell : cells) {
            String cellText = cell.getText();
            if (cellText.contains("%")) { // Assuming CPU value contains '%'
                expectedCPUValue = cellText;
                break;
            }
        }
        System.out.println("Expected CPU Value: " + expectedCPUValue);

        // Validate CPU Values
        if (expectedCPUValue != null && expectedCPUValue.equals(actualCPUValue)) {
            System.out.println("TEST: PASSED");
        } else {
            System.out.println("TEST: FAILED");
        }

        // Quit WebDriver
        driver.quit();
    }
}
