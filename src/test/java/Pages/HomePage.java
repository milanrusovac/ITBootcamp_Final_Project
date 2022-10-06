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
    protected By citiesButton = By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]");
    protected By languageMenuButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button/span");
    protected By headerMsg = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");
    protected By esButton = By.xpath("//*[@id=\"list-item-75\"]/div");
    protected By enButton = By.xpath("//*[@id=\"list-item-73\"]/div");
    protected By frbutton = By.xpath("//*[@id=\"list-item-77\"]/div");


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

    public WebElement getLanguageMenuButton() {
        return getDriver().findElement(languageMenuButton);
    }

    public WebElement getHeaderMsg() {
        return getDriver().findElement(headerMsg);
    }

    public WebElement getEsButton() {
        return getDriver().findElement(esButton);
    }

    public WebElement getEnButton() {
        return getDriver().findElement(enButton);
    }

    public WebElement getFrButton() {
        return getDriver().findElement(frbutton);
    }

    //--------------------------------------------------------------------
    public void clickLoginButton(){getLoginButton().click();}
    public void clickLogoutButton(){getLogoutButton().click();}
    public void clickSignUpButton(){getSignUpButton().click();}
    public void clickAdminButton(){getAdminButton().click();}
    public void clickCitiesButton(){getCitiesButton().click();}
    public void clickLanguageMenuButton(){getLanguageMenuButton().click();}
    public void clickEsButton(){getEsButton().click();}
    public void clickEnButton(){getEnButton().click();}
    public void clickFrButton(){getFrButton().click();}
    public void checkIfLogin() {
        WebElement logoutButton = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span"));
        if (logoutButton.isDisplayed()) {
            logoutButton.click();
        }
    }






}
