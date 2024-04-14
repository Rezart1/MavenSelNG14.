package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;

import java.util.List;

public class DynamicTables2Option2 {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.get("https://practice.expandtesting.com/dynamic-table");
        String title= driver.getTitle();
        System.out.println("Page Title"+title);

        // Find the row containing the 'Chrome' browser in the dynamic table

        List<WebElement> columnHeaders = driver.findElements(By.xpath("//table//th"));
       int cpuColumnPosition = -1;

        for(int i = 0; i < columnHeaders.size(); i++){
            String currentHeaderName = columnHeaders.get(i).getText();
            if ("CPU".equals(currentHeaderName)){
                cpuColumnPosition =i+1;
                System.out.println(cpuColumnPosition);
                break;
            }
       }

        // Find the row containing the 'Chrome' browser in the dynamic table
        String chromeCpuXpath = "//table//td[text() = 'Chrome']/../td["+cpuColumnPosition+"]";
        String actualChromeCpu = driver.findElement(By.xpath(chromeCpuXpath)).getText();
        System.out.println("Actual Chrome CPU: " + actualChromeCpu);

        String expectedChromeCPU = driver.findElement(By.id("chrome-cpu")).getText();
        System.out.println("Expected Chrome CPU"+ expectedChromeCPU);

        if (expectedChromeCPU.endsWith(actualChromeCpu)){
            System.out.println("Test: PASSED");
        }else{
            System.out.println("Test: FAIL");
        }
        driver.quit();
    }

}
//tbody/tr//td[text()='Chrome']/../td[2]
