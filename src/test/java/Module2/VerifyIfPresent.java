package Module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyIfPresent {
    public static void main(String[] args) throws InterruptedException {

        // Simple login - for dev-hrm
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://dev-hrm.yoll.io/index.php/auth/login");

        Thread.sleep(3000);

        // Credentials
        String username="yoll-student";
        String password="Bootcamp5#";
        WebElement usernameInut= driver.findElement(By.cssSelector("[id=txtUsername]"));
        WebElement passwordInut= driver.findElement(By.cssSelector("[id=\"txtPassword\"]"));
        WebElement loginInut= driver.findElement(By.cssSelector("[class=\"button\"]"));
        Thread.sleep(3000);

        // Interact with elements
        usernameInut.sendKeys(username);
        passwordInut.sendKeys(password);
        loginInut.click();
        Thread.sleep(3000);
        // we verify if logo is present n the page
        //locate the logo
        //xpath - img[contains(@src,'yoll-logo')]
        // css -img[src *=yoll-logo]
        // when an exeption is thrown the execution code stops there
        // FIXME- bad approach to verify if an element is present

        //Option 1
//        WebElement logo= driver.findElement(By.cssSelector("img[src *=yoll-logoooo]")); //at this line findElement thorws exception
//        System.out.println("Logo is present on the screen");

        // the better approach is to make the code not fail when the elemnt is present
        // two approaches:
         // findElement -- if not found any it throws an exception
        //  findElements -- if not found the list will be empty, but no exception wil be thrown

        //Option 2
        // When we provide a proper element locator on the logo there should be one element located
        // otherwise it will be 0
//        List< WebElement>logoList= driver.findElements(By.cssSelector("img[src *=yoll-logo]"));
//
//        System.out.println("Elements found "+logoList.size());
//        if (logoList.size()==1){
//            System.out.println("Logo verifiation past");
//        }else{
//            System.out.println("Logo verification failed");
//        }

        //Refactor; Option 3
       boolean isLogoPresent= (driver.findElements(By.cssSelector("img[src *=yoll-logo]")).size()==1);
        System.out.println("Logoverification past: "+ isLogoPresent);
        driver.quit();

    }
}
