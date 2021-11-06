package org.javaspring;

import org.javaspring.task4.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleFormatterTest {
    SimpleFormatter simpleFormatter = new SimpleFormatter();

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
        simpleFormatter.format(result);

        StringBuilder builder = new StringBuilder();
        builder.append(result.getDividend());
        builder.append("/");
        builder.append(result.getDivisor());
        builder.append(" = ");
        builder.append(result.getQuotient());
        builder.append(";");
//        builder.append(" Reminder is ");
//        builder.append(result.getReminder());

        assertEquals(builder.toString(), simpleFormatter.format(result));
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
        simpleFormatter.format(result);

        StringBuilder builder = new StringBuilder();
        builder.append(result.getDividend());
        builder.append("/");
        builder.append(result.getDivisor());
        builder.append(" = ");
        builder.append(result.getQuotient());
        builder.append(";");
        builder.append(" Reminder is ");
        builder.append(result.getReminder());

        assertEquals(builder.toString(), simpleFormatter.format(result));
    }
}
