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

        myProfilePage.editProfile(myProfilePage.fakeNameMethod(), myProfilePage.fakePhoneMethod(), myProfilePage.fakeCountryMethod(),
                "http://"+myProfilePage.fakeTwitterMethod()+".name", "http://"+myProfilePage.fakeGitHubMethod()+".biz");

        String expResult = "Profile saved successfuly";
        String actualResult = myProfilePage.getSuccessMsg().getText();
        Assert.assertTrue(actualResult.contains(expResult));

        String expNameField = "text";
        String actualNameField = myProfilePage.getNameField().getAttribute("type");
        Assert.assertEquals(actualNameField, expNameField);
        String expPhoneField = "tel";
        String actualPhoneField = myProfilePage.getPhoneField().getAttribute("type");
        Assert.assertEquals(actualPhoneField,expPhoneField);
        String expCityField = "text";
        String actualCityField = myProfilePage.getCityField().getAttribute("type");
        Assert.assertEquals(actualCityField, expCityField);
        String expCountryField = "text";
        String actualCountryField = myProfilePage.getCountryField().getAttribute("type");
        Assert.assertEquals(actualCountryField, expCountryField);
        String expTwitterField = "url";
        String actualTwitterField = myProfilePage.getTwitterField().getAttribute("type");
        Assert.assertEquals(actualTwitterField, expTwitterField);
        String expGitHubField = "url";
        String actualGitHubField = myProfilePage.getGitHubField().getAttribute("type");
        Assert.assertEquals(actualGitHubField, expGitHubField);
    }
}
