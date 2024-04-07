package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationForm {
    public static void main(String[] args) throws InterruptedException {
//        Navigate to 'http://demo.guru99.com/test/newtours/'
//        Click on 'Register' tab on top navigation menu.
//                Fill out all of the fields.
//                Click 'Submit' button.
//                If the url ends with '/register_sucess.php' print in the console
//                TEST: PASSED otherwise, TEST: FAILED.
//                Terminate the driver

        WebDriver driver = new ChromeDriver();
        String url = "http://demo.guru99.com/test/newtours/";
        driver.get(url);
        driver.manage().window().maximize();
     WebElement register= driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a"));
    register.click();
    driver.findElement(By.name("firstName")).sendKeys("John");
    driver.findElement(By.name("lastName")).sendKeys("Smith");
    driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("6174040538");
    driver.findElement(By.id("userName")).sendKeys("userName");
    driver.findElement(By.name("address1")).sendKeys("123 Quincy St");
    driver.findElement(By.name("city")).sendKeys("Baintree");
    driver.findElement(By.name("state")).sendKeys("Mass");
    driver.findElement(By.name("country")).sendKeys("Albania");
    Thread.sleep(2000);
    driver.findElement(By.id("email")).sendKeys("efeldman@gmail.com");
    Thread.sleep(2000);
    driver.findElement(By.name("password")).sendKeys("Arber1234");
    Thread.sleep(2000);
    driver.findElement(By.name("confirmPassword")).sendKeys("Arber1234");
    Thread.sleep(2000);
    WebElement submitButton= driver.findElement(By.name("submit"));
    submitButton.click();
    Thread.sleep(2000);

    String endOfUrl="/register_sucess.php";
    String currentURL= driver.getCurrentUrl();
        System.out.println(currentURL);
    if (currentURL.endsWith(endOfUrl)){
        System.out.println("TEST: PASSED");
    }else{
        System.out.println("TEST: FAILED");
    }
    driver.quit();
    }
}
