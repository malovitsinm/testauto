package com.epam.strings.t01;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String output = "";
        StringWriter stringWriter = new StringWriter();
        try(CrazyLogger crazyLogger = new CrazyLogger(stringWriter)){
            crazyLogger.addEntry("Str", "User: Chim", "Topic: Test");
            crazyLogger.addEntry("Save your life!", "User: Chim", "Warning: Red");
            crazyLogger.addEntry("Oh wait, don't.", "User: Chim", "Warning: Not", "Topic: Excuse");
            crazyLogger.outputEntryByIndex(0);
            crazyLogger.outputEntryByIndex(1);
            crazyLogger.outputEntryByIndex(2);
            System.out.println(crazyLogger.getEntriesByDate("02-12-2017"));
            System.out.println(crazyLogger.getEntriesByAnnotations("Warning"));
            output = stringWriter.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(output);
        System.out.println(LocalDate.parse("02-12-2017", DateTimeFormatter.ofPattern("dd-MM-yyyy")).toString());
        //System.out.println(crazyLogger.getEntryByIndex(0));
        //System.out.println(crazyLogger.getEntriesByDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-mm-YYYY : HH-mm"))));

    }
}
