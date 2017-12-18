package com.epam.strings.t02;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        MainLoopRunner mlr = new MainLoopRunner(new Quiz(new Locale("en_US")));
        mlr.mainLoop();
    }
}
