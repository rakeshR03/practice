package com.Method;

public class MethodOverloadingWithThrownException {

}
class ArithmeticCalculator {

    // Method to divide two integers, might throw ArithmeticException (unchecked exception)
    public int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    // Method to divide two double values, might throw IllegalArgumentException (checked exception)
    public double divide(double a, double b) throws IllegalArgumentException {
        if (b == 0.0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    // Method to divide two integers, might throw NumberFormatException (unchecked exception)
    public int divide(String a, String b) throws NumberFormatException {
        try {
            int num1 = Integer.parseInt(a);
            int num2 = Integer.parseInt(b);
            if (num2 == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            return num1 / num2;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid number format");
        }
    }

//    public int divide(String a, String b) throws RuntimeException {
//        try {
//            int num1 = Integer.parseInt(a);
//            int num2 = Integer.parseInt(b);
//            if (num2 == 0) {
//                throw new ArithmeticException("Cannot divide by zero");
//            }
//            return num1 / num2;
//        } catch (NumberFormatException e) {
//            throw new NumberFormatException("Invalid number format");
//        }
//    }
}
