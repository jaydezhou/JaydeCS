package net.jayde.study.kodejava.example.lang;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokingMethod {
    public static void main(String[] args) {
        InvokingMethod object = new InvokingMethod();
        Class clazz = object.getClass();

        try {
            //
            // Invoking the add(int, int) method
            //
            Method method = clazz.getMethod("add", new Class[]{int.class, int.class});
            Object result = method.invoke(object, new Object[]{10, 10});
            System.out.println("Result = " + result);

            //
            // Invoking the multiply(int, int) method
            //
            method = clazz.getMethod("multiply", new Class[]{int.class, int.class});
            result = method.invoke(object, new Object[]{10, 10});
            System.out.println("Result = " + result);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public int add(int numberA, int numberB) {
        return numberA + numberB;
    }

    public int multiply(int numberA, int numberB) {
        return numberA * numberB;
    }

    public double div(int numberA, int numberB) {
        return numberA / numberB;
    }
}
