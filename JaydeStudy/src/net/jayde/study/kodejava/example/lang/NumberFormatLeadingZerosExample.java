package net.jayde.study.kodejava.example.lang;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class NumberFormatLeadingZerosExample {
    public static void main(String[] args) {
        NumberFormat formatter = new DecimalFormat("0000000");
        String number = formatter.format(2500);

        System.out.println("Number with lading zeros: " + number);
    }
}
