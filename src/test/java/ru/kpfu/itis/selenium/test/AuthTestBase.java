package ru.kpfu.itis.selenium.test;

import lombok.Data;
import org.junit.Before;
import ru.kpfu.itis.selenium.config.Setting;
import ru.kpfu.itis.selenium.model.UserData;

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

        UserData userData = new UserData(Setting.getLogin(), Setting.getPassword());
        manager.getNavigationHelper().openLoginPage();
        manager.getAuthHelper().doLogin(userData);
    }
}
