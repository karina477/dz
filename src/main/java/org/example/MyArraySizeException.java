package org.example;

public class MyArraySizeException extends IllegalArgumentException{

    public MyArraySizeException() {
        super("Размерность не равна 4");
    }
}
