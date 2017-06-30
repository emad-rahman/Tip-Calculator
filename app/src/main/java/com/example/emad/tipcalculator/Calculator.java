package com.example.emad.tipcalculator;

/**
 * Created by emad on 2017-06-29.
 */

public class Calculator {
    public static double calculateTip(double bill, double tip){
        if(tip == 0){
            return bill;
        }

        return bill * (tip / 100);
    }

    public static double calculateTotal(double bill, double percent){
        double per = calculateTip(bill, percent);
        return bill + per;
    }
}
