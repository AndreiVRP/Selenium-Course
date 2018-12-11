package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    WebDriver driver;

    //Page Factory
    @FindBy(xpath = "//a[contains(@href,\"login\")]")
    private WebElement signInButton;

    @FindBy(xpath = "//div[contains(@class,\"Header\")]//a[contains(@href,\"join\")]")
    private WebElement signUpButton;

    @FindBy(xpath = "//div[contains(@class,\"rounded\")]//input[@name=\"user[login]\"]")
    private WebElement userNameField;

    @FindBy(xpath = "//div[contains(@class,\"rounded\")]//input[@name=\"user[email]\"]")
    private WebElement emailField;

    @FindBy(xpath = "//div[contains(@class,\"rounded\")]//input[@name=\"user[password]\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//div[contains(@class,\"rounded\")]//button")
    private WebElement signUpForGitHubButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LogInPage clickSignIn() {
        signInButton.click();
        return new LogInPage(driver);
    }

    public SignUpPage clickSignUp() {
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpForGitHubButton() {
        signUpForGitHubButton.click();
        return new SignUpPage(driver);
    }

    public HomePage typeUserName(String username) {
        userNameField.sendKeys(username);
        return this;
    }

    public HomePage typeEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public HomePage typePassword(String password) {
        passwordField.sendKeys(password);
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
