package org.example;

public class Factorial {

    public static int calculate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число должно быть неотрицательным");
        }

        if (number == 0 || number == 1) {
            return 1;
        }

        return number * calculate(number - 1);
    }
}