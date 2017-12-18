package com.epam.strings.t02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.IllegalFormatException;

public class MainLoopRunner {
    private Quiz quiz;

    public MainLoopRunner(Quiz quiz) {
        this.quiz = quiz;
    }

    private enum Options {LOCALE, ANSWER}

    private int parseUserInput(String usrInput) throws NumberFormatException {
        Integer parsedInput = 0;
        parsedInput = Integer.valueOf(usrInput);
        return parsedInput;
    }

    private void menuSelect(int index, Options option) {
        switch (option) {
            case ANSWER:
                if (index >= quiz.getListSize() || index < 0) throw new RuntimeException(
                        "Selected index is out of bounds");
                quiz.showAnswer(index);
                break;
            case LOCALE:
                if (index >= Quiz.getSupportedLocales().size() || index < 0) throw new RuntimeException(
                        "Selected index is out of bounds");
                quiz.changeLocale(index);
                break;
        }
    }

    public void mainLoop() {
        System.out.println("Welcome to ?-quiz. Enter number of the question present on the screen to see the answer" +
                "\nEnter \"Exit\" to exit the program.");
        quiz.showFullInfo();
        boolean localeSelected = false;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                try {
                    String usrInput = reader.readLine();
                    if (usrInput.toLowerCase().equals("exit")) break;
                    int parsed = parseUserInput(usrInput);
                    if (parsed == 0 && !localeSelected) {
                        quiz.dialogLocale();
                        localeSelected = true;
                    } else if (!localeSelected) menuSelect(parsed, Options.ANSWER);
                    else {
                        menuSelect(parsed, Options.LOCALE);
                        quiz.showFullInfo();
                        localeSelected = false;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Please enter option number present on the screen");
                } catch (RuntimeException e) {
                    System.err.println("There is an error in user input: "
                            + e.getMessage()
                            + ".\nPlease try again.");
                }
            }
        } catch (IOException e) {
        }

    }
}
