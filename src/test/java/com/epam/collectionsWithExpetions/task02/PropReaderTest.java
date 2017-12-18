package com.epam.collectionsWithExpetions.task02;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PropReaderTest {
    @Test(expected = NullPointerException.class)
    public void loadNotExistingPropertyFile() throws Exception {
        PropReader propReader = new PropReader();
        propReader.loadProperty("/thatIsNotEvenAFileName");
    }

    @Test
    public void loadProperty() throws  Exception{
        PropReader propReader = new PropReader();
        propReader.loadProperty("/prop_en_US.properties");
        Assert.assertEquals("tempA5", propReader.getProperty("prop.answer5"));
    }

    @Test(expected =  NullPointerException.class)
    public void getNotExistingProperty() throws Exception {
        PropReader propReader = new PropReader();
        propReader.loadProperty("/prop_en_US.properties");
        propReader.getProperty("NotExistingPropertyName");
    }

    @Test
    public void setProperty() throws Exception {
        PropReader propReader = new PropReader();
        propReader.setProperty("testKey", "testValue");
        Assert.assertEquals("testValue", propReader.getProperty("testKey"));
    }

}