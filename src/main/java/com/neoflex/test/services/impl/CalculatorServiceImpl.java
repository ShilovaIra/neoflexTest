package com.neoflex.test.services.impl;

import com.neoflex.test.models.CalculationExpression;
import com.neoflex.test.models.CalculationResult;
import com.neoflex.test.models.enums.Operations;
import com.neoflex.test.services.CalculationService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculationService {

    @Override
    public CalculationResult calculate(String expression) {
        String[] operationAndOperands = getExpressionAsArrayFromString(expression);
        CalculationExpression calculationExpression = createExpression(operationAndOperands);
        return calculationExpression.calculate();
    }

    private String[] getExpressionAsArrayFromString(String expression) {
        String[] operationAndOperands = expression.split("(\\\\d+)|(\\\\d+)|(\\\\+|\\\\-|\\\\*|\\\\:)");
        return operationAndOperands;
    }

    private CalculationExpression createExpression(String[] operationAndOperands) {
        CalculationExpression calculationExpression = new CalculationExpression();

        StringBuilder firstOperand = new StringBuilder();
        int i = 0;
        while (operationAndOperands[i].matches("^[0-9]*$")) {
            firstOperand.append(operationAndOperands[i]);
            i++;
        }
        calculationExpression.setFirstOperand(getOperand(firstOperand.toString()));

        switch (operationAndOperands[i]) {
            case "+":
                calculationExpression.setOperation(Operations.ADDITION);
                break;
            case "-":
                calculationExpression.setOperation(Operations.SUBTRACTION);
                break;
            case ":":
                calculationExpression.setOperation(Operations.DIVIDING);
                break;
            case "*":
                calculationExpression.setOperation(Operations.MULTIPLYING);
                break;
        }
        i++;

        StringBuilder secondOperand = new StringBuilder();
        while (i < operationAndOperands.length && operationAndOperands[i].matches("^[0-9]*$")) {
            secondOperand.append(operationAndOperands[i]);
            i++;
        }
        calculationExpression.setSecondOperand(getOperand(secondOperand.toString()));

        return calculationExpression;
    }

    private Integer getOperand(String operand) {
        return Integer.parseInt(operand);
    }
}
