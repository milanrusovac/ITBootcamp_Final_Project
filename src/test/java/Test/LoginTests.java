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

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


public class LoginTests extends BaseTest {

    @Test (priority = 1)
    public void visitsTheLoginPage(){
        //Verifikovati da se u url-u stranice javlja ruta /login
        homePage.clickLoginButton();
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("login"));
    }
    @Test (priority = 2)
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
    @Test (priority = 3)
    public void displaysErrorsWhenUserDoesNotExist(){
       /*Podaci: random email i password koristeći faker libarary
       asssert:
       Verifikovati da greska sadrzi poruku User does not exists
       Verifikovati da se u url-u stranice javlja /login ruta
         */
        homePage.clickLoginButton();
        loginPage.loginMethod(loginPage.getFakeEmail(), loginPage.getFakePassword());
        String actualResult1 = loginPage.getErrorMsg().getText();
        Assert.assertTrue(actualResult1.contains("User does not exists"));
        String actualResult2 = loginPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult2.contains("login"));
    }
    @Test (priority = 4)
    public void displaysErrorsWhenPasswordIsWrong(){
        /*Podaci: email: admin@admin.com i proizvoljan password
        asssert:
        Verifikovati da greska sadrzi poruku Wrong password
        Verifikovati da se u url-u stranice javlja /login ruta
         */
        homePage.clickLoginButton();
        loginPage.loginMethod("admin@admin.com", loginPage.getFakePassword());
        String actualResult1 = loginPage.getErrorMsg().getText();
        Assert.assertTrue(actualResult1.contains("Wrong password"));
        String actualResult2 = loginPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult2.contains("login"));
    }
    @Test (priority = 5)
    public void login() throws InterruptedException {
        /*Podaci: email: admin@admin.com, password: 12345
        asssert:
        Verifikovati da se u url-u stranice javlja /home ruta
         */
        homePage.clickLoginButton();
        loginPage.loginMethod("admin@admin.com", "12345" );
        Thread.sleep(2000);
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("home"));
        homePage.checkIfLogin();
    }
    @Test (priority = 6)
    public void Logout(){
        /*assert:
        Verifikovati da je dugme logout vidljivo na stranici
        Verifikovati da se u url-u stranice javlja /login ruta
        Verifikovati da se nakon pokušaja otvaranja /home rute,
        u url-u stranice javlja /login ruta
        (otvoriti sa driver.get home page i proveriti da li vas redirektuje na login)
         */
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
