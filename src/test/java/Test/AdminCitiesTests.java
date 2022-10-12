package Test;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminCitiesTests extends BaseTest{

    /**Data:
     admin email: admin@admin.com
     admin password: 12345
     assert:
     Verify that the /admin/cities route appears in the url of the page
     Verify the existence of the logout button
     */
    @Test
    public void visitsTheAdminCitiesPageAndListCities(){
        homePage.clickLoginButton();
        loginPage.loginMethod("admin@admin.com", "12345" );
        homePage.clickAdminButton();
        homePage.clickCitiesButton();
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("admin/cities"));
        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());
        homePage.logoutIfLogin();
    }
    /**Data: random city using faker library
     assert:
     Verify that the message contains the text Saved successfully
     */
    @Test ()
    public void createNewCity(){
        homePage.clickLoginButton();
        loginPage.loginMethod("admin@admin.com", "12345" );
        homePage.clickAdminButton();
        homePage.clickCitiesButton();
        adminCitiesPage.clickNewItemButton();
        adminCitiesPage.newCityMethod(adminCitiesPage.getCityName());
        String actualResult = adminCitiesPage.getSuccessMsg().getText();
        Assert.assertTrue(actualResult.contains("Saved successfully"));
        homePage.logoutIfLogin();
    }
    /**Data: the city created in test 2 with the same name is edited + - edited (example: Belgrade - Belgrade edited)
     assert:
     Verify that the message contains the text Saved successfully
     */
    @Test (dependsOnMethods = {"createNewCity"})
    public void editCity(){
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
        homePage.logoutIfLogin();
    }
    /**Data: edited city from test #3
     assert:
     Verify that there is text from the search in the Name column of the first row
     */
    @Test (dependsOnMethods = {"createNewCity", "editCity"} )
    public void searchCity(){
        homePage.clickLoginButton();
        loginPage.loginMethod("admin@admin.com", "12345" );
        homePage.clickAdminButton();
        homePage.clickCitiesButton();
        adminCitiesPage.searchMethod(adminCitiesPage.getCityName() + " - edited");
        String actualResult = adminCitiesPage.getSearchResultCityName().getText();
        Assert.assertEquals(actualResult, adminCitiesPage.getCityName() + " - edited");
        homePage.logoutIfLogin();
    }
    /**Data: edited city from test #3
     assert:
     Enter the old name of the city in the search field
     Wait until the number of rows in the table is 1
     Verify that there is text from the search in the Name column of the first row
     Click on the Delete button from the first row
     Wait for the deletion dialog to appear
     Click the Delete button from the dialog
     Wait until the message display pop-up is visible
     Verify that the message contains the text Deleted successfully
     */
    @Test (priority = 1, dependsOnMethods = {"createNewCity", "editCity"} )
    public void deleteCity(){
        homePage.clickLoginButton();
        loginPage.loginMethod("admin@admin.com", "12345" );
        homePage.clickAdminButton();
        homePage.clickCitiesButton();
        adminCitiesPage.searchMethod(adminCitiesPage.getCityName());
        wait.withTimeout(Duration.ofSeconds(3));
        String actualResult = adminCitiesPage.getSearchResultCityName().getText();
        Assert.assertTrue(actualResult.contains(adminCitiesPage.getCityName()));
        adminCitiesPage.clickSearchDeleteIcon();
        wait.withTimeout(Duration.ofSeconds(3));
        adminCitiesPage.clickWarningMsgDeleteButton();

        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),"Deleted successfully\nCLOSE"));
        boolean deleteMsgSuccess = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")).getText().contains("Deleted successfully");
        Assert.assertTrue(deleteMsgSuccess);

        homePage.logoutIfLogin();

        /**
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),"Deleted successfully\nCLOSE"));
        String expResult2 = " Deleted successfully ";
        String actualResult2 = adminCitiesPage.getSuccessDeleteMsg().getText();
        Assert.assertTrue(actualResult2.contains(expResult2));
        //Assert.assertEquals(actualResult2,expResult2);
         */

        /**
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),"Deleted successfully\nCLOSE"));
        boolean actualResult3 = adminCitiesPage.getSuccessDeleteMsg().getText().contains("Deleted successfully");
        Assert.assertTrue(actualResult3);
        */

    }
}
