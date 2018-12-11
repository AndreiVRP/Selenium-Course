package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

public class Main6 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://en.wikipedia.org");
        WebElement searchInput = findSearchInput(driver); //creating a search input variable
        searchInput.sendKeys("Apple");
        searchInput.sendKeys(Keys.ENTER);

        searchInput = findSearchInput(driver); // updating the search input variable (since this is another page and it's DOM is different)
        searchInput.sendKeys(Keys.chord(Keys.SHIFT, "usa"));
        searchInput.sendKeys(Keys.ENTER);

        searchInput = findSearchInput(driver);
        String select = Keys.chord(Keys.CONTROL, "a");
        String cut = Keys.chord(Keys.CONTROL, "x");
        String paste = Keys.chord(Keys.CONTROL, "v");

        Actions actions = new Actions(driver);
        searchInput.sendKeys("test");
        actions.moveToElement(searchInput)
                .doubleClick() // this is required to bring the input field back into focus and select the input text
//                .sendKeys(select) // isn't required if doubleClick() is used
                .sendKeys(cut)
                .build().perform();
//TODO - control/command + a/c/x/v and doubleCLick() for input fields
        driver.quit();
    }

    public static WebElement findSearchInput(WebDriver driver) {
        WebElement searchInput = driver.findElement(By.xpath("//input[@id =\"searchInput\"]"));
        return searchInput;
    }
}
