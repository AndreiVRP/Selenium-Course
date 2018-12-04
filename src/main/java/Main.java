import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver"); //relative path allowed
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.youtube.com");
    }
}
