package com.neoflex.test.models;

import com.neoflex.test.models.enums.Operations;
import lombok.Data;

@Data
public class CalculationExpression {

    private Integer firstOperand;
    private Integer secondOperand;
    private Operations operation;

    public CalculationResult calculate() {

        if (this.operation.equals(Operations.ADDITION)) {
            return new CalculationResult(this.firstOperand + this.secondOperand, "success");
        }
        else if (this.operation.equals(Operations.SUBTRACTION)) {
            return new CalculationResult(this.firstOperand - this.secondOperand, "success");
        }
        else if (this.operation.equals(Operations.DIVIDING)) {
            if (secondOperand.equals(0)) {
                return new CalculationResult("Dividing by 0 is incorrect!");
            }
            return new CalculationResult(this.firstOperand.doubleValue() / this.secondOperand.doubleValue(), "success");
        }
        else if (this.operation.equals(Operations.MULTIPLYING)) {
            return new CalculationResult(this.firstOperand * this.secondOperand, "success");
        }

        return null;
    }

}
