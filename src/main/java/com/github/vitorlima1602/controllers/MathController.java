package com.github.vitorlima1602.controllers;

import com.github.vitorlima1602.exception.UnsupportedMathOperationException;
import com.github.vitorlima1602.math.SimpleMath;
import com.github.vitorlima1602.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {
    private SimpleMath math = new SimpleMath();

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )  {

        return math.sum(
                NumberConverter.convertToDouble(numberOne),
                NumberConverter.convertToDouble(numberTwo)
        );

    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )  {
        return math.subtraction(
                NumberConverter.convertToDouble(numberOne),
                NumberConverter.convertToDouble(numberTwo)
        );
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )  {
        return math.multiplication(
                NumberConverter.convertToDouble(numberOne),
                NumberConverter.convertToDouble(numberTwo)
        );
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )  {

        return math.division(
                NumberConverter.convertToDouble(numberOne),
                NumberConverter.convertToDouble(numberTwo)
        );
    }

    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )  {
        return math.mean(
                NumberConverter.convertToDouble(numberOne),
                NumberConverter.convertToDouble(numberTwo)
        );
    }

    @RequestMapping("/squareRoot/{number}")
    public Double squareRoot(
            @PathVariable("number") String strNumber
    )  {
        Double number = NumberConverter.convertToDouble(strNumber);

        return math.squareRoot(number);
    }
}
