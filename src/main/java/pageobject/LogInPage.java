package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
    WebDriver driver;
    private By usernameField = By.xpath("//input[@name=\"login\"]");
    private By passwordField = By.xpath("//input[@name=\"password\"]");
    private By signInButton = By.xpath("//input[@name=\"commit\"]");
    private By heading = By.xpath("//h1");
    private By error = By.xpath("//div[@class=\"container\"]");
    private By createAccount = By.xpath("//a[text()=\"Create an account\"]");


    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public LogInPage typeUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public LogInPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getErrorText() {
        return driver.findElement(error).getText();
    }

    public LogInPage loginWithInvalidCreds(String username, String password) {
        typeUsername(username);
        typePassword(password);
        driver.findElement(signInButton).click();
        return new LogInPage(driver);
    }

    public SignUpPage clickCreateAccount() {
        driver.findElement(createAccount).click();
        return new SignUpPage(driver);
    }


}
