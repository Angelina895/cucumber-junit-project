package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// This class is only one time we are creating in the utilities package
// you will just call getproperty method with this class name
public class ConfigurationReader {
    // it is static because we using it in static method and static block
    // it is private because I will be using only in this class
  private static Properties properties = new Properties();

     //we want to open the properties file and load to properties object ONLY ONCE before reading
    // having static block because static runs first
    static {


        try {


            FileInputStream file = new FileInputStream("configuration.properties");
            // Load the properties object using FileInputStream object
            // Load " properties" object with the "file" we opened using FileInputStream
            properties.load(file);


            // close the file after loading
            // if we do not close the file, it will take space from computer memory (like Scanner)
            file.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    /*
    This method is used to read value from a configuration.properties file
    @param keyword --> key name in configuration.properties file
    @return --> value from the key. returns null if key is not found
    driver.get(configurationReader.getProperty("env")
     */
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}
