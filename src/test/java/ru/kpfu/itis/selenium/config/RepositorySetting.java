package ru.kpfu.itis.selenium.config;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import ru.kpfu.itis.selenium.model.RepositoryData;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 30.11.18
 *
 * @author Kuznetsov Maxim
 */
public class RepositorySetting {
    private static String filename = "Repositories.xml";

    private static List<RepositoryData> repositoriesData;
    private static Document document;

    static {
        try {
            File f = new File(RepositorySetting.class.getClassLoader().getResource(filename).getFile());

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(f);
        } catch (Throwable e) {
            //ignore
        }
    }

    public static List<RepositoryData> getRepositoriesData() {
        if (repositoriesData == null) {
            repositoriesData = new ArrayList<RepositoryData>();
            NodeList repositoryData = document.getDocumentElement().getElementsByTagName("RepositoyData");
            for (int i = 0; i < repositoryData.getLength(); i++) {
                String repositoryName = ((Element) repositoryData.item(i)).getElementsByTagName("Name").item(0).getTextContent();
                repositoriesData.add(new RepositoryData(repositoryName));
            }
        }
        return repositoriesData;
    }
}
