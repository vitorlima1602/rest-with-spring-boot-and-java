package com.github.vitorlima1602.request.converters;

import com.github.vitorlima1602.exception.UnsupportedMathOperationException;

public class NumberConverter {
    public static Double convertToDouble(String strNumber) throws IllegalArgumentException{
        if (strNumber == null || strNumber.isEmpty()) {
            throw new UnsupportedMathOperationException("Please send a valid number");
        }
        if (!isNumeric(strNumber)) {
            throw new UnsupportedMathOperationException("Please send a valid number");
        }
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) {
            return false;
        }
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?\\d*\\.?\\d+");
    }
}
