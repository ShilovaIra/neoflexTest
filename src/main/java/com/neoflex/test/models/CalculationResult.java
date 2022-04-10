package com.neoflex.test.models;

public class CalculationResult {

    private Object result;
    private String message;

    public CalculationResult() {
    }

    public CalculationResult(Object result, String message) {
        this.result = result;
        this.message = message;
    }

    public CalculationResult(String message) {
        this.message = message;
    }

    public CalculationResult(Object result) {
        this.result = result;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
