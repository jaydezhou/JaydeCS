package net.jayde.study.javafx.javafxchina.myself;

import java.math.BigInteger;

/**
 * Created by jayde on 2016-12-20 17:26.
 * 版权所有
 */
public class TestBigInteger {
    public static void main(String[] args) {
        BigInteger add1 = BigInteger.ONE;
        BigInteger tow = BigInteger.ONE.add(BigInteger.ONE);
        BigInteger mul1 = tow;
        for (int i = 1; i <= 100; i++) {
            add1 = add1.add(add1);
            mul1 = mul1.multiply(tow);
            System.out.println("add(i)=" + i + ":" + add1);
            System.out.println("mul(i)=" + i + ":" + mul1);
        }

    }
}
