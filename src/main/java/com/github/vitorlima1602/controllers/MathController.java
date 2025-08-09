package com.github.vitorlima1602.controllers;

import com.github.vitorlima1602.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )  {
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )  {
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )  {
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )  {

        if (convertToDouble(numberTwo) == 0.0 ){
            throw new UnsupportedMathOperationException("Cannot divide by zero");
        }

        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )  {
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    @RequestMapping("/squareRoot/{number}")
    public Double squareRoot(
            @PathVariable("number") String strNumber
    )  {
        double number = convertToDouble(strNumber);

        if (number < 0) {
            throw new UnsupportedMathOperationException("Cannot calculate square root of a negative number");
        }
        return  Math.sqrt(number);
    }

    private Double convertToDouble(String strNumber) throws IllegalArgumentException{
        if (strNumber == null || strNumber.isEmpty()) {
            throw new UnsupportedMathOperationException("Please send a valid number");
        }
        if (!isNumeric(strNumber)) {
            throw new UnsupportedMathOperationException("Please send a valid number");
        }
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) {
            return false;
        }
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?\\d*\\.?\\d+");
    }
}
