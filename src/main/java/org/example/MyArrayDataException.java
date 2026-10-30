package org.example;

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(int i, int j) {
        super(String.format("Ячейка %d %d", i, j));
    }
}
