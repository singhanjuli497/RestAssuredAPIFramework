package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropOperation {

    private static FileInputStream fileInputStream;

    static String env = "qa";
    static String filePath = "./src/main/resources/"+env+".properties";

    public static String getEnvProperty(String key) {
        //File file = new File(filePath);
        try {
             fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Properties prop = new Properties();
        try {
            prop.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}
