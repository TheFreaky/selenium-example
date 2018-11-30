package ru.kpfu.itis.selenium.helper;

import ru.kpfu.itis.selenium.manager.AppManager;

/**
 * 02.11.18
 *
 * @author Kuznetsov Maxim
 */
public class NavigationHelper extends HelperBase {

    public NavigationHelper(AppManager manager) {
        super(manager);
    }

    public void openHomepage() {
        driver.get(manager.getHomePageUrl());
    }

    public void openLoginPage() {
        driver.get(manager.getLoginPageUrl());
    }
}
