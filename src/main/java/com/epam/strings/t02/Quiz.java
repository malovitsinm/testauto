package com.epam.strings.t02;

import lombok.Getter;

import java.util.*;
/**
 * In order to solve the problem of boiler-plate code this class uses Project Lombok annotation processor.
 * For more details about this tool please refer to project Lombok
 * <a href='https://projectlombok.org/features/all">feature page</a>.
 *
 * */
public class Quiz {
    @Getter
    private static List<Locale> supportedLocales = new ArrayList<>(
            Arrays.asList(
                    new Locale("en_US"),
                    new Locale("ru_RU")
            )
    );
    private Map<String, ResourceBundle> bundleMap = new HashMap<>();
    private Locale curLocale;
    private ResourceBundle curBundle;
    private List<String> questionList = new ArrayList<>();
    private List<String> answerList = new ArrayList<>();

    public Quiz(Locale locale) {
        for (Locale supportedLocale : supportedLocales) {
            bundleMap.put(supportedLocale.toString(),
                    ResourceBundle.getBundle("prop", supportedLocale));
        }
        changeLocale(locale);
    }

    public void changeLocale(Locale newLocale) {
        if (!bundleMap.containsKey(newLocale.toString())) throw new RuntimeException("Locale not found");
        curLocale = newLocale;
        questionList.clear();
        answerList.clear();
        curBundle = bundleMap.get(newLocale.toString());
        for (int i = 1; i <= Integer.valueOf(curBundle.getString("prop.sysInfo.entryCount")); i++) {
            questionList.add(curBundle.getString("prop.question" + i));
            answerList.add(curBundle.getString("prop.answer" + i));
        }
    }

    public int getListSize(){
        return questionList.size();
    }

    public void changeLocale(int index){
        changeLocale(supportedLocales.get(index));
    }

    void dialogLocale() {
        int i = 0;
        System.out.println(curBundle.getString("prop.sysInfo.chooseLocale"));
        for (Locale locale : supportedLocales) {
            System.out.printf("[%d]: " + locale.toString() + "\n", i);
            i++;
        }
    }

    void showFullInfo(){
        showLocaleInfo();
        showQuestions();
    }

    private void showLocaleInfo() {
        String localeInfo = curBundle.getString("prop.sysInfo.localeInfo");
        System.out.printf("[0] " + localeInfo + "\n");
    }

    private void showQuestions() {
        int i = 1;
        String questionInfo = curBundle.getString("prop.sysInfo.question");
        for (String question : questionList) {
            System.out.printf("[%d] " + questionInfo + " %d: " + question + "\n", i, i);
            i++;
        }
    }

    void showAnswer(int answerIndex) {
        String questionInfo = curBundle.getString("prop.sysInfo.question");
        String answerInfo = curBundle.getString("prop.sysInfo.answer");
        System.out.printf(questionInfo.substring(0, 1) + "%d: " +
                questionList.get(answerIndex - 1) + "\n", answerIndex);
        System.out.println(answerInfo + ": " + answerList.get(answerIndex - 1));
    }
}
