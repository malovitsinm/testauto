package com.epam.collectionsWithExpetions.task02;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropReader {
    private Map<String, String> propertyMap;

    public PropReader() {
        propertyMap = new HashMap<>();
    }

    public void loadProperty(String name) throws NullPointerException, IOException {
        Properties properties = new Properties();
        try (InputStream inputStream = Class.class.getResourceAsStream(name)) {
            properties.load(inputStream);
            for (String key : properties.stringPropertyNames()) propertyMap.put(key, properties.getProperty(key));
        }
        catch (NullPointerException e){ throw new NullPointerException("No such file found with given name");}
        catch (IOException e){throw  new IOException("Error encountered while trying to close .properties file");}
    }

    public String getProperty(String key) throws NullPointerException{
        String value = propertyMap.get(key);
        if (value == null) throw new NullPointerException("No such key in properties map");
        return value;
    }

    public void setProperty(String key, String value) {
        propertyMap.put(key, value);
    }
}
