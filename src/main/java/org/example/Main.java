package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(isSumBetweenTenAndTwenty(0, 8));
        isPositive(-4);
        System.out.println(isNegative(5));
        repeatPrint("Работает не трогай", 2);
        System.out.println(isLeapYear(2026));
        invertArray(new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0});
        fillArray();
        multiplyLessThanSix();
        fillMatrixDiagonals();
        System.out.println(Arrays.toString(initializeArray(4, 8)));
    }

    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign() {
        int a = 4;
        int b = 7;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 1;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 10;
        int b = 20;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean isSumBetweenTenAndTwenty(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void isPositive(int number) {
        if (number >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static void repeatPrint(String word, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(word);
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 - array[i];
        }

        System.out.println(Arrays.toString(array));
    }

    public static void fillArray() {
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        System.out.println(Arrays.toString(array));
    }

    public static void multiplyLessThanSix() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }

        System.out.println(Arrays.toString(array));
    }

    public static void fillMatrixDiagonals() {
        int length = 5;
        int[][] array = new int[length][length];

        for (int i = 0; i < length; i++) {
            array[i][i] = 1;
            array[i][length - 1 - i] = 1;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] initializeArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }
}