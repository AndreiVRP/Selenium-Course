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
        chromeDriver.findElement(By.xpath("//input[@name=\"search\"]")).sendKeys("Selenium WebDriver");
        chromeDriver.findElement(By.xpath("//button/i[text()=\"Search\"]")).click();
        WebElement searchInput = chromeDriver.findElement(By.xpath("//div[@id=\"searchText\"]/input"));
        System.out.println(searchInput.getAttribute("value"));
        searchInput.clear();
        searchInput.sendKeys("Java");
        chromeDriver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        chromeDriver.get("https://www.github.com/");
        chromeDriver.findElement(By.xpath("//summary[contains(text(),\"GitHub\")]")).click(); // Why GitHub?
        chromeDriver.findElement(By.xpath("//div/a[contains(text(),\"Features\")]")).click(); // Features
        chromeDriver.findElement(By.xpath("//div[contains(@class,\"Header\")]//a[contains(@href, \"join?\")]")).click();
        chromeDriver.navigate().back();
        chromeDriver.navigate().back();
        WebElement signUpButton = chromeDriver.findElement(By.xpath("//div/button[contains(text(), \"Sign up\")]"));
        if (signUpButton.getText().equals("Sign up for GitHub")) {
            System.out.println("Success!");
        }
        signUpButton.submit();

        chromeDriver.findElement(By.xpath("//div[contains(@class,\"Header\")]//a[contains(@href, \"login?\")]")).click();
        chromeDriver.findElement(By.xpath("//input[@value=\"Sign in\"]")).submit();
        WebElement termsLink = chromeDriver.findElement(By.xpath("//a[text()=\"Terms\"]"));
        System.out.println(termsLink.getText());
        termsLink.click();

        chromeDriver.quit(); // closes all the windows
        //        chromeDriver.close(); //closes the current window
    }
}
