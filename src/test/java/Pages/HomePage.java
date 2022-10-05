package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    protected By loginButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]/span");
    protected By logoutButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span");
    protected By signUpButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]/span");

    public HomePage(){

}
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait); }

    public WebElement getLoginButton() {
        return getDriver().findElement(loginButton);
    }

    public WebElement getLogoutButton() { return getDriver().findElement(logoutButton); }

    public WebElement getSignUpButton() {return getDriver().findElement(signUpButton); }

    //--------------------------------------------------------------------
    public void clickLoginButton(){
    getLoginButton().click();
    }
    public void clickLogoutButton(){ getLogoutButton().click(); }
    public void clickSignUpButton(){ getSignUpButton().click(); }






}
