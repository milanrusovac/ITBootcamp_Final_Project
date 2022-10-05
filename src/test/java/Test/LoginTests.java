package Test;
/*Test #1: Visits the login page
assert:
•	Verifikovati da se u url-u stranice javlja ruta /login
Test #2: Checks input types
assert:
•	Verifikovati da polje za unos emaila za atribut type ima vrednost email
•	Verifikovati da polje za unos lozinke za atribut type ima vrednost password
Test #3: Displays errors when user does not exist
Podaci: random email i password koristeći faker libarary
asssert:
•	Verifikovati da greska sadrzi poruku User does not exists
•	Verifikovati da se u url-u stranice javlja /login ruta
Test #4: Displays errors when password is wrong
Podaci: random email i password koristeći faker libarary
asssert:
•	Verifikovati da greska sadrzi poruku Wrong password
•	Verifikovati da se u url-u stranice javlja /login ruta
Test #5: Login
Podaci:
•	email: admin@admin.com
•	password: 12345
asssert:
•	Verifikovati da se u url-u stranice javlja /home ruta
Test #6: Logout
assert:
•	Verifikovati da je dugme logout vidljivo na stranici
•	Verifikovati da se u url-u stranice javlja /login ruta
•	Verifikovati da se nakon pokušaja otvaranja /home rute, u url-u stranice javlja /login ruta
 */

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;


public class LoginTests extends BaseTest {

    @Test
    public void visitsTheLoginPage(){
        //Verifikovati da se u url-u stranice javlja ruta /login

        homePage.clickLoginButton();
        Assert.assertTrue(loginPage.getDriver().getCurrentUrl().contains("login"));
    }

    @Test
    public void checksInputTypes(){
        /*Verifikovati da polje za unos emaila za atribut type ima vrednost email
        Verifikovati da polje za unos lozinke za atribut type ima vrednost password
        */
        homePage.clickLoginButton();
        String expResult = "email";
        String actualResult = loginPage.getEmailField().getAttribute("type");
        Assert.assertEquals(actualResult, expResult);
        String expResult2 = "password";
        String actualResult2 = loginPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(actualResult2, expResult2);
    }
    @Test
    public void displaysErrorsWhenUserDoesNotExist(){
       /*Podaci: random email i password koristeći faker libarary
       asssert:
       Verifikovati da greska sadrzi poruku User does not exists
       Verifikovati da se u url-u stranice javlja /login ruta
         */
        homePage.clickLoginButton();
        Faker faker = new Faker();
        String emailFake = faker.internet().emailAddress();
        String passwordFake = faker.internet().password();
        loginPage.loginFaker(emailFake, passwordFake);
        Assert.assertTrue(loginPage.getErrorMsg().getText().contains("User does not exists"));
        Assert.assertTrue(loginPage.getDriver().getCurrentUrl().contains("login"));
    }
    @Test
    public void displaysErrorsWhenPasswordIsWrong(){
        /*Podaci: random email i password koristeći faker libarary
        asssert:
        Verifikovati da greska sadrzi poruku Wrong password
        Verifikovati da se u url-u stranice javlja /login ruta
         */
        homePage.clickLoginButton();
        Faker faker = new Faker();
        String passwordFake = faker.internet().password();
        loginPage.loginFaker("admin@admin.com", passwordFake);
        Assert.assertTrue(loginPage.getErrorMsg().getText().contains("Wrong password"));
        Assert.assertTrue(loginPage.getDriver().getCurrentUrl().contains("login"));

    }






// admin@admin.com



}
