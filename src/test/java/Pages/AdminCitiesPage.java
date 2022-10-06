package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage{
    protected By newItemButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button/span");
    protected By msgNameField = By.id("name");
    protected By msgSaveButton =By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]/span");
    protected By successMsg = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    protected By editButton = By.xpath("//*[@id=\"edit\"]/span/i");

    Faker faker = new Faker();

    public AdminCitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNewItemButton() {
        return getDriver().findElement(newItemButton);
    }

    public WebElement getMsgNameField() { return getDriver().findElement(msgNameField); }

    public WebElement getMsgSaveButton() {
        return getDriver().findElement(msgSaveButton);
    }

    public WebElement getSuccessMsg() {
        return getDriver().findElement(successMsg);
    }
    public WebElement getEditButton() { return getDriver().findElement(editButton); }

    //---------------------------------------------------
    public void clickNewItemButton(){
        getNewItemButton().click();
    }
    public void newCityMethod(String name){

        getMsgNameField().sendKeys(name);
        getMsgSaveButton().click();
    }
    public void clickEditButton(){ getEditButton().click(); }

    public String fakeCityName(){
        String fakeCityName = faker.country().capital();
        return fakeCityName;
    }


}
