package parentTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import libs.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.HomePage;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AbstractParentTest {
    WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected Utils utils;
    private String pathToScreenShot;

    @Rule
    public TestName testName = new TestName();

    @Before
    public  void SetUp() throws Exception {
        pathToScreenShot = "../yelisieieva11/target/screenshot/" + this.getClass().getPackage().getName() + "/"
                + this.getClass().getSimpleName() + this.testName.getMethodName() + ".jpg";

//        webDriver = driverInit();

        try {
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        utils = new Utils();
    }

//    private WebDriver driverInit() {
//        WebDriverManager.chromedriver().setup();
//        return new ChromeDriver();
//    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    protected  void checkExpectedResult(String message, boolean actualResult) {

        if (!actualResult == true) {
            utils.screenShot(pathToScreenShot, webDriver);
        }
        Assert.assertEquals(message, true, actualResult);
    }
}