package utils;

import java.io.*;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;

    public static Properties initProperties() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("src/test/resources/config.properties");
            prop.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static String get(String key) {
        if (prop == null) {
            initProperties();
        }
        return prop.getProperty(key);
    }
}