import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().fullscreen();

        chromeDriver.get("https://trailhead.salesforce.com/en/modules");
        chromeDriver.findElement(By.xpath("//ul[@data-filter-type=\"levels\"]//a[contains(text(),\"Advanced\")]")).click();
        System.out.println(chromeDriver.getCurrentUrl());

        chromeDriver.quit();
    }
}
