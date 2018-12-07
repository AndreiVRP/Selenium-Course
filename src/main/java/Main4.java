import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main4 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().fullscreen();
        chromeDriver.get("https://www.w3schools.com/html/html_tables.asp");
        WebElement tableElement = chromeDriver.findElement(By.xpath("//table[@id=\"customers\"]"));
        Table table = new Table(tableElement, chromeDriver);
        System.out.println("Rows number is " + table.getRows().size());
        System.out.println(table.getValueFromCell(2, 3));
        System.out.println(table.getValueFromCell(4, 1));
        System.out.println(table.getValueFromCell(4, "Company"));
        System.out.println(table.getValueFromCell(1, "Country"));
        System.out.println(table.getValueFromCell(2, "Contact"));

        // checking elements for being available
        chromeDriver.get("https://www.w3schools.com/html/html_tables.asp");
        WebElement tryBtn = chromeDriver.findElement(By.xpath("(//a[text()=\"Try it Yourself »\"])[1]"));
        if (tryBtn.isEnabled()) {
            System.out.println("You can click the button and try it yourself!");
        }
        chromeDriver.quit();
    }
}
