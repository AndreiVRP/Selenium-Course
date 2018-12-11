package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    private By signInButton = By.xpath("//a[contains(@href,\"login\")]");
    private By signUpButton = By.xpath("//div[contains(@class,\"Header\")]//a[contains(@href,\"join\")]");
    private By userNameField = By.xpath("//div[contains(@class,\"rounded\")]//input[@name=\"user[login]\"]");
    private By emailField = By.xpath("//div[contains(@class,\"rounded\")]//input[@name=\"user[email]\"]");
    private By passwordField = By.xpath("//div[contains(@class,\"rounded\")]//input[@name=\"user[password]\"]");
    private By signUpForGitHubButton = By.xpath("//div[contains(@class,\"rounded\")]//button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LogInPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new LogInPage(driver);
    }

    public SignUpPage clickSignUp() {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpForGitHubButton() {
        driver.findElement(signUpForGitHubButton).click();
        return new SignUpPage(driver);
    }

    public HomePage typeUserName(String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public HomePage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public HomePage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage register(String username, String email, String password) {
        typeUserName(username);
        typeEmail(email);
        typePassword(password);
        clickSignUpForGitHubButton();
        return new SignUpPage(driver);
    }

}
