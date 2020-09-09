package loginTests;

import org.junit.Test;
import parentTests.AbstractParentTest;

public class LoginWithPageObjectWrongLoginTest extends AbstractParentTest {

    @Test
    public void validLogin() {
        loginPage.openPageLogin();
        loginPage.inputLogin("Vasya");
        loginPage.inputPassword("909090");
        loginPage.clickSubmitButton();
        checkExpectedResult("Avatar is not present", loginPage.isLoginBoxDisplayed());
    }

}
