package org.javaspring;

import org.javaspring.task4.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandardFormatterTest {
    Calculator calculator = new Calculator();
    StandardFormatter standardFormatter = new StandardFormatter();

    @Test
    void testShouldDivision400And40() {

        Result result = calculator.divide(400, 40);
        standardFormatter.format(result);

        StringBuilder sb = new StringBuilder();
        sb.append("_400|40").append("\n")
                .append(" 40 |--").append("\n")
                .append(" -- |10").append("\n")
                .append("   0");

        assertEquals(sb.toString(), standardFormatter.format(result));
    }

    @Test
    void testShouldDivision123456And123() {

        Result result = calculator.divide(123456, 123);
        standardFormatter.format(result);

        StringBuilder sb = new StringBuilder();
        sb.append("_123456|123").append("\n")
                .append(" 123   |----").append("\n")
                .append(" ---   |1003").append("\n")
                .append("   _456").append("\n")
                .append("    369").append("\n")
                .append("    ---").append("\n")
                .append("     87");

        assertEquals(sb.toString(), standardFormatter.format(result));
    }

    @Test
    void testDivisionZeroAndSeven() {

        Result result = calculator.divide(0, 7);
        standardFormatter.format(result);

        StringBuilder sb = new StringBuilder();
        sb.append("_0|7").append("\n")
                .append(" 0|-").append("\n")
                .append(" -|0").append("\n")
                .append(" 0");

        assertEquals(sb.toString(), standardFormatter.format(result));
    }

    @Test
    void testDivision123And1() {

        Result result = calculator.divide(123, 1);
        standardFormatter.format(result);

        StringBuilder sb = new StringBuilder();
        sb.append("_123|1").append("\n")
                .append(" 1  |---").append("\n")
                .append(" -  |123").append("\n")
                .append(" _2").append("\n")
                .append("  2").append("\n")
                .append("  -").append("\n")
                .append("  _3").append("\n")
                .append("   3").append("\n")
                .append("   -").append("\n")
                .append("   0");

        assertEquals(sb.toString(),standardFormatter.format(result));

    }
}
