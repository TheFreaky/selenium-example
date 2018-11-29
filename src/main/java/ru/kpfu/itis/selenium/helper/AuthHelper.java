package ru.kpfu.itis.selenium.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import ru.kpfu.itis.selenium.manager.AppManager;
import ru.kpfu.itis.selenium.model.UserData;

/**
 * 02.11.18
 *
 * @author Kuznetsov Maxim
 */
public class AuthHelper extends HelperBase {
    public AuthHelper(AppManager manager) {
        super(manager);
    }

    public void doLogin(UserData userData) {
        if (isLoggedIn(userData.getLogin())) {
            return;
        } else if (isLoggedIn()) {
            doLogout();
        }

        driver.findElement(By.id("user_login")).click();
        driver.findElement(By.id("user_login")).sendKeys(userData.getLogin());
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys(userData.getPassword());
        driver.findElement(By.name("commit")).click();
    }

    private void doLogout() {
        manager.getNavigationHelper().openHomepage();
        driver.findElement(By.cssSelector("a.header-user-dropdown-toggle > svg.caret-down")).click();
        driver.findElement(By.linkText("Sign out")).click();
    }

    public String getUserLogin() {
        return driver.findElement(By.className("profile-link")).getAttribute("data-user");
    }

    public boolean isLoggedIn() {
        try {
            driver.findElement(By.cssSelector("a.header-user-dropdown-toggle > svg.caret-down")).click();
            driver.findElement(By.linkText("Sign out"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isLoggedIn(String username) {
        if (isLoggedIn()) {
            String userLogin = getUserLogin();
            return userLogin != null && userLogin.contains(username);
        }
        return false;
    }
}
