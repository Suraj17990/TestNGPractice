import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
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
    @Test
    public void loginToFacebook(){facebook.login();}
    @Test
    public void loginVerification(){facebook.verifyLogin();}
    @Test
    public void status(){facebook.updateStatus();
    }
}
