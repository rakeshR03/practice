package com.BigDecimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bdFromString = new BigDecimal("123.4");
        BigDecimal bdFromCharArray = new BigDecimal(new char[]{'1', '.', '3', '4'});
        BigDecimal bdFromInt = new BigDecimal(1234);
        BigDecimal bdFromLong = new BigDecimal(12345678l);
        BigDecimal bdFromFloat = new BigDecimal(1.23f);
        BigDecimal bdFromDouble = new BigDecimal(0.1d);

        System.out.println("bdFromString : " + bdFromString);
        System.out.println("bdFromCharArray : " + bdFromCharArray);
        System.out.println("bdFromInt : " + bdFromInt);
        System.out.println("bdFromLong : " + bdFromLong);
        System.out.println("bdFromFloat : " + bdFromFloat);
        System.out.println("bdFromDouble : " + bdFromDouble);

        // To convert double to BigDecimal, use static method valueOf()
        BigDecimal bdFromFloat1 = BigDecimal.valueOf(1.23f);
        BigDecimal bdFromDouble1 = BigDecimal.valueOf(0.1d);

        System.out.println("bdFromFloat1 : " + bdFromFloat1);
        System.out.println("bdFromDouble1 : " + bdFromDouble1);

        // To convert float to BigDecimal, convert to String first and then convert string to BigDecimal
        BigDecimal bdFromFloat2 = new BigDecimal(String.valueOf( 1.23f));
        float f = 1.23f;
        double d = f;
        BigDecimal bdFromFloat3 = BigDecimal.valueOf(d);

        System.out.println("bdFromFloat2 : " + bdFromFloat2);
        System.out.println("bdFromFloat3 : " + bdFromFloat3);

        // operations
        BigDecimal bd = new BigDecimal("-123.45");
        System.out.println("precision : " + bd.precision());
        System.out.println("scale : " + bd.scale());
        System.out.println("signum : " + bd.signum());

        // compare two BigDecimal number
        BigDecimal bd1 = new BigDecimal("1.0");
        BigDecimal bd2 = new BigDecimal("1.00");
        BigDecimal bd3 = new BigDecimal("2.0");

        System.out.println("bd1.compareTo(bd3) : " + bd1.compareTo(bd3));
        System.out.println("bd3.compareTo(bd1) : " + bd3.compareTo(bd1));
        System.out.println("bd1.compareTo(bd2) : " + bd1.compareTo(bd2));
        System.out.println("bd1.equals(bd2) : " + bd1.equals(bd3));
//        System.out.println("bd1.compareTo(bd2) : " + bd1.compareTo(bd2));
//        System.out.println("bd1.compareTo(bd3) : " + bd1.compareTo(bd3));

        // Arithmetic operations
        BigDecimal bd4 = new BigDecimal("4.0");
        BigDecimal bd5 = new BigDecimal("2.0");
        // sum
        System.out.println(bd4.add(bd5));

        // subtract
        System.out.println(bd4.subtract(bd5));

        // multiply
        System.out.println(bd4.multiply(bd5));

        // divide
        System.out.println(bd4.divide(bd5));

        // Two ways to set precision and scale

        BigDecimal bd6 = new BigDecimal("23.46");
        System.out.println("Before rounding :" + bd6);
        // set scale and rounding mode
        BigDecimal db6Rounded = bd6.setScale(1, RoundingMode.HALF_EVEN);
        System.out.println("After rounding :" + db6Rounded);
        // set precision and rounding mode
        BigDecimal rounded = bd6
                .round(new MathContext(3, RoundingMode.HALF_EVEN));
        System.out.println("rounded : " + rounded);
        BigDecimal quantity = new BigDecimal("4.5");
        BigDecimal unitPrice = new BigDecimal("2.69");
        BigDecimal discountRate = new BigDecimal("0.10");
        BigDecimal taxRate = new BigDecimal("0.0725");
        BigDecimal total =  calculateTotalAmount(quantity, unitPrice, discountRate, taxRate);
        System.out.println("total : " + total);
    }

    static BigDecimal calculateTotalAmount(BigDecimal quantity, BigDecimal unitPrice, BigDecimal discountRate,
                                           BigDecimal taxRate) {
        BigDecimal amount = quantity.multiply(unitPrice);
        System.out.println("amount : " + amount);
        BigDecimal discountedAmount = amount.multiply(BigDecimal.ONE.subtract(discountRate));
        System.out.println("discountedAmount : " + discountedAmount);
        BigDecimal amountPayable = discountedAmount.multiply(BigDecimal.ONE.add(taxRate));
        System.out.println("amountPayable : " + amountPayable);
        BigDecimal total = amountPayable.setScale(2, RoundingMode.HALF_EVEN);

        return total;
    }
}
