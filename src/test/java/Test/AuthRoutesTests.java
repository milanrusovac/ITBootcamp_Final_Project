package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    @Test
    public void forbidsVisitsToHomeUrlIfNotAuthenticated(){
        /*assert:
     	Ucitati /home stranu kada korisnik nije ulogovan
    	Verifikovati da se u url-u stranice javlja ruta /login
         */
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("login"));
    }
    @Test
    public void forbidsVisitsToProfileUrlIfNotAuthenticated(){
        /*assert:
    	Ucitati /profile stranu
    	Verifikovati da se u url-u stranice javlja ruta /login
         */
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("login"));
    }
    @Test
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated(){
        /*assert:
    	Ucitati /admin/cities stranu
    	Verifikovati da se u url-u stranice javlja ruta /login
         */
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("login"));
    }
    @Test
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated(){
        /*assert:
    	Ucitati /admin/users stranu
    	Verifikovati da se u url-u stranice javlja ruta /login
         */
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("login"));
    }
}
