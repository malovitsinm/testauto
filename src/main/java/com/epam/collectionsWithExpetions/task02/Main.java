package com.epam.collectionsWithExpetions.task02;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        PropReader propReader = new PropReader();
        try {
            propReader.loadProperty("/crop_en_US.properties");
        } catch (NullPointerException | IOException e){
            System.err.println(e.getMessage());
        }
        try {
            System.out.println(propReader.getProperty("rumo"));
        } catch (NullPointerException e){
            System.err.println(e.getMessage());
        }
    }
}
