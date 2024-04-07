package tutoringPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://learn.yoll.io/path-player?courseid=c14-selenium&unit=653162d30ab91efcb703a13bUnit");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
