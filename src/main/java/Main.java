import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver"); //relative path allowed
        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.manage().window().setSize(new Dimension(1280,720));

        chromeDriver.get("https://www.google.com");
        chromeDriver.navigate().to("https://www.youtube.com");
        chromeDriver.navigate().back();
        chromeDriver.navigate().forward();
        chromeDriver.navigate().refresh();
        System.out.println(chromeDriver.getTitle());
        System.out.println(chromeDriver.getCurrentUrl());
//        chromeDriver.close(); // difference between close() and quit()
        chromeDriver.quit();
    }
}
