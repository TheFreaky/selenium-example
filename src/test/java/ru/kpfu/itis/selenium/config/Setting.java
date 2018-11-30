package ru.kpfu.itis.selenium.config;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * 30.11.18
 *
 * @author Kuznetsov Maxim
 */
public class Setting {
    private static String filename = "Setting.xml";

    private static String baseUrl;
    private static String login;
    private static String password;
    private static Document document;

    static {
        try {
            File f = new File(Setting.class.getClassLoader().getResource(filename).getFile());

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(f);
        } catch (Throwable e) {
            //ignore
        }
    }

    public static String getBaseUrl() {
        if (baseUrl == null) {
            baseUrl = document.getDocumentElement().getElementsByTagName("BaseUrl").item(0).getTextContent();
        }
        return baseUrl;
    }

    public static String getLogin() {
        if (login == null) {
            login = document.getDocumentElement().getElementsByTagName("Login").item(0).getTextContent();
        }
        return login;
    }

    public static String getPassword() {
        if (password == null) {
            password = document.getDocumentElement().getElementsByTagName("Password").item(0).getTextContent();
        }
        return password;
    }
}
