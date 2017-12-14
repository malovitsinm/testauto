package com.epam.strings.t01;

import lombok.Getter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CrazyLogger implements AutoCloseable {
    private StringBuilder logJournal;
    @Getter
    private int entryCount;

    final private Writer outputStream;
    final private String msgStartDelimiter;
    final private String msgEndDelimiter;
    final private String annotationMarker;
    @Getter
    final private DateTimeFormatter dateTimeFormatter;
    @Getter
    final private DateTimeFormatter shortDateTimeFormatter;

    public CrazyLogger(Writer outputStream, String msgStartDelimiter, String msgEndDelimiter,
                       String annotationMarker) {
        logJournal = new StringBuilder();
        this.outputStream = outputStream;
        this.msgStartDelimiter = msgStartDelimiter;
        this.msgEndDelimiter = msgEndDelimiter;
        this.annotationMarker = annotationMarker;
        dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy : HH-mm");
        shortDateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public CrazyLogger(Writer outputStream) {
        this(outputStream,
                " - ",
                ";",
                "@");
    }

    public CrazyLogger(Writer outputStream, String msgEndDelimiter) {
        this(outputStream,
                " - ",
                msgEndDelimiter,
                "@");
    }


    public void addEntry(String message, LocalDateTime dateTime, String... annotations) throws RuntimeException {
        if (message.contains(msgEndDelimiter))
            throw new RuntimeException("Added message contains delimiter symbol");
        if (message.contains(annotationMarker))
            throw new RuntimeException("Added message contains annotation symbol");
        logJournal.append(dateTime.format(dateTimeFormatter)).append(msgStartDelimiter);
        for (String annotation : annotations) {
            logJournal.append(annotationMarker).append(annotation).append(" ");
        }
        logJournal.append(annotationMarker).append("LogMsg: ").append(message).append(msgEndDelimiter);
        entryCount++;
    }


    public void addEntry(String message, String... annotations) throws RuntimeException {
        addEntry(message, LocalDateTime.now(), annotations);
    }


    public String getEntryByIndex(int index) throws IndexOutOfBoundsException {
        if ((index < 0) || (index >= entryCount))
            throw new IndexOutOfBoundsException(String.valueOf(index));
        String[] logEntries = logJournal.toString().split(msgEndDelimiter);
        return logEntries[index];
    }

    public StringBuilder getEntriesByDate(LocalDate date) {
        StringBuilder resultStringBuilder = new StringBuilder();
        for (int i = 0; i < entryCount; i++) {
            String entry = getEntryByIndex(i);
            if (entry.contains(date.format(shortDateTimeFormatter))) {
                resultStringBuilder.append(entry.substring(12)).append(msgEndDelimiter);
            }
        }
        return resultStringBuilder;
    }

    public StringBuilder getEntriesByDate(String date) {
        LocalDate localDate = LocalDate.parse(date, shortDateTimeFormatter);
        return getEntriesByDate(localDate);
    }

    public StringBuilder getEntriesByAnnotations(String... annotations) {
        StringBuilder resultStringBuilder = new StringBuilder();
        for (int i = 0; i < entryCount; i++) {
            boolean isAllAnnotationsContained = true;
            String entry = getEntryByIndex(i);
            for (String annotation: annotations) {
                if (!entry.contains(annotation))
                    isAllAnnotationsContained = false;
            }
            if (isAllAnnotationsContained)
                resultStringBuilder.append(entry).append(msgEndDelimiter);
        }
        return resultStringBuilder;
    }


    public String outputEntryByIndex(int index) throws IOException {
        String result = getEntryByIndex(index) + msgEndDelimiter;
        outputStream.write(result);
        return result;
    }

    public StringBuilder outputEntriesByDate(String date) throws IOException {
        StringBuilder result = getEntriesByDate(date);
        outputStream.write(result.toString());
        return result;
    }

    public StringBuilder outputEntriesByAnnotations(String... annotations) throws IOException {
        StringBuilder result = getEntriesByAnnotations(annotations);
        outputStream.write(result.toString());
        return result;
    }

    @Override
    public void close() throws IOException {
        outputStream.close();
    }
}
