package com.epam.operators_procedures.t04;

public class Main {
    public static void main(String[] args) {
        LinearArray linearArray = new LinearArray();
        double[] array = {1.0, 2.0, 5.88, 7.98, 25.15, 12.7};
        System.out.println(linearArray.findMaximum(array));
    }
}
