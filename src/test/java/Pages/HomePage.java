package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    protected By loginButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]/span");

    public HomePage(){

}
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait); }

    public WebElement getLoginButton() {
        return getDriver().findElement(loginButton);
    }
//--------------------------------------------------------------------
    public void clickLoginButton(){
    getLoginButton().click();
    }







}
