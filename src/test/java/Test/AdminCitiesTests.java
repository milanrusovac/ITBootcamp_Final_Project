package Test;
/*Test #1: Visits the admin cities page and list cities
Podaci:
•	admin email: admin@admin.com
•	admin password: 12345
assert:
•	Verifikovati da se u url-u stranice javlja /admin/cities ruta
•	Verifikovati postojanje logut dugmeta

Test #2: Create new city
Podaci: random grad korisćenjem faker library-ja
assert:
•	Verifikovati da poruka sadrzi tekst Saved successfully

Test #3: Edit city
Podaci: edituje se grad koji je u testu 2 kreiran na isto ime + - edited (primer: Beograd – Beograd edited)
assert:
•	Verifikovati da poruka sadrzi tekst Saved successfully

Test #4: Search city
Podaci: editovani grad iz testa #3
assert:
•	Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage

Test #5: Delete city
Podaci: editovani grad iz testa #3
assert:
•	U polje za pretragu uneti staro ime grada
•	Sacekati da broj redova u tabeli bude 1
•	Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
•	Kliknuti na dugme Delete iz prvog reda
•	Sacekati da se dijalog za brisanje pojavi
•	Kliknuti na dugme Delete iz dijaloga
•	Sacekati da popu za prikaz poruke bude vidljiv
•	Verifikovati da poruka sadrzi tekst Deleted successfully
 */

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminCitiesTests extends BaseTest{

    @Test (priority = 1)
    public void visitsTheAdminCitiesPageAndListCities(){
        /*admin email: admin@admin.com
    	admin password: 12345
        assert:
    	Verifikovati da se u url-u stranice javlja /admin/cities ruta
    	Verifikovati postojanje logut dugmeta
         */
        homePage.clickLoginButton();
        loginPage.loginMethod("admin@admin.com", "12345" );
        homePage.clickAdminButton();
        homePage.clickCitiesButton();
        String expResult = "admin/cities";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expResult));
        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());
        homePage.checkIfLogin();
    }
    @Test (priority = 2)
    public void createNewCity(){
        /*Podaci: random grad korisćenjem faker library-ja
        assert:
     	Verifikovati da poruka sadrzi tekst Saved successfully
         */
        homePage.clickLoginButton();
        loginPage.loginMethod("admin@admin.com", "12345" );
        homePage.clickAdminButton();
        homePage.clickCitiesButton();

        adminCitiesPage.checkRio();

        adminCitiesPage.clickNewItemButton();
        wait.withTimeout(Duration.ofSeconds(3));
        adminCitiesPage.newCityMethod(adminCitiesPage.getCityName());
        String  expResult = "Saved successfully";
        String actualResult = adminCitiesPage.getSuccessMsg().getText();
        wait.withTimeout(Duration.ofSeconds(3));
        Assert.assertTrue(actualResult.contains(expResult));
        homePage.checkIfLogin();
    }
    @Test (dependsOnMethods = {"createNewCity"})
    public void editCity(){
        /*Podaci: edituje se grad koji je u testu 2 kreiran na isto ime + - edited (primer: Beograd – Beograd edited)
        assert:
    	Verifikovati da poruka sadrzi tekst Saved successfully
         */

        homePage.clickLoginButton();
        loginPage.loginMethod("admin@admin.com", "12345" );
        homePage.clickAdminButton();
        homePage.clickCitiesButton();

        adminCitiesPage.clickEditButton();
        //String cityNameEdited = adminCitiesPage.getMsgNameField().getText() + " - edited";
        wait.withTimeout(Duration.ofSeconds(3));
        //adminCitiesPage.getMsgNameField().clear();
        adminCitiesPage.getMsgNameField().click();
        adminCitiesPage.getMsgNameField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        adminCitiesPage.newCityMethod(adminCitiesPage.getCityNameEdited());
        homePage.checkIfLogin();

    }
    @Test (dependsOnMethods = {"createNewCity", "editCity"} )
    public void searchCity(){
        /*Podaci: editovani grad iz testa #3
        assert:
     	Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
         */
        homePage.clickLoginButton();
        loginPage.loginMethod("admin@admin.com", "12345" );
        homePage.clickAdminButton();
        homePage.clickCitiesButton();
        adminCitiesPage.searchMethod("Rio - edited");
        String expResult = "Rio - edited";
        String actualResult = adminCitiesPage.getSearchResultCityName().getText();
        wait.withTimeout(Duration.ofSeconds(3));
        Assert.assertEquals(actualResult, expResult);
        homePage.checkIfLogin();
    }

    @Test (dependsOnMethods = {"createNewCity", "editCity"} )
    public void deleteCity(){
        /*Podaci: editovani grad iz testa #3
        assert:
    	U polje za pretragu uneti staro ime grada
    	Sacekati da broj redova u tabeli bude 1
    	Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
    	Kliknuti na dugme Delete iz prvog reda
    	Sacekati da se dijalog za brisanje pojavi
    	Kliknuti na dugme Delete iz dijaloga
    	Sacekati da popu za prikaz poruke bude vidljiv
    	Verifikovati da poruka sadrzi tekst Deleted successfully
         */
        homePage.clickLoginButton();
        loginPage.loginMethod("admin@admin.com", "12345" );
        homePage.clickAdminButton();
        homePage.clickCitiesButton();

        adminCitiesPage.searchMethod("Rio");
        String expResult = "Rio";
        String actualResult = adminCitiesPage.getSearchResultCityName().getText();
        wait.withTimeout(Duration.ofSeconds(3));
        Assert.assertTrue(actualResult.contains(expResult));
        adminCitiesPage.clickSearchDeleteIcon();
        adminCitiesPage.clickWarningMsgDeleteButton();
        wait.withTimeout(Duration.ofSeconds(3));
        String expResult2 = " Deleted successfully ";
        String actualResult2 = adminCitiesPage.getSuccessDeleteMsg().getText();
        //Assert.assertTrue(actualResult2.contains(expResult2));
        Assert.assertEquals(actualResult2,expResult2);

        //homePage.checkIfLogin();
    }

}
