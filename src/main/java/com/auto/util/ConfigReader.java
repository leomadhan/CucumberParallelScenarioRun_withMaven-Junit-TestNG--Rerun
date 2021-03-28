package com.auto.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties props;

    public Properties accessProp(){
        props=new Properties();
        try{
            FileInputStream file=new FileInputStream("./src/test/resources/config/config.properties");
            props.load(file);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return props;
    }
}
