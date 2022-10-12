package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest {

    /**assert:
     Set language to ES
     Verify that the text Página de aterrizaje appears in the header of the page
     */
    @Test
    public void setLocaleToEs(){
        driver.get("https://vue-demo.daniel-avellaneda.com");
        homePage.clickLanguageMenuButton();
        homePage.clickEsButton();
        String actualResult = homePage.getHeaderMsg().getText();
        Assert.assertEquals(actualResult, "Página de aterrizaje");
    }
    /**assert:
     Set the language to EN
     Verify that the Landing text appears in the header of the page
     */
    @Test
    public void setLocaleToEn(){
        driver.get("https://vue-demo.daniel-avellaneda.com");
        homePage.clickLanguageMenuButton();
        homePage.clickEnButton();
        String actualResult = homePage.getHeaderMsg().getText();
        Assert.assertEquals(actualResult, "Landing");
    }
    /**public void setLocaleToFr(){
     /*assert:
     Set language to FR
     Verify that the text Page d'atterrissage appears in the header of the page
     */
    @Test
    public void setLocaleToFr(){
        driver.get("https://vue-demo.daniel-avellaneda.com");
        homePage.clickLanguageMenuButton();
        homePage.clickFrButton();
        String actualResult = homePage.getHeaderMsg().getText();
        Assert.assertEquals(actualResult, "Page d'atterrissage");
    }
}
