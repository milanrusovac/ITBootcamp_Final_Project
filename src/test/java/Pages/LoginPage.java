package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    protected By emailField = By.id("email");
    protected By passwordField = By.id("password");
    protected By loginButton2 = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span");
    protected By errorMsg = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li");
    Faker faker = new Faker();
    protected String fakeEmail = faker.internet().emailAddress();
    protected String fakePassword = faker.internet().password();

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmailField() {
        return getDriver().findElement(emailField);
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(passwordField);
    }

    public WebElement getLoginButton2() {
        return getDriver().findElement(loginButton2);
    }

    public WebElement getErrorMsg() {
        return getDriver().findElement(errorMsg);
    }

    //public String getFakeEmail() {return fakeEmail; }

    public String getFakeEmail() { return fakeEmail; }

    public String getFakePassword() { return fakePassword; }

    //---------------------------------------------------------------
    public void loginMethod(String email, String password) {
        getEmailField().clear();
        getPasswordField().clear();
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getLoginButton2().click();
    }
}
