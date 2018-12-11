package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();

        driver.get("https://github.com");
//        HomePage homePage = new HomePage(driver);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.register("testusername", "12345@test.comm","123456789");
        driver.quit();
    }
}
