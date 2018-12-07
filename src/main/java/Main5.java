import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main5 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().fullscreen();
        chromeDriver.get("https://www.ebay.com");
        WebElement hoverItem = chromeDriver.findElement(By.xpath("//li[contains(@data-hover-track,\"888\")]//a[text()=\"Электроника\"]"));
        Actions actions = new Actions(chromeDriver);
        actions.moveToElement(hoverItem).build().perform(); // hovering over a web element
        /*
        actions
        .dragAndDrop(element1, element2).build().perform();
        .clickAndHold(element1).moveToElement(element2).release().build().perform();
        .doubleClick(element);
        .contextClick(element);
        */

        //executing JavaScript
        JavascriptExecutor jse = (JavascriptExecutor) chromeDriver;
//        jse.executeScript("alert('HELLO, WORLD!');");
        jse.executeScript("window.scrollBy(0,1000)", "");

//        chromeDriver.quit();
    }
}
