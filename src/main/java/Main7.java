import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main7 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.google.com/");
        takeScreenshot(driver);
        WebElement searchInput = driver.findElement(By.xpath("//input[@aria-label=\"Search\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(searchInput)
                .sendKeys("12345qwerty12345")
                .doubleClick()
                .sendKeys("56789!")
                .sendKeys(Keys.chord(Keys.COMMAND, "a"))
                .build().perform();
        takeScreenshot(driver);
        driver.quit();
    }

    public static void takeScreenshot(WebDriver driver) {
        // taking screenshots
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
        String fileName = format.format(dateNow) + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/screenshots/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}