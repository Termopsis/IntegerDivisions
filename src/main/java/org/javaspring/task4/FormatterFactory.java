package org.javaspring.task4;

public class FormatterFactory{
    public Formatter getFormatter(String formatterName) {
        switch (formatterName) {
            case "STANDARD":
                return new StandardFormatter();
            case "SIMPLE":
                return new SimpleFormatter();
            default:
                throw new IllegalArgumentException("Type of formatter does not exist!");
        }
    }
}
