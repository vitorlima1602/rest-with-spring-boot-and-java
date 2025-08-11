package com.github.vitorlima1602.math;

import com.github.vitorlima1602.exception.UnsupportedMathOperationException;

public class SimpleMath {
    public Double sum(
             Double numberOne,
             Double numberTwo
    )  {
        return numberOne + numberTwo;
    }

    public Double subtraction(
            Double numberOne,
            Double numberTwo
    )  {
        return numberOne - numberTwo;
    }

    public Double multiplication(
            Double numberOne,
            Double numberTwo
    )  {
        return numberOne * numberTwo;
    }

    public Double division(
            Double numberOne,
            Double numberTwo
    )  {

        if (numberTwo == 0.0 ){
            throw new UnsupportedMathOperationException("Cannot divide by zero");
        }

        return numberOne / numberTwo;
    }

    public Double mean(
            Double numberOne,
            Double numberTwo
    )  {
        return (numberOne + numberTwo) / 2;
    }

    public Double squareRoot(
            Double number
    )  {
    if (number < 0) {
            throw new UnsupportedMathOperationException("Cannot calculate square root of a negative number");
        }
        return  Math.sqrt(number);
    }
}
