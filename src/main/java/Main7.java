import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main7 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.google.com/");
        WebElement searchInput = driver.findElement(By.xpath("//input[@aria-label=\"Search\"]"));
        Actions actions = new Actions(driver);

        actions.moveToElement(searchInput)
                .sendKeys("12345qwerty12345")
                .doubleClick()
                .sendKeys("56789")
                .sendKeys(Keys.chord(Keys.COMMAND, "a"))
                .build().perform();

        driver.quit();
    }
}
