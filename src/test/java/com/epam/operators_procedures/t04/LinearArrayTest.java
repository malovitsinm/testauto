package com.epam.operators_procedures.t04;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinearArrayTest {
    @Test
    public void findMaximum() throws Exception {
        LinearArray linearArray = new LinearArray();
        double[] testCase1 = {75.0, 0, 0 , 0};
        double[] testCase2 = {8563.0, 0, 0 ,0, 0};
        double[] testCaseMaxVal = {Double.MAX_VALUE,0,0,Double.MAX_VALUE};
        double[] testCaseMinVal = {Double.MIN_VALUE,0,0,Double.MIN_VALUE};
        double[] testCasePosPosInf = {Double.POSITIVE_INFINITY, 0 ,0, Double.POSITIVE_INFINITY};
        double[] testCasePosNegInf = {Double.POSITIVE_INFINITY, 0 ,0, Double.NEGATIVE_INFINITY};
        Assert.assertEquals(75.0, linearArray.findMaximum(testCase1), 0.0005);
        Assert.assertEquals(8563.0, linearArray.findMaximum(testCase2), 0.0005);
        Assert.assertEquals(Double.MAX_VALUE, linearArray.findMaximum(testCaseMaxVal), 0.0005);
        Assert.assertEquals(0.0, linearArray.findMaximum(testCaseMinVal), 0.0005);
        Assert.assertEquals(Double.POSITIVE_INFINITY, linearArray.findMaximum(testCasePosPosInf), 0.0005);
        Assert.assertEquals(Double.NaN, linearArray.findMaximum(testCasePosNegInf), 0.0005);


    }

}