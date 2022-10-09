package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest {
    @Test
    public void setLocaleToEs(){
        /*assert:
        Postaviti jezik na ES
    	Verifikovati da se na stranici u hederu javlja tekst Página de aterrizaje
         */
        driver.get("https://vue-demo.daniel-avellaneda.com");
        homePage.clickLanguageMenuButton();
        homePage.clickEsButton();
        String actualResult = homePage.getHeaderMsg().getText();
        Assert.assertEquals(actualResult, "Página de aterrizaje");
    }
    @Test
    public void setLocaleToEn(){
        /*assert:
        Postaviti jezik na EN
    	Verifikovati da se na stranici u hederu javlja tekst Landing
         */
        driver.get("https://vue-demo.daniel-avellaneda.com");
        homePage.clickLanguageMenuButton();
        homePage.clickEnButton();
        String actualResult = homePage.getHeaderMsg().getText();
        Assert.assertEquals(actualResult, "Landing");
    }
    @Test
    public void setLocaleToFr(){
        /*assert:
        Postaviti jezik na FR
    	Verifikovati da se na stranici u hederu javlja tekst Page d'atterrissage
         */
        driver.get("https://vue-demo.daniel-avellaneda.com");
        homePage.clickLanguageMenuButton();
        homePage.clickFrButton();
        String actualResult = homePage.getHeaderMsg().getText();
        Assert.assertEquals(actualResult, "Page d'atterrissage");
    }
}
