package ru.kpfu.itis.selenium.test;

import lombok.Data;
import org.junit.AfterClass;
import org.junit.Before;
import ru.kpfu.itis.selenium.manager.AppManager;

/**
 * 26.10.18
 *
 * @author Kuznetsov Maxim
 */
@Data
public class TestBase {
    protected static AppManager manager;

    @Before
    public void setUp() {
        manager = AppManager.getInstance();
    }
}
