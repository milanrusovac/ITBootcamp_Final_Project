package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {
    protected By nameField = By.id("name");
    protected By emailField = By.id("email");
    protected By passwordField = By.id("password");
    protected By confirmPasswordField = By.id("confirmPassword");
    protected By singMeUpButton = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button/span");
    protected By errorMsg2 = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li");
    protected By infoMsg = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]");
    protected By infoMsgCloseButton = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[3]/button/span");
    protected By logoutButtonOnSignUpPage = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]/span");
    Faker faker = new Faker();
    protected String fakeEmail = faker.internet().emailAddress();

    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNameField() {
        return getDriver().findElement(nameField);
    }

    public WebElement getEmailField() {
        return getDriver().findElement(emailField);
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(passwordField);
    }

    public WebElement getConfirmPasswordField() {
        return getDriver().findElement(confirmPasswordField);
    }

    public WebElement getSingMeUpButton() {
        return getDriver().findElement(singMeUpButton);
    }

    public WebElement getErrorMsg2() {
        return getDriver().findElement(errorMsg2);
    }

    public WebElement getInfoMsg() {
        return getDriver().findElement(infoMsg);
    }

    public WebElement getInfoMsgCloseButton() {
        return getDriver().findElement(infoMsgCloseButton);
    }

    public String getFakeEmail() { return fakeEmail; }

    public WebElement getLogoutButtonOnSignUpPage() { return getDriver().findElement(logoutButtonOnSignUpPage); }

    //-----------------------------------------------------------------------------
    public void singUpMethod(String name, String email, String password, String confirmPassword){
        getEmailField().clear();
        getPasswordField().clear();
        getNameField().sendKeys(name);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().sendKeys(confirmPassword);
        getSingMeUpButton().click();
    }
    public void clickCloseInfoMsgButton(){getInfoMsgCloseButton().click();}
    public void clickLogoutButtonOnSignUpPage(){getLogoutButtonOnSignUpPage().click();}
}
