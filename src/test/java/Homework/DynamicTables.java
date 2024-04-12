package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DynamicTables {
    public static void main(String[] args) {
//        Objective:
//        In this task, you are required to demonstrate your proficiency in using dynamic XPath strategies to accurately retrieve specific data from a web table. You will write a program that locates and outputs the email address associated with a given person’s name. Additionally, you will employ your Java programming skills to perform calculations on data extracted from the table, specifically summing up all the values in a specified column of prices. Your code should be robust, handling potential exceptions gracefully, and ensuring accurate and efficient data retrieval and calculation.
//
//        Process:
//        Create a driver object.
//        Maximize the window.
//        Navigate to 'https://practice.expandtesting.com/tables'.
//        Print the Page Title as: 'Page Title: ' - replace with the actual title of the page.
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/tables");

        String tittle = driver.getTitle();
        System.out.println("Page title: "+tittle);

        printEmailByFullName(driver, "Frank", "Bach");

                double expectedAmount = 251.0;
                double actualAmount = getTotalAmountOfDueColumn(driver);

                if (actualAmount == expectedAmount){
                    System.out.println("TEST: PASSED");
                } else {
                    System.out.println("TEST: FAILED");
                }


//        WebElement firstName = driver.findElement(By.xpath(xpathFirstName));
//        String fName = firstName.getText();
//        System.out.println(fName);
//        //last name
//        String xPathlastName = "//table[@id='table1']//tbody//td[text()='Frank']/../td[text()='Bach']";
//        WebElement lastName = driver.findElement(By.xpath(xPathlastName));
//        String lName = lastName.getText();
//        System.out.println(lName);
//        String emailXPath = ("//table[@id='table1']//tbody//td[text()='Frank']/../td[text()='Bach']");
//        WebElement fullemail = driver.findElement(By.xpath(emailXPath));
//        String email = fullemail.getText();
//        System.out.println("Email for " + fName + " " + lName + ": " + email);
        driver.quit();

    }

    //        Create a method named printEmailByFullName:
//        Parameters: WebDriver driver, String fName, String lName.
//        Build a dynamic XPath to identify a person's email based on the provided full name.
//        Print the email of the requested person.
//        Optional: Handle the scenario where the person does not exist in the table.
//        Instead of throwing an exception, print: "No such record found in table."
    public static void printEmailByFullName(WebDriver driver, String fName, String lName) {


                String getEmailXpath = "//table[@id='table1']//td[text()='"+fName+"']/../td[text() = '"+lName+"']/../td[3]";

                boolean itemPresent = !driver.findElements(By.xpath(getEmailXpath)).isEmpty();

                if(itemPresent){
                    String value = driver.findElement(By.xpath(getEmailXpath)).getText();
                    System.out.println(fName + " " + lName + " email: " + value);
                } else {
                    System.out.println("No such record found in table.");
                }
            }

            public static double getTotalAmountOfDueColumn(WebDriver driver){
                List<WebElement> pricesWebElements = driver.findElements(By.xpath("//table[@id='table1']//td[4]"));

                double totalAmount = 0.0;

                for (WebElement priceElement :pricesWebElements) {
                    String priceText = priceElement.getText();
                    double price = Double.parseDouble(priceText.substring(1));
                    totalAmount += price;
                }

                return totalAmount;
            }

        }





/*
 // Build dynamic XPath
             String xpath = ("//table[@id='table1']//tbody//td[text()="+fName+"]/../td[text()="+lName+"]/following-sibling::td[2]");

            // Find the element
            WebElement Fullemail = driver.findElement(By.xpath(xpath));
            String email=Fullemail.getText();
            System.out.println(email);
            // Get and print email
            //String emailName = emailFirstPart.getText();

            System.out.println("Email for " + fName + " " + lName + ": " + email);
 */