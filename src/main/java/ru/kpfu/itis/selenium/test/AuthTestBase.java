package ru.kpfu.itis.selenium.test;

import lombok.Data;
import org.junit.After;
import org.junit.Before;
import ru.kpfu.itis.selenium.manager.AppManager;
import ru.kpfu.itis.selenium.model.UserData;

import static org.junit.Assert.fail;

/**
 * 26.10.18
 *
 * @author Kuznetsov Maxim
 */
@Data
public class AuthTestBase extends TestBase {
    @Before
    public void setUp() {
        super.setUp();

        UserData userData = new UserData("maksoh_35@mail.ru", "password");
        manager.getNavigationHelper().openLoginPage();
        manager.getAuthHelper().doLogin(userData);
    }
}
