package com.example.todo_9;

public class Calculator {
    public double Add (double value1, double value2 ){
        return value1 + value2;

    }

    public double Sub (double value1, double value2 ){
        return value1 - value2;

    }

    public double Mul (double value1, double value2 ){
        return value1 * value2;

    }

    public double Div (double value1, double value2 ){
        if (value2==0){
            throw new IllegalArgumentException("The divisor is Zero");
        }
        return value1 / value2;


    }
}
