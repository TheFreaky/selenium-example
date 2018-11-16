package ru.kpfu.itis.selenium.manager;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.kpfu.itis.selenium.helper.AuthHelper;
import ru.kpfu.itis.selenium.helper.NavigationHelper;
import ru.kpfu.itis.selenium.helper.RepositoryHelper;

import java.util.concurrent.TimeUnit;

/**
 * 02.11.18
 *
 * @author Kuznetsov Maxim
 */
@Data
public class AppManager {
    private WebDriver driver;
    private String homePageUrl = "https://gitlab.com";
    private String loginPageUrl = "https://gitlab.com/users/sign_in";
    private NavigationHelper navigationHelper;
    private AuthHelper authHelper;
    private RepositoryHelper repositoryHelper;

    public AppManager() {
        System.setProperty("webdriver.gecko.driver", "/home/maxim/node_modules/geckodriver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        navigationHelper = new NavigationHelper(this);
        authHelper = new AuthHelper(this);
        repositoryHelper = new RepositoryHelper(this);
    }
}
