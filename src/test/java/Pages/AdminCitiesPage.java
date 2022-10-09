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
                                                   ////*[@id="app"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]
    protected By editButton = By.xpath("//*[@id=\"edit\"]/span/i");
    protected By searchField = By.id("search");
    protected By magnifyIconButton = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div/div[3]/div/i");
    protected By searchResultCityName = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]");
    protected By searchResultDeleteIcon = By.xpath("//*[@id=\"delete\"]/span/i");
    protected By warningMsgDeleteButton = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[2]/button[2]");
    protected By successDeleteMsg =By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    Faker faker = new Faker();
    protected final String cityName = faker.country().capital();

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

    public WebElement getSearchField() {
        return getDriver().findElement(searchField);
    }

    public WebElement getMagnifyIconButton() {
        return getDriver().findElement(magnifyIconButton);
    }

    public WebElement getSearchResultCityName() {
        return getDriver().findElement(searchResultCityName);
    }

    public WebElement getSearchResultDeleteIcon() {
        return getDriver().findElement(searchResultDeleteIcon);
    }

    public WebElement getWarningMsgDeleteButton() {
        return getDriver().findElement(warningMsgDeleteButton);
    }

    public WebElement getSuccessDeleteMsg() { return getDriver().findElement(successDeleteMsg); }

    public String getCityName() {
        return cityName;
    }

    //---------------------------------------------------
    public void clickNewItemButton(){
        getNewItemButton().click();
    }
    public void clickEditButton(){ getEditButton().click(); }
    public void clickSearchDeleteIcon(){getSearchResultDeleteIcon().click();}
    public void clickWarningMsgDeleteButton(){getWarningMsgDeleteButton().click();}
    public void newCityMethod(String name){
        getMsgNameField().sendKeys(name);
        getMsgSaveButton().click();
    }
    public void searchMethod(String name){
        getSearchField().sendKeys(name);
        getMagnifyIconButton().click();
    }
}
