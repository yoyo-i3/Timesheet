package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@aria-label='Username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(id = "goButton")
    private WebElement signInButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        FluentWait wait = new FluentWait( driver).
                withTimeout(Duration.ofSeconds(5)).
                pollingEvery(Duration.ofSeconds(1)).
                ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@role='form']"))));
    }

    public void setUsernameField(String username) {
        usernameField.sendKeys(username);
    }

    public void setPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSignIn(){
        signInButton.click();
    }

    public void signIn(String username, String password){
        setUsernameField(username);
        setPasswordField(password);
        clickSignIn();
    }

    public void signIn(){
        signIn(System.getProperty("user.username"),
                System.getProperty("user.password"));
    }

}
