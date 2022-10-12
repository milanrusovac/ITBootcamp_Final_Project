package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest{

    /**Verifikovati da se u url-u stranice javlja /signup ruta
     */
    @Test
    public void visitsTheSignupPage(){
        homePage.clickSignUpButton();
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("signup"));
    }
    /**each input now for the value attribute has the value entered in the form field
     Verify that the email input field for the type attribute has the value email
     Verify that the password input field for the type attribute has the value password
     Verify that the confirmation password input field for the type attribute has the value password
     */
    @Test
    public void checksInputTypes() {
        homePage.clickSignUpButton();
        String expResult = "email";
        String actualResult = signUpPage.getEmailField().getAttribute("type");
        Assert.assertEquals(actualResult, expResult);
        String expResult2 = "password";
        String actualResult2 = signUpPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(actualResult2, expResult2);
        String expResult3 = "password";
        String actualResult3 = signUpPage.getConfirmPasswordField().getAttribute("type");
        Assert.assertEquals(actualResult3, expResult3);
    }
    /**name: Test Test
     email: admin@admin.com
     password: 123654
     confirm password: 123654
     assert:
     Verify that the error contains the message E-mail already exists
     Verify that the /signup route appears in the url of the page
     */
    @Test
    public void displaysErrorsWhenUserAlreadyExists(){
        homePage.clickSignUpButton();
        signUpPage.singUpMethod("Test Test","admin@admin.com", "123654", "123654");
        String actualResult = signUpPage.getErrorMsg2().getText();
        Assert.assertTrue(actualResult.contains("E-mail already exists"));
        String actualResult2 = driver.getCurrentUrl();
        Assert.assertTrue(actualResult2.contains("signup"));
    }
    /**Data:
     name: Name and surname of the participant
     email template: Signup - faker library email
     password: 123456
     confirm password: 123456
     assert:
     Verify that the notification dialog contains the text IMPORTANT: Verify your account
     */
    @Test
    public void signup(){
        homePage.clickSignUpButton();
        signUpPage.singUpMethod("Milan Rusovac", signUpPage.getFakeEmail(), "123456", "123456");
        String expResult = "IMPORTANT: Verify your account";
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"),"IMPORTANT: Verify your account"));
        String actualResult = signUpPage.getInfoMsg().getText();
        Assert.assertTrue(actualResult.contains(expResult));
        signUpPage.clickCloseInfoMsgButton();
        signUpPage.clickLogoutButtonOnSignUpPage();
    }
}








