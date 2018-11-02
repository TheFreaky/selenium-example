package ru.kpfu.itis.selenium.helper;

import org.openqa.selenium.By;
import ru.kpfu.itis.selenium.manager.AppManager;
import ru.kpfu.itis.selenium.model.UserData;

/**
 * 02.11.18
 *
 * @author Kuznetsov Maxim
 */
public class AuthHelper extends HelperBase {
    public AuthHelper(AppManager manager) {
        super(manager);
    }

    public void doLogin(UserData userData) {
        driver.findElement(By.id("user_login")).click();
        driver.findElement(By.id("user_login")).sendKeys(userData.getLogin());
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys(userData.getPassword());
        driver.findElement(By.name("commit")).click();
    }
}
