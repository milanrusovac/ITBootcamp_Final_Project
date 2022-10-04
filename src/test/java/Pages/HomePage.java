package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

private By loginButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]/span");

public HomePage(){

}
public HomePage(WebDriver driver) {
    super(driver); }

    public WebElement getLoginButton() {
        return getDriver().findElement(loginButton);
    }

    public void clickLoginButton(){
    getLoginButton().click();
    }







}
