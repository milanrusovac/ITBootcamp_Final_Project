package Test;
/*Test #1: Visits the signup page
assert:
•	Verifikovati da se u url-u stranice javlja /signup ruta

Test #2: Checks input types
assert:
•	Verifikovati da polje za unos emaila za atribut type ima vrednost email
•	Verifikovati da polje za unos lozinke za atribut type ima vrednost password
•	Verifikovati da polje za unos lozinke za potvrdu za atribut type ima vrednost password

Test #3: Displays errors when user already exists
Podaci:
•	name: Test Test
•	email: admin@admin.com
•	password: 123654
•	confirm password: 123654
assert:
•	Verifikovati da greska sadrzi poruku E-mail already exists
•	Verifikovati da se u url-u stranice javlja /signup ruta

Test #4: Signup
Podaci:
•	name: Ime i prezime polaznika
•	email template: Signup - faker library email
•	password: 12346
•	confirm password: 123456
assert:
•	Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT: Verify your account
 */

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignupTest extends BaseTest{

    @Test (priority = 1)
    public void visitsTheSignupPage(){
        //Verifikovati da se u url-u stranice javlja /signup ruta
        homePage.clickSignUpButton();
        String expResult = driver.getCurrentUrl();
        Assert.assertTrue(expResult.contains("signup"));
    }
    @Test (priority = 2)
    public void checksInputTypes() {
    /*Verifikovati da polje za unos emaila za atribut type ima vrednost email
 	Verifikovati da polje za unos lozinke za atribut type ima vrednost password
	Verifikovati da polje za unos lozinke za potvrdu za atribut type ima vrednost password
     */
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
    @Test (priority = 3)
    public void displaysErrorsWhenUserAlreadyExists(){
        /*name: Test Test
        email: admin@admin.com
    	password: 123654
    	confirm password: 123654
        assert:
        Verifikovati da greska sadrzi poruku E-mail already exists
        Verifikovati da se u url-u stranice javlja /signup ruta
         */
        homePage.clickSignUpButton();
        signUpPage.singUpMethod("Test Test","admin@admin.com", "123654", "123654");
        Assert.assertTrue(signUpPage.getErrorMsg2().getText().contains("E-mail already exists"));
        String  expResult = "signup";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expResult));
    }
    @Test (priority = 4)
    public void signup() throws InterruptedException {
        /*Podaci:
        name: Ime i prezime polaznika
        email template: Signup - faker library email
        password: 123456
        confirm password: 123456
        assert:
        Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT: Verify your account
         */
        homePage.clickSignUpButton();
        signUpPage.singUpMethod("Milan Rusovac",signUpPage.fakeEmailMethod(), "123456", "123456");
        String expResult = "IMPORTANT: Verify your account";
        Thread.sleep(3000);
        String actualResult = signUpPage.getInfoMsg().getText();
        Assert.assertTrue(actualResult.contains(expResult));
    }

}








