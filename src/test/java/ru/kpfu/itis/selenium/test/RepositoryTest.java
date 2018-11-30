package ru.kpfu.itis.selenium.test;

import org.junit.Assert;
import org.junit.Test;
import ru.kpfu.itis.selenium.model.RepositoryData;

/**
 * 26.10.18
 *
 * @author Kuznetsov Maxim
 */
public class RepositoryTest extends AuthTestBase {

    @Test
    public void testChangeRepositoryName() {
        RepositoryData repositoryData = new RepositoryData("My new test project500101");
        manager.getNavigationHelper().openHomepage();
        manager.getRepositoryHelper().changeRepositoryName(repositoryData);
        String repositoryName = manager.getRepositoryHelper().getRepositoryName();
        Assert.assertEquals(repositoryData.getName(), repositoryName);
    }

    @Test
    public void testAddRepository() {
        RepositoryData repositoryData = new RepositoryData("My test project10000101");
        manager.getNavigationHelper().openHomepage();
        manager.getRepositoryHelper().createRepository(repositoryData);
        String repositoryName = manager.getRepositoryHelper().getRepositoryName();
        Assert.assertEquals(repositoryData.getName(), repositoryName);
    }

}
