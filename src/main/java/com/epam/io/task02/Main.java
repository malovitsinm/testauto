package com.epam.io.task02;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        characterKeyWordCounter characterKeyWordCounter = new characterKeyWordCounter();
        characterKeyWordCounter.readFromFile(
                new File("src/main/java/com/epam/strings/t01","CrazyLogger.java"));
        characterKeyWordCounter.writeToFile(
                new File("src/main/java/com/epam/strings/t01","output.txt"));
    }
}
