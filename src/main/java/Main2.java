import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().fullscreen();

//        chromeDriver.get("https://trailhead.salesforce.com/en/modules");
//        chromeDriver.findElement(By.xpath("//ul[@data-filter-type=\"levels\"]//a[contains(text(),\"Advanced\")]")).click();
//        System.out.println(chromeDriver.getCurrentUrl());

        chromeDriver.get("https://market.yandex.by/");
        chromeDriver.findElement(By.xpath("//input[contains(@id,\"search\")]")).sendKeys("smartphone");
        chromeDriver.findElement(By.xpath("//div[contains(@itemtype,\"schema\")]//button")).submit();

        Actions actions = new Actions(chromeDriver);
        actions.moveToElement(chromeDriver.findElement(By.xpath("//input[@type=\"radio\" and contains(@name,\"Способ доставки\")]"))).click().perform();

        String[] boxes = {"BestHard", "RAM.BY", "NOVATEK"};
        for (String box : boxes) {
            String boxPath = "//input[@type=\"checkbox\" and contains(@name,\""+ box + "\")]";
            WebElement checkbox = chromeDriver.findElement(By.xpath(boxPath));
            actions.moveToElement(checkbox).click().perform();
            if (checkbox.isSelected()) {
                System.out.println(box + " is checked!");
            }
        }
        chromeDriver.quit();
    }
    
}
