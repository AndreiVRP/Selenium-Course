package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;
    //    private By signInButton = By.xpath("//a[contains(@href,\"login\")]");
//    private By signUpButton = By.xpath("//div[contains(@class,\"Header\")]//a[contains(@href,\"join\")]");
    private By userNameField = By.xpath("//input[@name=\"user[login]\"]");
    private By emailField = By.xpath("//input[@name=\"user[email]\"]");
    private By passwordField = By.xpath("//input[@name=\"user[password]\"]");
    private By createAccountButton = By.xpath("//button[@type=\"submit\"]");
    private By heading = By.xpath("//h1");
    private By mainError = By.xpath("//form//div[contains(@class,\"flash-error\")]");
    private By usernameError = By.xpath("//auto-check[contains(@src,\"username\")]//dd[@class=\"error\"]");
    private By emailError = By.xpath("//auto-check[contains(@src,\"email\")]//dd[@class=\"error\"]");
    private By passwordError = By.xpath("//password-strength//dd[@class=\"error\"]");


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignUpPage typeUserName(String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage registerWithInvalidCreds(String username, String email, String password) {
        typeUserName(username);
        typeEmail(email);
        typePassword(password);
        driver.findElement(createAccountButton).click();
        return new SignUpPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getUsernameErrorText() {
        return driver.findElement(usernameError).getText();
    }

    public String getEmailErrorText() {
        return driver.findElement(emailError).getText();
    }

    public String getPasswordErrorText() {
        return driver.findElement(passwordError).getText();
    }

    public String getMainErrorText() {
        return driver.findElement(mainError).getText();
    }
}
