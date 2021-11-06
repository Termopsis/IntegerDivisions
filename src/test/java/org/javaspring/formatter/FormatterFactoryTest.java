package org.javaspring.formatter;

import org.javaspring.task4.formatter.*;
import org.javaspring.task4.formatter.formatterType.*;
import org.javaspring.task4.formatter.impl.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FormatterFactoryTest {

    @Test
    void shouldReturnStandardFormatter() {
        Formatter formatter = new FormatterFactory().getFormatter(TypeOfFormatters.STANDARD.toString());
        assertTrue(formatter instanceof StandardFormatter);
    }

    @Test
    void shouldReturnSimpleFormatter() {
        Formatter formatter = new FormatterFactory().getFormatter(TypeOfFormatters.SIMPLE.toString());
        assertTrue(formatter instanceof SimpleFormatter);
    }

    @Test
    void shouldReturnException() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new FormatterFactory().getFormatter("neverExistedType");
        });

        assertTrue(thrown.getMessage().contains("Type of formatter does not exist!"));
    }
}
