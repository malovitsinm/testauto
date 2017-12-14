package com.epam.operators_procedures.t03;

public class FunctionTable {

    public void calculateFunctionOnRange(int lowBorder, int highBorder, int step) throws RuntimeException {
        if (step < 1)
            throw new RuntimeException("Step value is lesser than 1");
        if (step > Math.abs(highBorder - lowBorder))
            throw new RuntimeException("Step value is larger than segment length");
        if (highBorder < lowBorder)
            throw new RuntimeException("Incorrect segment borders");
        System.out.printf("{F(x) = tan(2*x) - 3} results on [%d, %d] with x augmentation by %d:%n",
                    lowBorder, highBorder, step);
        while (lowBorder <= highBorder) {
            System.out.printf("x = %d | y = %.3f%n", lowBorder, calculateFunction(lowBorder));
            lowBorder += step;
        }
    }

    public double calculateFunction(int parameter) {
        return Math.tan(2 * parameter) - 3.0;
    }
}
