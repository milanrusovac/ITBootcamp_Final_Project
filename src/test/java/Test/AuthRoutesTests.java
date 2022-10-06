package Test;
/*Test #1: Forbids visits to home url if not authenticated
assert:
•	Ucitati /home stranu kada korisnik nije ulogovan
•	Verifikovati da se u url-u stranice javlja ruta /login

Test #2: Forbids visits to profile url if not authenticated
assert:
•	Ucitati /profile stranu
•	Verifikovati da se u url-u stranice javlja ruta /login

Test #3: Forbids visits to admin cities url if not authenticated
assert:
•	Ucitati /admin/cities stranu
•	Verifikovati da se u url-u stranice javlja ruta /login

Test #4: Forbids visits to admin users url if not authenticated
assert:
•	Ucitati /admin/users stranu
•	Verifikovati da se u url-u stranice javlja ruta /login
     */

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
        String expResult = "login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expResult));
    }
    @Test
    public void forbidsVisitsToProfileUrlIfNotAuthenticated(){
        /*assert:
    	Ucitati /profile stranu
    	Verifikovati da se u url-u stranice javlja ruta /login
         */
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String expResult = "login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expResult));
    }
    @Test
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated(){
        /*assert:
    	Ucitati /admin/cities stranu
    	Verifikovati da se u url-u stranice javlja ruta /login
         */
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String expResult = "login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expResult));
    }
    @Test
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated(){
        /*assert:
    	Ucitati /admin/users stranu
    	Verifikovati da se u url-u stranice javlja ruta /login
         */
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String expResult = "login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expResult));
    }
}
