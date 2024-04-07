package Tutoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TutoringApril3 {
    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Go to Amazon.com
        driver.get("https://www.amazon.com");

        //Get All Elements from Main Navigation Bar:
        List<WebElement> allNavBarLinks = driver.findElements(By.xpath("//*[@id='nav-xshop']/a"));

        //Print all the texts from the elems
        System.out.println(getTextFromElements(allNavBarLinks));

        //Quit the driver
        driver.quit();

    }

    public static List<String> getTextFromElements(List<WebElement> elements){
        List<String> elemText= new ArrayList<>();
        for(WebElement eachElem: elements){
            elemText.add(eachElem.getText());
        }
        return elemText;
    }
    }

