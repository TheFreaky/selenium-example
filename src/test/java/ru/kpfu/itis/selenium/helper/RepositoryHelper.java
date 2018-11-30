package ru.kpfu.itis.selenium.helper;

import org.openqa.selenium.By;
import ru.kpfu.itis.selenium.manager.AppManager;
import ru.kpfu.itis.selenium.model.RepositoryData;

/**
 * 02.11.18
 *
 * @author Kuznetsov Maxim
 */
public class RepositoryHelper extends HelperBase {
    public RepositoryHelper(AppManager manager) {
        super(manager);
    }

    public void createRepository(RepositoryData repositoryData) {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Projects'])[3]/following::a[1]")).click();
        driver.findElement(By.id("project_name")).click();
        driver.findElement(By.id("project_name")).clear();
        driver.findElement(By.id("project_name")).sendKeys(repositoryData.getName());
        driver.findElement(By.name("commit")).click();
    }

    public void changeRepositoryName(RepositoryData repositoryData) {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='M'])[1]/following::span[3]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Snippets'])[4]/following::a[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Advanced'])[1]/following::button[1]")).click();
        driver.findElement(By.id("project_name")).click();
        driver.findElement(By.id("project_name")).clear();
        driver.findElement(By.id("project_name")).sendKeys(repositoryData.getName());
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='You will need to update your local repositories to point to the new location.'])[1]/following::input[1]")).click();
        driver.findElement(By.name("commit")).click();
    }

    public String getRepositoryName() {
        return manager.getDriver().findElement(By.className("sidebar-context-title")).getText();
    }
}
