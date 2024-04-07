package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MagentoLogin {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();

//      Navigate to - https://magento.softwaretestingboard.com/
        String url ="https://magento.softwaretestingboard.com/";
        driver.get(url);
        String email="testautoman@email.com";
        String password="qwerty123!";
        //Click sign-in button on homepage - use xpath as a locator strategy.
        WebElement signIn= driver.findElement(By.xpath("(//*[contains(text(),'Sign In')])[1]"));
        signIn.click();
        Thread.sleep(3000);driver.getTitle();
        // Enter your email  - use xpath as a locator strategy.
        WebElement username= driver.findElement(By.xpath("//input[@id='email']"));
        username.sendKeys(email);
        //Enter your pwd  - use xpath as a locator strategy.
        WebElement pw= driver.findElement(By.xpath("//input[contains(@title,'Password')]"));
        pw.sendKeys(password);
        // Click signin button  - use xpath as a locator strategy.
        WebElement signInButton = driver.findElement(By.xpath("//button[@class='action login primary']"));
        signInButton.click();
        //Print Title of the page to verify you successfully signed in.
        System.out.println(driver.getTitle());
        // String currentURL= driver.getCurrentUrl();
        // System.out.println("Title "+currentURL);
        Thread.sleep(3000);
        //Print Welcome Message.
      WebElement welcomeMeassage=driver.findElement(By.xpath("(//span[@class=\"logged-in\"])[1]"));
        String textWelcomeMessage =welcomeMeassage.getText();

        System.out.println(textWelcomeMessage);

        if (textWelcomeMessage.startsWith("Welcome")){
            System.out.println("TEST: PASSED");
        }else{
            System.out.println("TEST: FAILED");
        }
        driver.quit();

    }
}
