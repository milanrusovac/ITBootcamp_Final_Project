package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    /**assert:
     Load the /home page when the user is not logged in
     Verify that the route /login appears in the url of the page
     */
    @Test
    public void forbidsVisitsToHomeUrlIfNotAuthenticated(){
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("login"));
    }
    /**assert:
     Load /profile page
     Verify that the route /login appears in the url of the page
     */
    @Test
    public void forbidsVisitsToProfileUrlIfNotAuthenticated(){
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("login"));
    }
    /**assert:
     Load the /admin/cities page
     Verify that the route /login appears in the url of the page
     */
    @Test
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated(){
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("login"));
    }
    /**assert:
     Load the /admin/users page
     Verify that the route /login appears in the url of the page
     */
    @Test
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated(){
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("login"));
    }
}
