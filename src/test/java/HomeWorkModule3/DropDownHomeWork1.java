package HomeWorkModule3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
        /*Navigate to http://demo.automationtesting.in/Register.html
        -Locate the dropdown “Year”
        -Print all options for “Year”dropdown on your console
        -Select your 2015 from “Year” dropdown using selectByVisibleText() method
        */
public class DropDownHomeWork1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Register.html");

        WebElement yearDropdown= driver.findElement(By.id("yearbox"));
        Select dropdown = new Select(yearDropdown );
        List<WebElement> allYears=dropdown.getOptions();
//        dropdown.selectByIndex(5);
//        dropdown.selectByValue("1917");
//        dropdown.selectByVisibleText("2015");
//        Thread.sleep(2000);
//        for(WebElement year:allYears){
//            System.out.println(year.getText());
//        }

        /*-Navigate to http://demo.automationtesting.in/Register.html
        -Locate the dropdown “Month”
        -Iterate through the months using for each loop until you find your DOB month-
        -Print all months on console until you find your DOB months
        -Once you find your month exit the loop using ‘break’ and don't print remaining months
         */
        WebElement monthDropdown=driver.findElement(By.cssSelector("[placeholder=Month]"));
        Select dropdownM = new Select(monthDropdown );
        List<WebElement> allMonths=dropdownM.getOptions();


        for(WebElement month:allMonths){
            System.out.println(month.getText());
            if (month.getText().equals("September"))
                break;

            }

        driver.quit();

    }

}
