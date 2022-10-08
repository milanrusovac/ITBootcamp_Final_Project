package Test;
/*Test #1: Edits profile
Podaci: random podaci korišćenjem faker library-ja
assert:
•	Verifikovati da je prikazana poruka Profile saved successfuly
•	Verifikovati da svaki input sada za value atribut ima vrednost koja je uneta u okviru forme
     */

import org.testng.annotations.Test;

public class ProfileTests extends BaseTest{
    @Test
    public void editsProfile(){
        /*Podaci: random podaci korišćenjem faker library-ja
        assert:
        Verifikovati da je prikazana poruka Profile saved successfuly
    	Verifikovati da svaki input sada za value atribut ima vrednost koja je uneta u okviru forme
         */
        homePage.clickSignUpButton();
        signUpPage.singUpMethod("Milan Rusovac",signUpPage.fakeEmailMethod(), "123456", "123456");
        signUpPage.clickInfoMsgCloseButton();
        homePage.clickMyProfileButton();





    }









}
