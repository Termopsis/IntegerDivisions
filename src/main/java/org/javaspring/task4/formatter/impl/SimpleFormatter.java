package org.javaspring.task4.formatter.impl;

import org.javaspring.task4.formatter.*;
import org.javaspring.task4.model.*;

public class SimpleFormatter implements Formatter {
    @Override
    public String format(Result result) {
        StringBuilder builder = new StringBuilder();

        builder.append(result.getDividend());
        builder.append("/");
        builder.append(result.getDivisor());
        builder.append(" = ");
        builder.append(result.getQuotient());
        builder.append(";");

        if (result.getReminder() != 0){
            builder.append(" Reminder is ");
            builder.append(result.getReminder());
        }

        return builder.toString();
    }
}
