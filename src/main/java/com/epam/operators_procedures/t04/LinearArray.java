package com.epam.operators_procedures.t04;

public class LinearArray {
    public double findMaximum(double[] array) {
        double maximum = 0.0;
        for (int i = 0; i < array.length / 2; i++) {
            maximum = Math.max(
                    maximum,
                    array[i] + array[array.length - 1 - i]
            );
        }
        if (array.length / 2 == 1) maximum = Math.max(maximum, array[array.length / 2 + 1]);
        return maximum;
    }
}
