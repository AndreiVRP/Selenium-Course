import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver");
        WebDriver chromeDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(chromeDriver, 5);

        chromeDriver.manage().window().fullscreen();
        chromeDriver.get("https://www.facebook.com/");
        chromeDriver.findElement(By.xpath("//select[@title=\"Year\"]")).click();
        WebElement birthYear = chromeDriver.findElement(By.xpath("//option[@value=\"1985\"]"));
        wait.until(ExpectedConditions.visibilityOf(birthYear)).click();
        chromeDriver.findElement(By.xpath("//input[@name=\"firstname\"]")).click();
        List<WebElement> footerLinks = chromeDriver.findElements(By.xpath("//ul[contains(@class, \"Footer\")]/li"));
        for (WebElement link : footerLinks) {
            System.out.println(link.getText());
        }
        System.out.println(footerLinks.size());
        chromeDriver.quit();
    }

}
