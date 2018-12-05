import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver"); //relative path allowed
        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        /*
        setting the implicit wait to 5 secs sometimes make the script fail when clicking github's features
        since the button simply needs more time to load at time
        */
        chromeDriver.manage().window().setSize(new Dimension(1280, 720));

        chromeDriver.get("https://www.wikipedia.org/");
        chromeDriver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("Selenium WebDriver");
        chromeDriver.findElement(By.xpath("//*[@id=\"search-form\"]/fieldset/button")).click();
        WebElement searchInput = chromeDriver.findElement(By.xpath("//*[@id=\"ooui-php-1\"]"));
        System.out.println(searchInput.getAttribute("value"));
        searchInput.clear();
        searchInput.sendKeys("Java");
        chromeDriver.findElement(By.xpath("//*[@id=\"mw-search-top-table\"]/div/div/div/span/span/button")).click();

        chromeDriver.get("https://www.github.com/");
        chromeDriver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/nav/ul/li[1]/details/summary")).click(); // Why GitHub?
        chromeDriver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/nav/ul/li[1]/details/div/a")).click(); // Features
        chromeDriver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[2]")).click();
        chromeDriver.navigate().back();
        chromeDriver.navigate().back();
        WebElement signUpButton = chromeDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/form/button"));
        if (signUpButton.getText().equals("Sign up for GitHub")) {
            System.out.println("Success!");
        }
        signUpButton.submit();

        chromeDriver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[1]")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"login\"]/form/div[3]/input[3]")).submit();

        chromeDriver.quit(); // closes all the windows
        //        chromeDriver.close(); //closes the current window
    }
}
