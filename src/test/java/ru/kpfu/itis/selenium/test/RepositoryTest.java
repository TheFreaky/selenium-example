package ru.kpfu.itis.selenium.test;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.kpfu.itis.selenium.config.RepositorySetting;
import ru.kpfu.itis.selenium.model.RepositoryData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 26.10.18
 *
 * @author Kuznetsov Maxim
 */
@RunWith(DataProviderRunner.class)
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
    @UseDataProvider("repositoriesFromXmlFile")
    public void testAddRepository(String newRepositoryName) {
        RepositoryData repositoryData = new RepositoryData(newRepositoryName);

        manager.getNavigationHelper().openHomepage();
        manager.getRepositoryHelper().createRepository(repositoryData);
        String repositoryName = manager.getRepositoryHelper().getRepositoryName();
        Assert.assertEquals(repositoryData.getName(), repositoryName);
    }

    @DataProvider
    public static List<List<Object>> repositoriesFromXmlFile() {
        List<RepositoryData> repositoriesData = RepositorySetting.getRepositoriesData();
        List<List<Object>> result = new ArrayList<List<Object>>();
        for (RepositoryData repositoriesDatum : repositoriesData) {
            result.add(Collections.singletonList((Object) repositoriesDatum.getName()));
        }
        return result;
    }

}
