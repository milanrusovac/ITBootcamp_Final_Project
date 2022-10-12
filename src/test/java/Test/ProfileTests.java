package Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class ProfileTests extends BaseTest{

    /**Data: random data using the faker library
     assert:
     Verify that the message Profile saved successfully is displayed
     Verify that each input now for the value attribute has the value entered within the form
     */
    @Test
    public void editsProfile(){
        homePage.clickLoginButton();
        loginPage.loginMethod("admin@admin.com", "12345" );
        homePage.clickMyProfileButton();

        myProfilePage.getCityField().click();
        wait.withTimeout(Duration.ofSeconds(3));
        myProfilePage.getListFirstCity().click();

        myProfilePage.editProfile(myProfilePage.getFakeName(), myProfilePage.getFakePhone(), myProfilePage.getFakeCountry(),
                                    myProfilePage.getFakeTwitter(), myProfilePage.getFakeGitHub());

        String actualResult = myProfilePage.getSuccessMsg().getText();
        Assert.assertTrue(actualResult.contains("Profile saved successfuly"));

        String expNameField = myProfilePage.getFakeName();
        String actualNameField = myProfilePage.getNameField().getAttribute("value");
        Assert.assertEquals(actualNameField, expNameField);

        String expPhoneField = myProfilePage.getFakePhone();
        String actualPhoneField = myProfilePage.getPhoneField().getAttribute("value");
        Assert.assertEquals(actualPhoneField,expPhoneField);

        String expCountryField = myProfilePage.getFakeCountry();
        String actualCountryField = myProfilePage.getCountryField().getAttribute("value");
        Assert.assertEquals(actualCountryField, expCountryField);

        String expTwitterField = myProfilePage.getFakeTwitter();
        String actualTwitterField = myProfilePage.getTwitterField().getAttribute("value");
        Assert.assertEquals(actualTwitterField, expTwitterField);

        String expGitHubField = myProfilePage.getFakeGitHub();
        String actualGitHubField = myProfilePage.getGitHubField().getAttribute("value");
        Assert.assertEquals(actualGitHubField, expGitHubField);

        homePage.checkIfLogin();
    }
}
