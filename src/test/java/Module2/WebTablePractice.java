package Module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePractice {
    public static void main(String[] args) throws InterruptedException {


            WebDriver driver = new ChromeDriver();
            // driver.manage().window().maximize();

            // Navigate to a specific web page
            driver.get("https://testautomationpractice.blogspot.com/");
            Thread.sleep(1000);
            // if we try to print the web element itself it wont give us much useful information
            // to actually get the content of the element we will use getText() method
            // System.out.println(thirdTableCell);
            // We can use getText() method in selenium with webElements
            // this method will extract the content/text/free text
            // it will return as a string
            printDataFromTableCellByIndex(driver, 3,2);
            printDataFromTableCellByIndex(driver, 1,3);
            printDataFromTableCellByIndex(driver, 5,1);

            driver.quit();

        }

        public static void printDataFromTableCellByIndex(WebDriver driver, int row, int column){
            String dynamicXpath = "//table[@id = 'productTable']/tbody/tr["+row+"]/td["+column+"]";
            WebElement thirdTableCell = driver.findElement(By.xpath(dynamicXpath));
            String thirdTableCellText = thirdTableCell.getText();
            System.out.println("The data from table cell is: " + thirdTableCellText);
            /*
            String dynamicXpath = "//table[@id = 'productTable']/tbody/tr["+row+"]/td["+column+"]";
            WebElement randomTableCell = driver.findElement(By.xpath(dynamicXpath));
            String randomTableCellText = randomTableCell.getText();
            System.out.println("The data from table cell is: " + randomTableCellText);
            */

        }


}
