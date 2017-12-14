package com.epam.operators_procedures.t02;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EpsilonSequenceTest {
    @Test
    public void epsilonCompareEquals() {
        EpsilonSequence epsilonSequence = new EpsilonSequence();
        Assert.assertEquals(true, epsilonSequence.epsilonCompare(0.25,0.25));
    }

    @Test
    public void epsilonCompareLesser() {
        EpsilonSequence epsilonSequence = new EpsilonSequence();
        Assert.assertEquals(false, epsilonSequence.epsilonCompare(0.001,0.25));
    }

    @Test
    public void epsilonCompareLarger() {
        EpsilonSequence epsilonSequence = new EpsilonSequence();
        Assert.assertEquals(true, epsilonSequence.epsilonCompare(0.25,0.001));
    }

    @Test(expected = RuntimeException.class)
    public void calculateFunctionParameterLessThanAccepted() throws Exception {
        EpsilonSequence epsilonSequence = new EpsilonSequence();
        epsilonSequence.calculateFunction(-1);
    }

    @Test
    public void calculateFunctionParameterLargerThanAccepted() {
        EpsilonSequence epsilonSequence = new EpsilonSequence();
        Assert.assertEquals( 0.00591,epsilonSequence.calculateFunction(12),0.00001);
    }

    @Test
    public void displayNumbersUntilEpsilonCondition() {
        EpsilonSequence epsilonSequence = new EpsilonSequence();
        epsilonSequence.displayNumbersUntilEpsilonCondition(0.0025);
    }
}