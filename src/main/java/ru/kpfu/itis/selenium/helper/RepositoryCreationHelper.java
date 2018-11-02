package ru.kpfu.itis.selenium.helper;

import org.openqa.selenium.By;
import ru.kpfu.itis.selenium.manager.AppManager;
import ru.kpfu.itis.selenium.model.RepositoryData;

/**
 * 02.11.18
 *
 * @author Kuznetsov Maxim
 */
public class RepositoryCreationHelper extends HelperBase {
    public RepositoryCreationHelper(AppManager manager) {
        super(manager);
    }

    public void createRepository(RepositoryData repositoryData) {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Owned by me'])[1]/following::a[1]")).click();
        driver.findElement(By.id("project_name")).clear();
        driver.findElement(By.id("project_name")).sendKeys(repositoryData.getName());
        driver.findElement(By.id("project_path")).click();
        driver.findElement(By.name("commit")).click();
    }
}
