package ru.kpfu.itis.selenium.test;

import org.junit.Assert;
import org.junit.Test;
import ru.kpfu.itis.selenium.model.RepositoryData;
import ru.kpfu.itis.selenium.model.UserData;

/**
 * 26.10.18
 *
 * @author Kuznetsov Maxim
 */
public class RepositoryTest extends TestBase {

    @Test
    public void testAddRepository() {
        UserData userData = new UserData("maksoh_35@mail.ru", "password");
        RepositoryData repositoryData = new RepositoryData("My test project");
//        manager.getNavigationHelper().openHomepage();
        manager.getNavigationHelper().openLoginPage();
        manager.getAuthHelper().doLogin(userData);
        manager.getRepositoryHelper().createRepository(repositoryData);
        String repositoryName = manager.getRepositoryHelper().getRepositoryName();
        Assert.assertEquals(repositoryData.getName(), repositoryName);
    }

    @Test
    public void testChangeRepositoryName() {
        UserData userData = new UserData("maksoh_35@mail.ru", "password");
        RepositoryData repositoryData = new RepositoryData("My new test project");
        manager.getNavigationHelper().openLoginPage();
        manager.getAuthHelper().doLogin(userData);
        manager.getNavigationHelper().openHomepage();
        manager.getRepositoryHelper().changeRepositoryName(repositoryData);
        String repositoryName = manager.getRepositoryHelper().getRepositoryName();
        Assert.assertEquals(repositoryData.getName(), repositoryName);
    }

}
