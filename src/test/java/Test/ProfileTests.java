package Test;
/*Test #1: Edits profile
Podaci: random podaci korišćenjem faker library-ja
assert:
•	Verifikovati da je prikazana poruka Profile saved successfuly
•	Verifikovati da svaki input sada za value atribut ima vrednost koja je uneta u okviru forme
     */

import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class ProfileTests extends BaseTest{
    @Test
    public void editsProfile(){
        /*Podaci: random podaci korišćenjem faker library-ja
        assert:
        Verifikovati da je prikazana poruka Profile saved successfuly
    	Verifikovati da svaki input sada za value atribut ima vrednost koja je uneta u okviru forme
         */
        homePage.clickThemeButton();
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
    }
}
