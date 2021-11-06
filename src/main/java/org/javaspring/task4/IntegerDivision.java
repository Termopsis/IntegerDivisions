package org.javaspring.task4;

import org.javaspring.task4.core.calculator.*;
import org.javaspring.task4.formatter.*;
import org.javaspring.task4.formatter.formatterType.*;
import org.javaspring.task4.model.*;

public class IntegerDivision {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();  // main computing class
        Result result = calculator.divide(400, 40);

        System.out.println(result);

        Formatter standardFormatter = new FormatterFactory().getFormatter(TypeOfFormatters.STANDARD.toString());
        System.out.println("\nstandardFormatter");
        System.out.println(standardFormatter.format(result));

        Formatter simpleFormatter = new FormatterFactory().getFormatter(TypeOfFormatters.SIMPLE.toString());
        System.out.println("\nsimpleFormatter");
        System.out.println(simpleFormatter.format(result));
    }
}
