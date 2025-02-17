package testngBasics.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class HRMLoginTest {

        /*Scenario: User should be able to successfully login
	Given User Navigates to login page
	When User Enters valid username: yoll-student
	And User Enters valid password: Bootcamp5#
	Then account username is displayed as "Welcome Yoll"

Scenario: User should not be able to login to HRM with invalid credentials
	Given User navigates to login page
	When User enter  invalid username
	And User enter invalid  password
	And User click on login button
	Then User receives an error message as "Invalid Credentials"

Scenario: User should be able to logout from HRM
	Given User logged in and landed in homepage
	When User clicks on logout button
	Then User lands on login page*/

    /* WebDriver driver = new ChromeDriver();
    driver.get("http://dev-hrm.yoll.io/index.php/auth/login");
    // When User logs in with valid credentials
    // Locate the elements as username, password and login button
    WebElement userNameInput = driver.findElement(By.name("txtUsername"));
    WebElement passwordInput = driver.findElement(By.id("txtPassword"));
    WebElement loginButton = driver.findElement(By.id("btnLogin"));
    userNameInput.sendKeys("yoll-student");
    passwordInput.sendKeys("Bootcamp5#");
    loginButton.click();*/
    WebDriver driver;

    /*
     * In some cases we will need to do something before each test case in the current class
     * e.g. setup the driver and land on a page
     * TestNG provides us Annotations that can make that happen
     * @BeforeMethod and @AfterMethod will make sure that those are run before and after each test (a method that is marked with @test annotation) in given class
     *
     * */

    @BeforeMethod
    public void setUp() {
        /* Set Up */
        driver = new ChromeDriver();
        driver.get("http://dev-hrm.yoll.io/index.php/auth/login");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @BeforeClass
    public void dbConnectionSetup() {
        System.out.println("--- LOGGER: Connection to data base opened....");
    }

    @AfterClass
    public void dbCleanUp() {
        System.out.println("--- LOGGER: Connection to data base closed.");
    }

    @Test(priority = 0)
    public void testSuccessfulLoginDisplaysUsername() {
        login("yoll-student", "Bootcamp5#");
        /* Locate and verify the welcome message */
        WebElement welcomeMessageElement = driver.findElement(By.id("welcome"));
        String actualWelcomeMessage = welcomeMessageElement.getText();
        String expectedWelcomeMessage = "Welcome Yoll";
        /* Assert.assertEquals() */
        Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage, "Welcome message verification failed!");
    }

    /*
     * Options to disable a test
     * - comment out (usually we do not want to push commented cod to remote repo!)
     * - remove the test (not recommended)
     * - we can add properties/parameters to the Test annotation itself
     * */
    @Test(dataProviderClass = TestData.class, dataProvider = "invalidLoginCredentialsDataSet")
    public void testLoginWithInvalidCredentials(String username, String password, String expectedErrorMessage){
        login(username, password);
        /* Locate the error message and verify it is as expected */
        WebElement errorMessageElement = driver.findElement(By.id("spanMessage"));
        String actualErrorMessage = errorMessageElement.getText();
        /* Assert */
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message verification failed!");
    }



    @Test (priority= 3)
    public void testUserCanLogOut() throws InterruptedException {
        login("yoll-student", "Bootcamp5#");
        /*
         * We identified that the dropdown activation is an animation that takes a little of time
         * If we want to sync the code with page rendering we will add wait or sleep method to wait until the dropdown is fully visible
         *  */
        WebElement welcomeMessageDropdown = driver.findElement(By.id("welcome"));
        welcomeMessageDropdown.click();
        Thread.sleep(1000);
        WebElement logoutPotionElement = driver.findElement(By.xpath("//a[text() = 'Logout']"));
        logoutPotionElement.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedEndpoint = "/login";
        Assert.assertTrue(actualUrl.endsWith(expectedEndpoint), "Logout validation failed. The endpoint is not as expected!");
    }


    /* Reusable methods are created in order to be called form common automated scripts */
    public void login(String username, String password) {
        WebElement userNameInput = driver.findElement(By.name("txtUsername"));
        WebElement passwordInput = driver.findElement(By.id("txtPassword"));
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}



