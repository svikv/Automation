package pages;

import libs.ActionWithWebElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import org.junit.Assert;

public class HomePage extends ParentPage {

    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());

    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;

    @FindBy(xpath = ".//li[@id='dictionary']//ul[@class='treeview-menu menu-open']//li[@id='prov_cus']")
    private WebElement submenuProviders;

    String url = "http://v3.test.itpmgroup.com";

    public HomePage(WebDriver webDriver){
        super(webDriver);
    }

    public boolean isAvatarDisplayed () {
       return actionWithWebElements.isElementDisplayed(avatar);
    }

    public void checkIsAvatarPresent () {
        Assert.assertTrue("Avatar is not displayed", isAvatarDisplayed());
    }

    public void clickOnSubmenuProviders () {
        actionWithWebElements.clickButton(submenuProviders);
    }

}
