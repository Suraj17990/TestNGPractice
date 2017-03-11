import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import static java.lang.System.exit;

/**
 * Created by senorita on 2/21/2017.
 */
public class GuiController {
    public static WebDriver driver;
    final static Logger logger = Logger.getLogger(GuiController.class);
    public void launchBrowser(String browserName){
        switch(browserName) {
            case "firefox": System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                            driver = new FirefoxDriver();
                            break;
            case "chrome": System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                            driver = new ChromeDriver();
                            break;
            default:
        }
    }

    public void closeBrowser(){
        driver.quit();
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
