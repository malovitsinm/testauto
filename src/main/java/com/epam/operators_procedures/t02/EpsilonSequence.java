package com.epam.operators_procedures.t02;

public class EpsilonSequence {
    /*
    Найти наименьший номер элемента последовательности, для которого выполняется условие M.
    Вывести на экран этот номер и все элементы a_i  где i = 1, 2, ..., п.
    Где последовательность задаётся как 1/(x + 1)^2, а условие M: a_n < eps
    * */

    public void displayNumbersUntilEpsilonCondition(double epsilon) {
        int n = 1;
        double funcResult = calculateFunction(n);
        while (epsilonCompare(funcResult, epsilon)) {
            System.out.printf("a_%d = %.3f%n", n, funcResult);
            n++;
            funcResult = calculateFunction(n);
        }

    }

    public boolean epsilonCompare(double functionValue, double epsilon) {
        return Double.compare(functionValue, epsilon) != -1;
    }

    public double calculateFunction(int parameter) {
        if (parameter < 1)
            throw new RuntimeException("N parameter must be 1 or greater");
        return 1.0 / Math.pow(parameter + 1.0, 2);
    }
}
