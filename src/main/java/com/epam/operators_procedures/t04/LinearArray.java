package com.epam.operators_procedures.t04;

public class LinearArray {
    public double findMaximum(double[] array) {
        double maximum = 0.0;
        for (int i = 0; i < array.length / 2; i++) {
            int index = array.length - 1 - i;
            if (Double.compare(array[i], Double.MAX_VALUE) == 0
                    || Double.compare(array[index], Double.MAX_VALUE) == 0) maximum = Double.MAX_VALUE;
            else if (Double.compare(array[i], Double.MIN_VALUE) == 0
                    || Double.compare(array[index], Double.MIN_VALUE) == 0) continue;
            else maximum = Math.max(
                        maximum,
                        array[i] + array[index]
                );
        }
        if (array.length / 2 == 1) maximum = Math.max(maximum, array[array.length / 2 + 1]);
        return maximum;
    }
}
