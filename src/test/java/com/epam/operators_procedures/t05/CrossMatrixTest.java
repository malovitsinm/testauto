package com.epam.operators_procedures.t05;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrossMatrixTest {
    @Test
    public void generateMatrix() {
        CrossMatrix crossMatrix = new CrossMatrix();
        char[][] testMatrixInput = new char[3][3];
        char[][] testMatrix = {
                {'1','0','1'},
                {'0','1','0'},
                {'1','0','1'}};
        Assert.assertArrayEquals(testMatrix, crossMatrix.generateMatrix(testMatrixInput));
    }

    @Test(expected = RuntimeException.class)
    public void displayMatrixLesserValue() throws Exception {
        CrossMatrix crossMatrix = new CrossMatrix();
        crossMatrix.displayMatrix(-1,true);

    }

    @Test
    public void displayMatrixLargerValue(){
        CrossMatrix crossMatrix = new CrossMatrix();
        crossMatrix.displayMatrix(7,true);
    }

    @Test
    public void displayMatrixFormatted() {
        CrossMatrix crossMatrix = new CrossMatrix();
        Assert.assertEquals(1, crossMatrix.displayMatrix(5,true));

    }

    @Test
    public void displayMatrixNotFormatted(){
        CrossMatrix crossMatrix = new CrossMatrix();
        Assert.assertEquals(0, crossMatrix.displayMatrix(5,false));
    }

}