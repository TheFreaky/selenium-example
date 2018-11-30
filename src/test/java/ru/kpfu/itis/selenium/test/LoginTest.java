package ru.kpfu.itis.selenium.test;

import org.junit.Assert;
import org.junit.Test;
import ru.kpfu.itis.selenium.model.UserData;

/**
 * 26.10.18
 *
 * @author Kuznetsov Maxim
 */
public class LoginTest extends TestBase {

    @Test
    public void loginWithValidData() {
        UserData userData = new UserData("TheFreaky1", "password");
        manager.getNavigationHelper().openLoginPage();
        manager.getAuthHelper().doLogin(userData);

        Assert.assertTrue(manager.getAuthHelper().isLoggedIn(userData.getLogin()));
    }

    @Test
    public void loginWithInvalidData() {
        UserData userData = new UserData("TheFreaky1", "wrong-password");
        manager.getNavigationHelper().openLoginPage();
        manager.getAuthHelper().doLogin(userData);

        Assert.assertFalse(manager.getAuthHelper().isLoggedIn(userData.getLogin()));
    }

}
