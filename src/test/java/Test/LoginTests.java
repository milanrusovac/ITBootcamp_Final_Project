package Test;

import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void visitsTheLoginPage(){
        homePage.clickLoginButton();
        String curentUrl = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertTrue(curentUrl.contains("login"));
    }
    @Test
    public void checksInputTypes(){

    }










}
