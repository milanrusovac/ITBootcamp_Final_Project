package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

/*Test #1: Set locale to ES
assert:
•	Postaviti jezik na ES
•	Verifikovati da se na stranici u hederu javlja tekst Página de aterrizaje

Test #2: Set locale to EN
assert:
•	Postaviti jezik na EN
•	Verifikovati da se na stranici u hederu javlja tekst Landing

Test #3: Set locale to FR
assert:
•	Postaviti jezik na FR
•	Verifikovati da se na stranici u hederu javlja tekst Page d'atterrissage

 */
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
        String expResult = "Página de aterrizaje";
        String actualResult = homePage.getHeaderMsg().getText();
        Assert.assertEquals(actualResult, expResult);
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
        String expResult = "Landing";
        String actualResult = homePage.getHeaderMsg().getText();
        Assert.assertEquals(actualResult, expResult);
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
        String expResult = "Page d'atterrissage";
        String actualResult = homePage.getHeaderMsg().getText();
        Assert.assertEquals(actualResult, expResult);
    }
}
