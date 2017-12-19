package com.epam.strings.t01;

import lombok.Getter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/** This class provides a simple logging tool based on StringBuilder class
 * In order to solve the problem of boiler-plate code this class uses Project Lombok annotation processor.
 * For more details about this tool please refer to project Lombok
 * <a href='https://projectlombok.org/features/all">feature page</a>.
 *
 * */
public class CrazyLogger implements AutoCloseable {
    @Getter
    private int entryCount;

    @Getter
    final private DateTimeFormatter dateTimeFormatter;
    @Getter
    final private DateTimeFormatter shortDateTimeFormatter;

    final private Writer outputStream;
    final private String msgStartDelimiter;
    final private String msgEndDelimiter;
    final private String annotationMarker;

    private StringBuilder logJournal;

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

    /** A method which is used to add entry to the log on a specific date
     * @param message
     *          A message to log
     * @param dateTime
     *          Logging date
     * @param annotations
     *          Annotations (tags) used in log message
     * */
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

    /** A method which is used to add entry to the log
     * @param message
     *          A message to log
     * @param annotations
     *          Annotations (tags) used in log message
     * */
    public void addEntry(String message, String... annotations) throws RuntimeException {
        addEntry(message, LocalDateTime.now(), annotations);
    }


    /** A method which is used to get entry from log by its' index
     * @param index
     *          Message index in logger
     * @return entry
     *          A string containing logged message
     * @throws IndexOutOfBoundsException
     *          Exception raised in case of wrong index input
     * */
    public String getEntryByIndex(int index) throws IndexOutOfBoundsException {
        if ((index < 0) || (index >= entryCount))
            throw new IndexOutOfBoundsException(String.valueOf(index));
        String[] logEntries = logJournal.toString().split(msgEndDelimiter);
        return logEntries[index];
    }

    /** A method which is used to get all entries from the log by some date
     * @param date
     *          Date of logged messages
     * @return entries
     *          A stringBuilder containing all logged message on specific date
     * */
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

    /** A method which is used to get all entries from the log by some date in string format
     * @param date
     *          Date of logged messages in string format
     * @return entries
     *          A stringBuilder containing all logged message on specific date
     * */
    public StringBuilder getEntriesByDate(String date) {
        LocalDate localDate = LocalDate.parse(date, shortDateTimeFormatter);
        return getEntriesByDate(localDate);
    }


    /** A method which is used to get all entries from the log containing some specific annotation (tag)
     * @param annotations
     *          Array of annotations
     * @return entries
     *          A stringBuilder containing all logged message on specific date
     * */
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


    /** A method which is used to get and entry from the log by its' index and write it to outputStrem
     * @param index
     *          Date of logged messages in string format
     * @return entries
     *          A stringBuilder containing all logged message on specific date
     * @throws IOException
     *         An exception raised in case of stream errors
     * */
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
