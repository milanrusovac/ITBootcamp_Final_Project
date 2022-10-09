package Test;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("admin/cities"));
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
        adminCitiesPage.clickNewItemButton();
        adminCitiesPage.newCityMethod(adminCitiesPage.getCityName());
        String actualResult = adminCitiesPage.getSuccessMsg().getText();
        Assert.assertTrue(actualResult.contains("Saved successfully"));
        homePage.checkIfLogin();
    }
    @Test (priority = 3,dependsOnMethods = {"createNewCity"})
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
        wait.withTimeout(Duration.ofSeconds(3));
        adminCitiesPage.getMsgNameField().click();
        adminCitiesPage.getMsgNameField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        adminCitiesPage.newCityMethod(adminCitiesPage.getCityName() + " - edited");
        String actualResult = adminCitiesPage.getSuccessMsg().getText();
        Assert.assertTrue(actualResult.contains("Saved successfully"));
        homePage.checkIfLogin();
    }
    @Test (priority = 4, dependsOnMethods = {"createNewCity", "editCity"} )
    public void searchCity(){
        /*Podaci: editovani grad iz testa #3
        assert:
     	Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
         */
        homePage.clickLoginButton();
        loginPage.loginMethod("admin@admin.com", "12345" );
        homePage.clickAdminButton();
        homePage.clickCitiesButton();
        adminCitiesPage.searchMethod(adminCitiesPage.getCityName() + " - edited");
        String actualResult = adminCitiesPage.getSearchResultCityName().getText();
        Assert.assertEquals(actualResult, adminCitiesPage.getCityName() + " - edited");
        homePage.checkIfLogin();
    }
    @Test (priority = 5, dependsOnMethods = {"createNewCity", "editCity"} )
    public void deleteCity() throws InterruptedException {
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
        adminCitiesPage.searchMethod(adminCitiesPage.getCityName()+" - edited");
        wait.withTimeout(Duration.ofSeconds(3));
        String actualResult = adminCitiesPage.getSearchResultCityName().getText();
        Assert.assertTrue(actualResult.contains(adminCitiesPage.getCityName()+" - edited"));
        adminCitiesPage.clickSearchDeleteIcon();
        wait.withTimeout(Duration.ofSeconds(3));
        Thread.sleep(3000);
        adminCitiesPage.clickWarningMsgDeleteButton();
        //wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),"Save successfully CLOSE"));
        //wait.withTimeout(Duration.ofSeconds(3));

        String expResult2 = " Deleted successfully ";
        String actualResult2 = adminCitiesPage.getSuccessDeleteMsg().getText();
        //Assert.assertTrue(actualResult2.contains(expResult2));
        //Assert.assertEquals(actualResult2,expResult2);

        //homePage.checkIfLogin();
    }
}
