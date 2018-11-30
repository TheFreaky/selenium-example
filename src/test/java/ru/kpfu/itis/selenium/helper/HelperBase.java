package ru.kpfu.itis.selenium.helper;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import ru.kpfu.itis.selenium.manager.AppManager;

/**
 * 02.11.18
 *
 * @author Kuznetsov Maxim
 */
@Data
public class HelperBase {
    protected StringBuffer verificationErrors = new StringBuffer();
    protected AppManager manager;
    protected WebDriver driver;

    public HelperBase(AppManager manager) {
        this.manager = manager;
        this.driver = manager.getDriver();
    }


}
