package org.javaspring.task4;

import lombok.*;

import java.util.*;

@Getter
public class Result {
    private final int dividend; //делимое
    private final int divisor; //делитель
    private final int quotient; //частное
    private final int reminder; //остаток от деления
    private final List<Integer> minuendList; //уменьшаемое
    private final List<Integer> subtrahendList; //вычитаемое
    private final List<Integer> dividendArrIndexList; //делители

    public Result(int dividend,
                  int divisor,
                  int quotient,
                  int reminder,
                  List<Integer> minuendList,
                  List<Integer> subtrahendList,
                  List<Integer> dividendArrIndexList) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
        this.reminder = reminder;
        this.minuendList = Collections.unmodifiableList(minuendList);
        this.subtrahendList = Collections.unmodifiableList(subtrahendList);
        this.dividendArrIndexList = Collections.unmodifiableList(dividendArrIndexList);
    }

    @Override
    public String toString() {
        return "Result [dividend=" + dividend + ", divisor=" + divisor + ", quotient=" + quotient + ", reminder="
                + reminder + ", minuendList=" + minuendList + ", subtrahendList=" + subtrahendList
                + ", dividendArrIndexList=" + dividendArrIndexList + "]";
    }
}
