package com.maker.cms.utils;

import java.math.BigDecimal;

public class NumberFormatter {
    private NumberFormatter() {
    }

    public static double round(double value) {
        return NumberFormatter.round(value, 4);
    }

    public static double round(double value, int numberOfDigitsAfterDecimalPoint) {
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(numberOfDigitsAfterDecimalPoint, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }
}
