package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class VerifyingTabVisualFeedback {

   public static void main(String[] args) throws InterruptedException {

      String  user= "yoll-student";
       String pass= "Bootcamp5#";
            WebDriver driver =new ChromeDriver();
            String url="http://dev-hrm.yoll.io/";
            driver.get(url);
                Thread.sleep(3000);
            WebElement username= driver.findElement(By.id("txtUsername"));
            username.sendKeys(user);
            WebElement pw= driver.findElement(By.id("txtPassword"));
            pw.sendKeys(pass);
            driver.findElement(By.id("btnLogin")).click();
            Thread.sleep(2000);
            driver.quit();

        }

    }

