package ru.kpfu.itis.selenium.manager;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.kpfu.itis.selenium.config.Setting;
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
    private String homePageUrl;
    private String loginPageUrl = "https://gitlab.com/users/sign_in";
    private NavigationHelper navigationHelper;
    private AuthHelper authHelper;
    private RepositoryHelper repositoryHelper;

    private static AppManager instance;

    private AppManager() {
        System.setProperty("webdriver.gecko.driver", "/home/maxim/node_modules/geckodriver/geckodriver");
        homePageUrl = Setting.getBaseUrl();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        navigationHelper = new NavigationHelper(this);
        authHelper = new AuthHelper(this);
        repositoryHelper = new RepositoryHelper(this);
    }

    public static AppManager getInstance() {
        AppManager result = instance;
        if (result == null) {
            synchronized (AppManager.class) {
                result = instance;
                if (result == null)
                    instance = result = new AppManager();
            }
        }
        return result;
    }

    public void shutDown() {
        try {
            driver.quit();
        } catch (Throwable e) {
            //ignore
        }
    }
}
