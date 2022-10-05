package Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignUpPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public abstract class BaseTest {
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected SignUpPage signUpPage;

    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com/";
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeClass
    public void setup(){
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
    //driver.get(("https://vue-demo.daniel-avellaneda.com/"));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    homePage = new HomePage(driver, wait);
    loginPage = new LoginPage(driver, wait);
    signUpPage = new SignUpPage(driver, wait);


    }
    @AfterClass
    public void afterClass(){
        //driver.quit();

    }
    @BeforeMethod
    public void beforeMethod(){
        driver.get(baseUrl);
    }















}
