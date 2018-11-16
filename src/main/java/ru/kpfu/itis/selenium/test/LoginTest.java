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
    public void testLogin() {
        UserData userData = new UserData("TheFreaky1", "password");
        manager.getNavigationHelper().openLoginPage();
        manager.getAuthHelper().doLogin(userData);
        String userLogin = manager.getAuthHelper().getUserLogin();
        Assert.assertTrue(userLogin.contains(userData.getLogin()));
    }

}
