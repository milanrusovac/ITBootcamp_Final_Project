package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfilePage extends BasePage {
    protected By nameField = By.id("name"); //text
    protected By phoneField = By.id("phone"); //tel
    protected By cityField = By.id("city"); //text
    protected By countryField = By.id("country"); //text
    protected By twitterField = By.id("urlTwitter"); //url
    protected By gitHubField = By.id("urlGitHub"); //url
    protected By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");
    protected By listFirstCity = By.xpath("//*[@id=\"list-item-163-1\"]/div/div");
    protected By successMsg = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div");
    Faker faker = new Faker();
    public MyProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNameField() {return getDriver().findElement(nameField);}

    public WebElement getPhoneField() {return getDriver().findElement(phoneField);}

    public WebElement getCityField() {return getDriver().findElement(cityField);}

    public WebElement getCountryField() {return getDriver().findElement(countryField);}

    public WebElement getTwitterField() {return getDriver().findElement(twitterField);}

    public WebElement getGitHubField() {return getDriver().findElement(gitHubField);}

    public WebElement getSaveButton() {return getDriver().findElement(saveButton);}

    public WebElement getListFirstCity() {return getDriver().findElement(listFirstCity);}

    public WebElement getSuccessMsg() {return getDriver().findElement(successMsg);}
    //----------------------------------------------------------
    public void editProfile(String name, String phone, String country, String twitter, String gitHub){

        getNameField().click();
        getNameField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getNameField().sendKeys(name);

        getPhoneField().click();
        getPhoneField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getPhoneField().sendKeys(phone);

        getCountryField().click();
        getCountryField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getCountryField().sendKeys(country);

        getTwitterField().click();
        getTwitterField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getTwitterField().sendKeys(twitter);

        getGitHubField().click();
        getGitHubField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getGitHubField().sendKeys(gitHub);

        getSaveButton().click();
    }
    public String fakeNameMethod(){return faker.name().fullName();}
    public String fakePhoneMethod(){return faker.phoneNumber().phoneNumber();}
    public String fakeCountryMethod(){return faker.country().name();}
    public String fakeTwitterMethod(){return faker.name().firstName().toLowerCase();}
    public String fakeGitHubMethod(){return faker.name().firstName().toLowerCase();}
}
