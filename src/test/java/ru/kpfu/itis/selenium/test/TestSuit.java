package ru.kpfu.itis.selenium.test;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.kpfu.itis.selenium.manager.AppManager;

/**
 * 30.11.18
 *
 * @author Kuznetsov Maxim
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ LoginTest.class, RepositoryTest.class })
public class TestSuit {

    @AfterClass
    public static void tearDown() {
        AppManager.getInstance().shutDown();
    }
}
