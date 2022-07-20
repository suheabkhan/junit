package com.example.demo3;

public class Calculator {

    public int addNumbers(int firstNumber,int secondNumber){
        return firstNumber+secondNumber;
    }

    public int subtractNumbers(int firstNumber,int secondNumber){
        return firstNumber-secondNumber;
    }

    public int multiplyNumbers(int firstNumber,int secondNumber){
        return firstNumber*secondNumber;
    }

    public int divideNumbers(int firstNumber,int secondNumber){
        return firstNumber/secondNumber;
    }

    public int getRemainder(int firstNumber,int secondNumber){
        return 0;
    }

    public double computeCircleArea(double radius){
        return Math.PI*radius*radius;
    }

    String str;

    public void setStr(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
