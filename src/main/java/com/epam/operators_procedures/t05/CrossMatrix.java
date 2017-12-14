package com.epam.operators_procedures.t05;

import java.util.Arrays;

public class CrossMatrix {
    //All methods are declared as public in interest of full test coverage
    public char[][] generateMatrix(char[][] matrix) {
        int size = matrix.length;
        int i = 0;
        while (i < size) {
            int j = 0;
            Arrays.fill(matrix[i], '0');
            while (j < size) {
                if (i + j == size - 1 || i == j) {
                    matrix[i][j] = '1';
                }
                j++;
            }
            i++;
        }
        return matrix;
    }

    public int displayMatrix(int size, boolean isFormatted) throws RuntimeException {
        if (size < 3)
            throw new RuntimeException("Wrong size number received. Size number should be >= 3");
        char[][] matrix = new char[size][size];
        matrix = generateMatrix(matrix);
        if (isFormatted) {
            int i = 0;
            while (i < size) {
                System.out.println(Arrays.toString(matrix[i]));
                i++;
            }
            return 1;
        } else {
            System.out.println(Arrays.deepToString(matrix));
            return 0;
        }
    }

}
