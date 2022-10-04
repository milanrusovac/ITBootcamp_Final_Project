package Test;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class BaseTest {
    private HomePage homePage;

/*
private String baseUrl = "https://vue-demo.daniel-avellaneda.com/";
private WebDriver driver;
private WebDriver webDriverWait;

 */

    @BeforeClass
    public void setup(){
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    homePage = new HomePage(driver);

}
    @AfterClass
    public void afterClass(){
        //loginPage.getDriver().quit();
    }
    @BeforeMethod
    public void beforeMethod(){
        homePage.getDriver().get("https://vue-demo.daniel-avellaneda.com/");
    }

    @Test
    public void visitsTheLoginPage(){
        homePage.clickLoginButton();
        String expResult = "https://vue-demo.daniel-avellaneda.com/login";
        //String actualResult = homePage.getDriver().getCurentUrl();


    }












}
