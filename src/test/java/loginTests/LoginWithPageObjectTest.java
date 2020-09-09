package loginTests;

import org.junit.Test;
import parentTests.AbstractParentTest;

public class LoginWithPageObjectTest extends AbstractParentTest {

    @Test
    public void validLogin() {
        loginPage.openPageLogin();
        loginPage.inputLogin("Student");
        loginPage.inputPassword("909090");
        loginPage.clickSubmitButton();
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }

}
