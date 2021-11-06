package org.javaspring.task4;

import java.util.*;

public class Calculator {
    public Result divide(int dividend, int divisor){
        if (divisor == 0) {
            throw new IllegalArgumentException("Value cannot be divided by zero.");
        }

        Utils utils = new Utils();
        List<Integer> minuendList = new ArrayList<>(); //уменьшаемое
        List<Integer> subtrahendList = new ArrayList<>(); // вычитаемое
        List<Integer> dividendArrIndexList = new ArrayList<>(); //делители

        int dividendArrIndex = 0; // индекс делителя
        int result = 0;
        int minuend = 0; // тек уменьшаемое
        int subtrahend = 0; // вычитаемое
        int minuendCount = 0; //уменьшаемое количество
        int breakStatus = 0;

        int lengthDividend = utils.countDigit(dividend);
        int[] dividendArr = utils.intToArray(dividend);

        //если будет результат деления 0. делимое 10 делитель 11
        if (dividend < divisor){
            minuendList.add(0);
            subtrahendList.add(0);
            dividendArrIndexList.add(0);
            return new Result(dividend,
                    divisor,
                    0,
                    dividend,
                    minuendList,
                    subtrahendList,
                    dividendArrIndexList);
        }

        //Проходим по каждой цифре делимого
        while (dividendArrIndex < lengthDividend){

            //Определяем макс число для деления
            //Набираем цифры из divisor
            while (minuend < divisor) {
                // первая итерация 0 * 10 + число из делителей по индексу 0
                minuend = minuend * 10 + dividendArr[dividendArrIndex];
                dividendArrIndex++;


                if (dividendArrIndex == lengthDividend && minuendCount > 0) {
                    breakStatus++;
                    break;
                }

                //Проверка что делимое меньше делителя
                //Если делимое получилось меньше делителя то будет 0 в результат плюсом. Т.к. возьмем новое число из делимого
                if (result > 0 && minuend < divisor) {
                    //?
                    result = result * 10 + 0;
                }
            }

            //Определяем результат деления
            result = result*10+(minuend / divisor);

            //Сколько нужно вычесть
            subtrahend = (minuend / divisor) * divisor;
            dividendArrIndexList.add(dividendArrIndex);

            if (minuendCount >= 1 && breakStatus == 0) {
                minuendList.add(minuend);
                subtrahendList.add(subtrahend);
            } else if (breakStatus == 0) {
                minuendList.add(minuend);
                subtrahendList.add(subtrahend);
                minuendCount++;
            }

            //Если больше одного частного или результата
            if (dividendArrIndex == lengthDividend && subtrahend != 0 && lengthDividend > 1) {
                minuendList.add(minuend);
                subtrahendList.add(subtrahend);
            }

            //Сколько остаток после вычитания
            minuend = minuend - subtrahend;
            //обнуляем число которое вычли. Которе получилось после перемножения. Так сказать целое число.
            subtrahend = 0;

            //Дошли до конца цифр. Результат?
            //Остановка цикла здесь для определение остатка
            if (dividendArrIndex == lengthDividend) {
                //остаток от деления
                break;
            }
        }

        return new Result(dividend,
                divisor,
                result,
                minuend,
                minuendList,
                subtrahendList,
                dividendArrIndexList);
    }

    private class Utils{
        public int countDigit(int num) {
            return (num < 10) ? 1 : (int) (Math.log10(num) + 1);
        }

        public int[] intToArray(int num) {
            int[] digits = new int[countDigit(num)];
            for (int i = 0; i < digits.length; i++) {
                digits[digits.length - 1 - i] = num % 10;
                num /= 10;
            }
            return digits;
        }
    }
}
