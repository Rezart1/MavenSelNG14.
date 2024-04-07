package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DemoWebShop {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        String url = "https://demowebshop.tricentis.com/";
        driver.get(url);

//        List<WebElement> totalItems = driver.findElements(By.xpath("//div[@class='item-box']"));
//        Thread.sleep(3000);
//        System.out.println("Items found: " + totalItems.size());

//        List<WebElement> categories = driver.findElements(By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li"));
//        Thread.sleep(3000);
//        System.out.println("Number of available options: " + categories.size());

       // List<WebElement> availableOptions = driver.findElements(By.xpath("//div[@class='column customer-service']/ul/li"));
        List<WebElement> availableOptionsHead = driver.findElements(By.xpath("//div[@class='column customer-service']/ul/li"));

        Thread.sleep(3000);
        System.out.println("Number of available options: " + availableOptionsHead.size());

        driver.quit();


    }
}
/*1. Logo:
        - //img[contains(@src,'logo.png')]
        - //img[@alt = 'Tricentis Demo Web Shop']
        2. Gift Cart:
        - //a[text() = '$25 Virtual Gift Card']
        - //h2[@class = 'product-title']//a[text() = '$25 Virtual Gift Card']
        3. Wishlist:
        - //*[@class = 'header']//*[@class = 'ico-wishlist']
        - //div[@class = 'header-links']//*[@href = '/wishlist']
        4. Register:
        - //a[text() = 'Register']
        5. Search Button:
        - //input[contains(@class, 'search-box-button')]
        6. Search Input Field:
        - //input[@id = 'small-searchterms']
        7. Build your own expensive computer price:
        - //a[text() = 'Build your own expensive computer']/../..//span
        1. Logo:
- //img[contains(@src,'logo.png')]
- //img[@alt = 'Tricentis Demo Web Shop']
2. Gift Cart:
- //a[text() = '$25 Virtual Gift Card']
- //h2[@class = 'product-title']//a[text() = '$25 Virtual Gift Card']
3. Wishlist:
- //*[@class = 'header']//*[@class = 'ico-wishlist']
- //div[@class = 'header-links']//*[@href = '/wishlist']
4. Register:
- //a[text() = 'Register']
5. Search Button:
- //input[contains(@class, 'search-box-button')]
6. Search Input Field:
- //input[@id = 'small-searchterms']
7. Build your own expensive computer price:
- //a[text() = 'Build your own expensive computer']/../..//span
Part 2: Understanding XPath and Element Collection in Selenium

Explanation:

When developing web automation scripts, it's often necessary to locate multiple web elements on a page.
One popular strategy for this is using XPath, which allows you to specify criteria that match multiple elements.

If an XPath expression matches more than one element on a webpage, the result is a collection of those web elements.
In the context of Selenium, this collection is represented as a list of WebElements.

When you anticipate that an XPath might match multiple elements on a page, you should use the findElements() method in Selenium.
Note the 's' in findElements, which indicates that it's designed to fetch multiple elements. This method returns a list of WebElement objects.
For instance: List elements = driver.findElements(By.xpath("your-xpath-here"));
The returned datatype of the findElements() method is List, representing a list of WebElement objects.

Counting the Elements:

To ascertain the number of elements that an XPath has matched, simply invoke the size() method on the returned list.

When it comes to counting the elements matched by an XPath, there are two primary approaches:

Assign the result of findElements() to a List object and subsequently call the size() method.
Directly apply the size() method to the result of the findElements() method, bypassing the need to store the elements
in a list if they aren't required for further processing.
Consider an XPath expression that matches 10 elements, represented as "//*[@class = 'items']".

To retrieve and count these elements using Selenium:

List elements = driver.findElements(By.xpath("//*[@class = 'items']"));
With the elements stored in the 'elements' list, you can then determine the count as follows:

int countOfItems = elements.size();

If your sole aim is to ascertain the count without any subsequent processing of the elements, you can shorten the code as follows:
int countOfItems = driver.findElements(By.xpath("//*[@class = 'items']")).size();
 */

