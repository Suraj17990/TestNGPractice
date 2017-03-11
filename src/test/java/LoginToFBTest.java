import org.apache.log4j.Logger;
import org.testng.annotations.*;

/**
 * Created by senorita on 2/21/2017.
 */
public class LoginToFBTest extends GuiController {
    final static Logger logger = Logger.getLogger(LoginToFBTest.class);
    Facebook facebook = new Facebook();

    @Parameters("browserName")
    @BeforeClass
    public void openBrowser(@Optional("firefox") String browserName){
        launchBrowser(browserName);
    }

    @AfterClass
    public void closeBrowserInstance(){closeBrowser();}

    @Parameters({"userName","password"})
    @Test
    public void loginToFacebook(@Optional("ooyalatester@vertisinfotech.com") String userName, @Optional("!password*") String password){facebook.login(userName,password);}

    @Test
    public void loginVerification(){facebook.verifyLogin();}

    @Test
    public void status(){facebook.updateStatus();
    }
}
