package ru.kpfu.itis.selenium.test;

import org.junit.Test;
import ru.kpfu.itis.selenium.model.RepositoryData;
import ru.kpfu.itis.selenium.model.UserData;

/**
 * 26.10.18
 *
 * @author Kuznetsov Maxim
 */
public class AddRepositoryTest extends TestBase {

    @Test
    public void testAddRepository() {
        UserData userData = new UserData("maksoh_35@mail.ru", "password");
        RepositoryData repositoryData = new RepositoryData("My project6");
//        manager.getNavigationHelper().openHomepage();
        manager.getNavigationHelper().openLoginPage();
        manager.getAuthHelper().doLogin(userData);
        manager.getRepositoryCreationHelper().createRepository(repositoryData);
    }

}
