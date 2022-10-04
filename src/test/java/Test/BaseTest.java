package Test;

import Pages.HomePage;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public abstract class BaseTest {
    protected HomePage homePage;


//private String baseUrl = "https://vue-demo.daniel-avellaneda.com/";
private WebDriver driver;
private WebDriverWait wait;



    @BeforeClass
    public void setup(){
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
    driver.get(("https://vue-demo.daniel-avellaneda.com/"));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    homePage = new HomePage(driver, wait);
    }

    @AfterClass
    public void afterClass(){
        //loginPage.getDriver().quit();
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://vue-demo.daniel-avellaneda.com/");
    }















}
