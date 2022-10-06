package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {

    protected By loginButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]/span");
    protected By logoutButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span");
    protected By signUpButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]/span");
    protected By adminButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]/span");
    protected By citiesButton = By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]"); // //*[@id="list-item-117"]/div[2]

    public HomePage(){

}
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait); }

    public WebElement getLoginButton() {
        return getDriver().findElement(loginButton);
    }

    public WebElement getLogoutButton() { return getDriver().findElement(logoutButton); }

    public WebElement getSignUpButton() {return getDriver().findElement(signUpButton); }

    public WebElement getAdminButton() {
        return getDriver().findElement(adminButton);
    }

    public WebElement getCitiesButton() {
        return getDriver().findElement(citiesButton);
    }

    //--------------------------------------------------------------------
    public void clickLoginButton(){
    getLoginButton().click();
    }
    public void clickLogoutButton(){ getLogoutButton().click(); }
    public void clickSignUpButton(){ getSignUpButton().click(); }
    public void clickAdminButton(){getAdminButton().click(); }
    public void clickCitiesButton(){getCitiesButton().click(); }
    public void checkIfLogin() {
        WebElement logoutButton = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span"));
        if (logoutButton.isDisplayed()) {
            logoutButton.click();
        }
    }






}
