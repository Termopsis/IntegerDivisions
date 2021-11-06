package org.javaspring;

import org.javaspring.task4.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandardFormatterTest {
    StandardFormatter standardFormatter = new StandardFormatter();

    @Test
    void testShouldDivision400And40() {
        List<Integer> minuendList = new ArrayList<Integer>();
        minuendList.add(40);
        List<Integer> subtrahendList = new ArrayList<Integer>();
        subtrahendList.add(40);
        List<Integer> dividendArrIndexList = new ArrayList<Integer>();
        dividendArrIndexList.add(2);
        dividendArrIndexList.add(3);

        Result result = new Result(400, 40, 10, 0, minuendList, subtrahendList, dividendArrIndexList);
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
        List<Integer> minuendList = new ArrayList<Integer>();
        minuendList.add(123);
        minuendList.add(456);
        List<Integer> subtrahendList = new ArrayList<Integer>();
        subtrahendList.add(123);
        subtrahendList.add(369);
        List<Integer> dividendArrIndexList = new ArrayList<Integer>();
        dividendArrIndexList.add(3);
        dividendArrIndexList.add(6);

        Result result = new Result(123456, 123, 1003, 87, minuendList, subtrahendList, dividendArrIndexList);
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
        List<Integer> minuendList = new ArrayList<Integer>();
        minuendList.add(0);
        List<Integer> subtrahendList = new ArrayList<Integer>();
        subtrahendList.add(0);
        List<Integer> dividendArrIndexList = new ArrayList<Integer>();
        dividendArrIndexList.add(0);

        Result result = new Result(0, 7, 0, 0, minuendList, subtrahendList, dividendArrIndexList);
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
        List<Integer> minuendList = new ArrayList<>();
        minuendList.add(1);
        minuendList.add(2);
        minuendList.add(3);
        List<Integer> subtrahendList = new ArrayList<Integer>();
        subtrahendList.add(1);
        subtrahendList.add(2);
        subtrahendList.add(3);
        List<Integer> dividendArrIndexList = new ArrayList<Integer>();
        dividendArrIndexList.add(1);
        dividendArrIndexList.add(2);
        dividendArrIndexList.add(3);

        Result result = new Result(123, 1, 123, 0, minuendList, subtrahendList, dividendArrIndexList);
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
