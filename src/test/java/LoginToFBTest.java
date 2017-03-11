import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by senorita on 2/21/2017.
 */
public class LoginToFBTest extends GuiController {
    final static Logger logger = Logger.getLogger(LoginToFBTest.class);
    Facebook facebook = new Facebook();

    @BeforeClass
    public void openBrowser(){
        launchBrowser();
    }

    @AfterClass
    public void closeBrowserInstance(){closeBrowser();}

    @Parameters({"userName","password"})
    @Test
    public void loginToFacebook(String userName, String password){facebook.login(userName,password);}

    @Test
    public void loginVerification(){facebook.verifyLogin();}

    @Test
    public void status(){facebook.updateStatus();
    }
}
