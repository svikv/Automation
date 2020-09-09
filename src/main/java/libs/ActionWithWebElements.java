package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

public class ActionWithWebElements {
//    private static LOGGER = LoggerFactory.getLogger(ActionWithWebElements.class);

    WebDriver webDriver;
    Wait<WebDriver> wait;

    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait = new WebDriverWait(webDriver, 1);


    public ActionWithWebElements (WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillField(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info("");
        } catch (Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }

    public void clickButton(WebElement element){
        try {
            element.click();
            logger.info("");
        } catch (Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }

    public boolean isElementDisplayed(WebElement element){
        try {
            webDriverWait.until(ExpectedConditions.invisibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e){
            e.printStackTrace();
            logger.error("");
            return false;
        }
    }

    public void setCheckBox(WebElement element, boolean state){

        try {
            if(element.isSelected() == state) {
                logger.info("");
            }else {
                element.click();
            }
            logger.info("");

        } catch (Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }

    public void checkBox(WebElement element) {

        try {
            if(!element.isSelected()){
                element.click();
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }

    public void checkRadio(WebElement element) {
        try {
            if(!element.isSelected()){
                element.click();
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }

    private void selectValueFromSelector (WebElement element, String text) {
        Select dropDownValue = new Select(element);
        try{
            dropDownValue.selectByVisibleText(text);
        } catch(Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }

    private void selectValueFromSelector (WebElement element, int index) {
        Select dropDownValue = new Select(element);
        try{
            dropDownValue.selectByIndex(index);
        } catch(Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }

}
