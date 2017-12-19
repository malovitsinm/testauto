package com.epam.io.task02;

import lombok.SneakyThrows;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class characterKeyWordCounter {
    final static Pattern keyWordPattern = Pattern.compile(
            "\\bbyte\\b|\\bshort\\b|\\bint\\b|\\blong\\b|\\bchar\\b|\\bfloat\\b|\\bdouble\\b|\\bboolean\\b|" +
                    "\\bif\\b|\\belse\\b|\\bswitch\\b|\\bcase\\b|\\bdefault\\b|\\bwhile\\b|\\bdo\\b|\\bbreak\\b|" +
                    "\\bcontinue\\b|\\bfor\\b|\\btry\\b|\\bcatch\\b|\\bfinally\\b|\\bthrow\\b|\\bthrows\\b|" +
                    "\\bprivate\\b|\\bprotected\\b|\\bpublic\\b|\\bimport\\b|\\bpackage\\b|\\bclass\\b|\\binterface\\b|" +
                    "\\bextends\\b|\\bimplements\\b|\\bstatic\\b|\\bfinal\\b|\\bvoid\\b|\\babstract\\b|\\bnative\\b|" +
                    "\\bnew\\b|\\breturn\\b|\\bthis\\b|\\bsuper\\b|\\bsynchronized\\b|\\bvolatile\\b|\\bconst\\b|" +
                    "\\bgoto\\b|\\binstanceof\\b|\\benum\\b|\\bassert\\b|\\btransient\\b|\\bstrictfp\\b");

    private Map<String, Integer> keyWordMap = new HashMap<>();

    @SneakyThrows
    public void readFromFile(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) break;
                Matcher matcher = keyWordPattern.matcher(line);
                while (matcher.find()) {
                    String grabedWord = matcher.group();
                    Integer newValue = keyWordMap.containsKey(grabedWord) ? keyWordMap.get(grabedWord) : 0;
                    keyWordMap.put(grabedWord, newValue + 1);
                }
            }
        }
    }

    @SneakyThrows
    public void writeToFile(File file) {
        StringBuilder fileLineBuilder = new StringBuilder();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (String key : keyWordMap.keySet()) {
                fileLineBuilder.append(key).append("=").append(keyWordMap.get(key));
                bufferedWriter.write(fileLineBuilder.toString());
                bufferedWriter.newLine();
                fileLineBuilder = new StringBuilder();
            }
        }
    }
}
