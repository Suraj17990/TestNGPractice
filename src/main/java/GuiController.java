import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

/**
 * Created by senorita on 2/21/2017.
 */
public class GuiController {
    public static WebDriver driver;
    final static Logger logger = Logger.getLogger(GuiController.class);
    @Parameters("browserName")
    public void launchBrowser(){
        System.setProperty("webdriver.gecko.driver","G:/Common Files/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    public void waitForElement(WebElement element) {
        for (int i=0; i<10; i++){
            if(element.isDisplayed()) {
                logger.debug("element is displayed");
                break;
            }
        }

    }
}
