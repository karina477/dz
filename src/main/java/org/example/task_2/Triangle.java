package org.example.task_2;

public class Triangle extends Shape implements TriangleOperations{
    private double a, b, c;

    public Triangle(double a, double b, double c, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override public double getSideA() { return a; }
    @Override public double getSideB() { return b; }
    @Override public double getSideC() { return c; }

    @Override
    public String toString() {
        return String.format("Треугольник\n" +
                        "Периметр: %.2f\n" +
                        "Площадь: %.2f\n" +
                        "Цвет фона: %s\n" +
                        "Цвет границ: %s\n",
                getPerimeter(), getArea(), getFillColor(), getBorderColor());
    }
}
