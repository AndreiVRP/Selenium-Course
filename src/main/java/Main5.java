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

        //executing JavaScript and working with alerts
        JavascriptExecutor jse = (JavascriptExecutor) chromeDriver;
        jse.executeScript("alert('HELLO, WORLD!');");
        chromeDriver.switchTo().alert().accept();
        jse.executeScript("window.scrollBy(0,1000)", "");

        chromeDriver.get("https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html");
        chromeDriver.findElement(By.xpath("//a[text()=\"jdk-8u192-macosx-x64.dmg\"]")).click();
        pauseFor(1);
        chromeDriver.switchTo().alert().dismiss();

        //working with different windows
        String mainWindow = chromeDriver.getWindowHandle(); //this is the initial browser window
        chromeDriver.findElement(By.xpath("//a[contains(text(),\"License Agreement\") and contains(@href,\"192\")]")).click();
        switchToNewWindow(chromeDriver);

        //now you can interact with the web page open in this window
        WebElement contactMenu = chromeDriver.findElement(By.xpath("//a[contains(@href,\"contactmenu\")]"));
        actions.moveToElement(contactMenu).click().build().perform();
        pauseFor(1);
        chromeDriver.switchTo().window(mainWindow); // navigating back to the initial window
        pauseFor(1);
        chromeDriver.quit();
    }

    public static void pauseFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void switchToNewWindow(WebDriver driver) {
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle); // this is to finally get to the most recent (new) window (or tab)
        }
    }
}
