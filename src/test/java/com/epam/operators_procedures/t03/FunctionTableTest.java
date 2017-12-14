package com.epam.operators_procedures.t03;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionTableTest {
    @Test
    public void calculateFunctionOnRange(){
        FunctionTable functionTable = new FunctionTable();
        functionTable.calculateFunctionOnRange(1,10,1);
    }

    @Test(expected = RuntimeException.class)
    public void calculateFunctionOnRangeSmallStep() throws Exception{
        FunctionTable functionTable = new FunctionTable();
        functionTable.calculateFunctionOnRange(1,10,0);
    }

    @Test(expected = RuntimeException.class)
    public void calculateFunctionOnRangeLargeStep() throws Exception{
        FunctionTable functionTable = new FunctionTable();
        functionTable.calculateFunctionOnRange(1,10,200);
    }

    @Test(expected = RuntimeException.class)
    public void calculateFunctionOnRangeBackwardSegment() throws Exception{
        FunctionTable functionTable = new FunctionTable();
        functionTable.calculateFunctionOnRange(10,1,2);
    }

    @Test
    public void calculateFunction() {
        FunctionTable functionTable = new FunctionTable();
        Assert.assertEquals(-9.79971, functionTable.calculateFunction(4),0.00005);
    }

}