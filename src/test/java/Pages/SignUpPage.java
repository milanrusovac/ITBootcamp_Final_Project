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
    Faker faker = new Faker();

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
    public String fakeEmailMethod(){
        String fakeEmail = faker.internet().emailAddress();
        return fakeEmail;
    }


}
