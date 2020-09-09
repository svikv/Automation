package pages;

import libs.ConfigClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import org.junit.Assert;

public class LoginPage extends ParentPage {

    @FindBy(name = "_username")
    private WebElement inputLoginName;

    @FindBy(name = "_password")
    private WebElement inputPasswordName;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement inputButtonXpath;

    @FindBy(xpath = ".//div[@class='login-box-body']")
    private WebElement loginBox;

    String url = "http://v3.test.itpmgroup.com";

    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }

    public void openPage(){
        webDriver.get(url);
    }

    public void inputLogin(String text){
        actionWithWebElements.fillField(inputLoginName, text);
    }

    public void inputPassword(String text){
        actionWithWebElements.fillField(inputPasswordName, text);
    }

    public void clickSubmitButton(){
        actionWithWebElements.clickButton(inputButtonXpath);
    }

    public void openPageLogin(){
        try {
            webDriver.get(ConfigClass.getCfgValue("base_url")+"/login");
            logger.info("Page login was opened");

        } catch (Exception e) {
            logger.info("Can't open URL");
            Assert.fail("Can't open URL");
        }
    }

    public boolean isLoginBoxDisplayed () {
        return actionWithWebElements.isElementDisplayed(loginBox);
    }

    public void loginToPage(String login, String password){
        openPageLogin();
        inputLogin(login);
        inputPassword(password);
        clickSubmitButton();
    }
}
