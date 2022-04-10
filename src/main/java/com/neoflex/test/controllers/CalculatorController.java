package com.neoflex.test.controllers;

import com.neoflex.test.models.CalculationResult;
import com.neoflex.test.services.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calculate")
public class CalculatorController {

    @Autowired
    private CalculationService calculationService;

    @GetMapping("/{expression}")
    public ResponseEntity<CalculationResult> calculate (@PathVariable String expression) {
        System.out.println(expression);
        CalculationResult calculationResult = calculationService.calculate(expression);
        return null != calculationResult ? new ResponseEntity<>(calculationResult, HttpStatus.OK):
                new ResponseEntity("Something went wrong. Use only positive integers and '+ - * :' operations", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{expression}/{expression}")
    public ResponseEntity<CalculationResult> calculate (@PathVariable String firstExpression,
                                                        @PathVariable String secondExpression) {
        return new ResponseEntity("Please, use ':' instead of '/' for dividing :)", HttpStatus.OK);
    }

}
