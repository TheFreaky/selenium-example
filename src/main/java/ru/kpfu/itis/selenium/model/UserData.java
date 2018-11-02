package ru.kpfu.itis.selenium.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 26.10.18
 *
 * @author Kuznetsov Maxim
 */
@Data
@AllArgsConstructor
public class UserData {
    private String login;
    private String password;
}
