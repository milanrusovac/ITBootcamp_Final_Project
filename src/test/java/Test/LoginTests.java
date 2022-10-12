package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    /**Verify that the route /login appears in the url of the page
     */
    @Test (priority = 1)
    public void visitsTheLoginPage(){
        homePage.clickLoginButton();
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("login"));
    }
     /**Verify that the email input field for the type attribute has the value email
      Verify that the password input field for the type attribute has the value password
      */
    @Test (priority = 2)
    public void checksInputTypes(){
        homePage.clickLoginButton();
        String expResult = "email";
        String actualResult = loginPage.getEmailField().getAttribute("type");
        Assert.assertEquals(actualResult, expResult);
        String expResult2 = "password";
        String actualResult2 = loginPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(actualResult2, expResult2);
    }

    /**Data: random email and password using faker library
     assert:
     Verify that the error contains the message User does not exist
     Verify that the /login route appears in the url of the page
     */
    @Test (priority = 3)
    public void displaysErrorsWhenUserDoesNotExist(){
        homePage.clickLoginButton();
        loginPage.loginMethod(loginPage.getFakeEmail(), loginPage.getFakePassword());
        String actualResult1 = loginPage.getErrorMsg().getText();
        Assert.assertTrue(actualResult1.contains("User does not exists"));
        String actualResult2 = loginPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult2.contains("login"));
    }
    /**Data: email: admin@admin.com and arbitrary password
     assert:
     Verify that the error contains the message Wrong password
     Verify that the /login route appears in the url of the page
     */
    @Test (priority = 4)
    public void displaysErrorsWhenPasswordIsWrong(){
        homePage.clickLoginButton();
        loginPage.loginMethod("admin@admin.com", loginPage.getFakePassword());
        String actualResult1 = loginPage.getErrorMsg().getText();
        Assert.assertTrue(actualResult1.contains("Wrong password"));
        String actualResult2 = loginPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult2.contains("login"));
    }
    /**Data: email: admin@admin.com, password: 12345
     assert:
     Verify that the /home route appears in the url of the page
     */
    @Test (priority = 5)
    public void login() throws InterruptedException {
        homePage.clickLoginButton();
        loginPage.loginMethod("admin@admin.com", "12345" );
        Thread.sleep(2000);
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("home"));
        homePage.checkIfLogin();
    }
    /**assert:
     Verify that the logout button is visible on the page
     Verify that the /login route appears in the url of the page
     Verify that after attempting to open the /home route,
     the /login route appears in the url of the page
     (open with driver.get home page and check if it redirects you to login)
     */
    @Test (priority = 6)
    public void logout(){
        homePage.clickLoginButton();
        loginPage.loginMethod("admin@admin.com", "12345" );
        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());
        homePage.clickLogoutButton();
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("login"));

        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String actualResult2 = driver.getCurrentUrl();
        Assert.assertTrue(actualResult2.contains("login"));
    }
}
