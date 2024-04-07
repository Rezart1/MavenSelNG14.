package Module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SauceDemoPractice {
    public static void main(String[] args) throws InterruptedException {


//    Given the user is on the login page of "https://www.saucedemo.com/"
//    When the user logs in with valid credentials (username: "standard_user", password: "secret_sauce")
//    And navigates to the product listing page
//    And selects "Sauce Labs Backpack" from the product list
//    And adds the selected product to the shopping cart
//    and select
//    And navigates back to the product listing page
//    And then navigates to the shopping cart page
//    Then the user should see "Sauce Labs Backpack" listed in the cart with exactly 1 item present
//    And the console output should validate the success by outputting "TEST: PASSED"

        WebDriver driver =new ChromeDriver();
        String url="https://www.saucedemo.com/";
        driver.get(url);

        driver.manage().window().maximize();
        // locate web elements for login
        WebElement usernameinput= driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passwordinput= driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton= driver.findElement(By.xpath("//input[@value='Login']"));
        String username= "standard_user", password="secret_sauce";
        usernameinput.sendKeys(username);
        passwordinput.sendKeys(password);
        loginButton.click();
        Thread.sleep(2000);

        String currentUrl=driver.getCurrentUrl();
        System.out.println("URL after login: "+ currentUrl);

        WebElement addTocartButton= driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addTocartButton.click();
        Thread.sleep(3000);

        WebElement addToCartButton2=driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']"));
        addToCartButton2.click();
        Thread.sleep(3000);
//  locate the cart button
        WebElement cartButton =driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cartButton.click();
        Thread.sleep(3000);

        //verify that cart contains 2 items only
      List<WebElement> productsIncart=driver.findElements(By.xpath("//div[@class='cart_item']"));// Notice; findElements  not element
        // how do we verify
        int expectedItemsInCart = 2;
        int actualItemsInCart = productsIncart.size();

        if(expectedItemsInCart == actualItemsInCart){
            System.out.println("TEST: PASSED");
            System.out.println("Expected items in the cart: " + expectedItemsInCart);
            System.out.println("Actual items in the cart: " + actualItemsInCart);
        } else {
            System.err.println("TEST: FAILED");
            System.err.println("Expected items in the cart: " + expectedItemsInCart);
            System.err.println("Actual items in the cart: " + actualItemsInCart);
        }

        driver.quit();
    }
}