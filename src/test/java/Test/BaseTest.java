package Test;

import Pages.*;
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
    protected AdminCitiesPage adminCitiesPage;
    protected MyProfilePage myProfilePage;

    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com/";
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeClass
    public void setup(){
    System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    homePage = new HomePage(driver, wait);
    loginPage = new LoginPage(driver, wait);
    signUpPage = new SignUpPage(driver, wait);
    adminCitiesPage = new AdminCitiesPage(driver, wait);
    myProfilePage = new MyProfilePage(driver, wait);
    }
    @AfterClass
    public void afterClass(){ driver.quit(); }
    @BeforeMethod
    public void beforeMethod(){ driver.get(baseUrl); }
}
