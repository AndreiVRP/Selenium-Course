import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().fullscreen();
        chromeDriver.get("https://www.facebook.com/");
        chromeDriver.findElement(By.xpath("//select[@title=\"Year\"]")).click();
//        chromeDriver.findElement(By.xpath("//select[@title=\"Year\"]//option[@value=\"2018\"]")).click();
        chromeDriver.findElement(By.xpath("//option[@value=\"1985\"]")).click();
        chromeDriver.findElement(By.xpath("//input[@name=\"firstname\"]")).click();
        List<WebElement> footerLinks = chromeDriver.findElements(By.xpath("//ul[contains(@class, \"Footer\")]/li"));
        for (WebElement link : footerLinks) {
            System.out.println(link.getText());
        }
        System.out.println(footerLinks.size());
        chromeDriver.quit();
    }

}
