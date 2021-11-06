package org.javaspring.core.calculator;

import org.javaspring.task4.core.calculator.*;
import org.javaspring.task4.model.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }

    @Test
    void testDivisibleLessDivisor(){
        List<Integer> minuendList = new ArrayList<Integer>();
        minuendList.add(0);
        List<Integer> subtrahendList = new ArrayList<Integer>();
        subtrahendList.add(0);
        List<Integer> dividendArrIndexList = new ArrayList<Integer>();
        dividendArrIndexList.add(0);

        Result expected = new Result(1, 2, 0, 1, minuendList, subtrahendList, dividendArrIndexList);
        Result actual = calculator.divide(1, 2);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void testNormalWorkCalculator(){
        List<Integer> minuendList = new ArrayList<Integer>();
        minuendList.add(405);
        minuendList.add(225);
        List<Integer> subtrahendList = new ArrayList<Integer>();
        subtrahendList.add(405);
        subtrahendList.add(225);
        List<Integer> dividendArrIndexList = new ArrayList<Integer>();
        dividendArrIndexList.add(3);
        dividendArrIndexList.add(7);
        dividendArrIndexList.add(9);

        Result expected = new Result(405022500, 45, 9000500, 0, minuendList, subtrahendList, dividendArrIndexList);
        Result actual = calculator.divide(405022500, 45);

        assertEquals(expected.toString(), actual.toString());
    }
}
