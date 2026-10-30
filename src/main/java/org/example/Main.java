package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] array1 = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };

        String[][] array2 = {
                {"1", "1", "1", "1"},
                {"1", "три", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };

        String[][] array3 = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };

        System.out.println(sumArray(array1));

        try {
            sumArray(array2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            sumArray(array3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(array1[100][100]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public static int sumArray(String[][] array) {

        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException();
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return sum;
    }
}