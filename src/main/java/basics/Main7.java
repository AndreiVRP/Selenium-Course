package basics;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

// https://mvnrepository.com/artifact/com.codeborne/phantomjsdriver - that's the repo to install a PhantomJS dependency in pom.xml

public class Main7 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver");
        System.setProperty("webdriver.gecko.driver", "webDrivers/geckodriver");
        System.setProperty("phantomjs.binary.path", "webDrivers/phantomjs");
//        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new FirefoxDriver();
        WebDriver driver = new PhantomJSDriver();

//        driver.manage().window().fullscreen();
        driver.get("https://www.google.by/imghp?hl=be&tab=wi");
//        driver.findElement(By.xpath("//*[@aria-label=\"Search by image\"]")).click();
//        driver.findElement(By.xpath("//a[text()=\"Upload an image\"]")).click();
//        WebElement chooseFile = driver.findElement(By.xpath("//input[@type=\"file\"]"));
//        chooseFile.sendKeys("/Users/work/Desktop/test.png"); // the path always starts from / otherwise - file not found
//        takeScreenshot(driver);
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