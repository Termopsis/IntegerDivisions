package org.javaspring.task4;

public class IntegerDivision {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();  // main computing class
        Result result = calculator.divide(26, 2);
        //Formatter formatter = new FormatterFactory(); // Formatter is an interface

        System.out.println(result);
        System.out.println(new StandardFormatter().format(result));
    }
}
