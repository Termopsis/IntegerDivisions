package org.javaspring.task4.formatter.impl;

import org.javaspring.task4.formatter.*;
import org.javaspring.task4.model.*;

public class StandardFormatter implements Formatter {

    @Override
    public String format(Result result) {
        StringBuilder builder = new StringBuilder();
        Utils utils = new Utils();

        int maxLengthDividerOrResult = Integer.max((int) Math.log10(result.getQuotient()) + 1,
                (int) Math.log10(result.getDivisor()) + 1);

        for (int i = 0; i < result.getMinuendList().size();) {
            int countSymbolsMinuend = Integer.toString(result.getMinuendList().get(i)).length();
            int countSymbolsSubtrahend = Integer.toString(result.getSubtrahendList().get(i)).length();
            int countSymbolsDividend = Integer.toString(result.getDividend()).length();
            int countSpaceAfterSubtrahend = countSymbolsDividend - countSymbolsSubtrahend;

            int countSpaceMinuend;
            int countSpaceSubtrahend;
            int countSpaceFinal = Integer.toString(result.getDividend()).length()
                    - Integer.toString(result.getReminder()).length() + 1;

            // This block creates first three string in result division
            if (i == 0) {
                builder.append("_").append(result.getDividend()).append("|").append(result.getDivisor()).append("\n");

                builder.append(utils.repeatSymbol(" ", 1)).append(result.getSubtrahendList().get(i))
                        .append(utils.repeatSymbol(" ", countSpaceAfterSubtrahend)).append("|")
                        .append(utils.repeatSymbol("-", maxLengthDividerOrResult)).append("\n");

                builder.append(utils.repeatSymbol(" ", 1))
                        .append(utils.repeatSymbol("-", countSymbolsSubtrahend))
                        .append(utils.repeatSymbol(" ", countSpaceAfterSubtrahend)).append("|")
                        .append(result.getQuotient()).append("\n");

                i++;
            }

            if (i < result.getDividendArrIndexList().size() && i < result.getMinuendList().size()) {
                countSpaceMinuend = result.getDividendArrIndexList().get(i) - countSymbolsMinuend;
                builder.append(utils.repeatSymbol(" ", countSpaceMinuend)).append("_")
                        .append(result.getMinuendList().get(i)).append("\n");

                countSpaceSubtrahend = result.getDividendArrIndexList().get(i) - countSymbolsSubtrahend;
                builder.append(utils.repeatSymbol(" ", countSpaceSubtrahend + 1))
                        .append(result.getSubtrahendList().get(i)).append("\n");
                builder.append(utils.repeatSymbol(" ", countSpaceSubtrahend + 1))
                        .append(utils.repeatSymbol("-",
                                Integer.toString(result.getSubtrahendList().get(i)).length()))
                        .append("\n");
                i++;
            }

            if (i >= result.getDividendArrIndexList().size() ) {
                builder.append(utils.repeatSymbol(" ", countSpaceFinal)).append(result.getReminder());
                break;
            }

            if (i >= result.getMinuendList().size() ) {
                builder.append(utils.repeatSymbol(" ", countSpaceFinal)).append(result.getReminder());
                break;
            }

        }
        return builder.toString();
    }

    private class Utils{
        public String repeatSymbol(String s, int count) {
            if (s == null) {
                throw new IllegalArgumentException("Word or symbol in method 'stringRepeat', cannot be blank!");
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                sb.append(s);
            }

            return sb.toString();
        }
    }
}
