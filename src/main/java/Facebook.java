import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.time.Instant;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by senorita on 2/25/2017.
 */
public class Facebook extends GuiController {
    final static Logger logger = Logger.getLogger(Facebook.class);
    long now = Instant.now().toEpochMilli();

    public void login(String userName, String password){
        logger.info("Facebook Test Started");
        driver.get("https://www.facebook.com/");
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.clear();
        emailField.sendKeys(userName);
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.clear();
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id("loginbutton"));
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(20,SECONDS);
    }

    public void updateStatus() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = driver.findElement(By.xpath("//textarea[@title=\"What's on your mind?\"]"));
        wait.until(ExpectedConditions.visibilityOf(element));
        waitForElement(element);
        element.click();
        element.click();
        WebElement updateStatus = driver.findElement(By.xpath("//div[@data-testid='status-attachment-mentions-input']"));
        updateStatus.click();
        updateStatus.sendKeys("Hello Friends"+now);
    }

    public void verifyStatus(){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement postbutton = driver.findElement(By.xpath("//button[@data-testid='react-composer-post-button']//span//em[text()='Post']"));
        postbutton.click();
        WebElement checkUpdate = driver.findElement(By.xpath("//div[contains(@class,'userContent')]//p"));
        wait.until(ExpectedConditions.visibilityOf(checkUpdate));
        waitForElement(checkUpdate);
        String value = checkUpdate.getText();
        WebElement justNow = driver.findElement(By.xpath("//span[contains(text(),'Just now')]"));
        waitForElement(justNow);
        Assert.assertEquals(value, "Hello Friends"+now);
    }

    public void verifyLogin(){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/?ref=tn_tnmn']"));
        wait.until(ExpectedConditions.visibilityOf(element));
        if (element.isDisplayed()){
            logger.debug("Logged in Successfully...");
        }else
            logger.error("Unable to login");
    }
}
