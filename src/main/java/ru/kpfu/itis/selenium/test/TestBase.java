package ru.kpfu.itis.selenium.test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.kpfu.itis.selenium.model.RepositoryData;
import ru.kpfu.itis.selenium.model.UserData;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * 26.10.18
 *
 * @author Kuznetsov Maxim
 */
public class TestBase {
    protected WebDriver driver;
    protected StringBuffer verificationErrors = new StringBuffer();
    private String homePageUrl = "https://gitlab.com/users/sign_in";

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/home/maxim/node_modules/geckodriver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    protected void createRepository(RepositoryData repositoryData) {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Owned by me'])[1]/following::a[1]")).click();
        driver.findElement(By.id("project_name")).clear();
        driver.findElement(By.id("project_name")).sendKeys(repositoryData.getName());
        driver.findElement(By.id("project_path")).click();
        driver.findElement(By.name("commit")).click();
    }

    protected void doLogin(UserData userData) {
        driver.findElement(By.id("user_login")).click();
        driver.findElement(By.id("user_login")).sendKeys(userData.getLogin());
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys(userData.getPassword());
        driver.findElement(By.name("commit")).click();
    }

    protected void goToHomePage() {
        driver.get(homePageUrl);
    }
}
