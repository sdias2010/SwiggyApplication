package com.simplilearn;

import java.io.*;
import java.util.Properties;

public class Configuration {

    final static String PROJECT_PROPERTY_FILE = "project.properties";

    static Properties properties = null;

    static void loadPropertiesIfNotLoadedAlready(){
        if(properties == null){
            properties = new Properties();
            //String propFilePath = System.getProperty("user.dir") + "/src/test/resources/" + PROJECT_PROPERTY_FILE;
            String propFilePath = "/resources/" + PROJECT_PROPERTY_FILE; //setup for jar file
            try {
                //InputStream inputStream = new FileInputStream(propFilePath);
                InputStream inputStream = Configuration.class.getResourceAsStream(propFilePath);
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(String name){
        loadPropertiesIfNotLoadedAlready();
        return properties.getProperty(name);
    }
}
