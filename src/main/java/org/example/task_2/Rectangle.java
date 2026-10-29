package org.example.task_2;

public class Rectangle extends Shape implements RectangleOperations{
    private double width;
    private double height;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.width = width;
        this.height = height;
    }

    @Override public double getWidth() { return width; }
    @Override public double getHeight() { return height; }

    @Override
    public String toString() {
        return String.format("Прямоугольник\n" +
                        "Периметр: %.2f\n" +
                        "Площаж: %.2f\n" +
                        "Цвет фона: %s\n" +
                        "Цвет границ: %s\n",
                getPerimeter(), getArea(), getFillColor(), getBorderColor());
    }
}
