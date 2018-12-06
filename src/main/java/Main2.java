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

        String[] checkBoxes = {"BestHard", "RAM.BY", "NOVATEK"};
        String[] radioButtons = {"Способ доставки"};
        checkBox(chromeDriver, BoxType.checkbox, checkBoxes);
        checkBox(chromeDriver, BoxType.radio, radioButtons);
        chromeDriver.quit();
    }

    public static void checkBox(WebDriver driver, BoxType boxType, String[] boxes) {
        for (String box : boxes) {
            Actions actions = new Actions(driver);
            String boxPath = "//input[@type=\"" + boxType.toString() + "\" and contains(@name,\"" + box + "\")]";
            WebElement checkbox = driver.findElement(By.xpath(boxPath));
            actions.moveToElement(checkbox).click().perform();
            if (checkbox.isSelected()) {
                switch (boxType) {
                    case checkbox:
                        System.out.println("Checkbox " + box + " is checked!");
                        break;
                    case radio:
                        System.out.println("Radio button " + box + " is selected!");
                        break;
                    default:
                        System.out.println("Undefined behavior...");
                        break;
                }
            }
        }
    }

    enum BoxType {
        checkbox, radio
    }

}
