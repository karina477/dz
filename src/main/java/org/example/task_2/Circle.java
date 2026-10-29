package org.example.task_2;

public class Circle extends Shape implements CircleOperations{
    private double radius;

    public Circle(double radius, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.radius = radius;
    }

    @Override public double getRadius() { return radius; }

    @Override
    public String toString() {
        return String.format("Круг\n" +
                        "Периметр: %.2f\n" +
                        "Площадь: %.2f\n" +
                        "Цвет фона: %s\n" +
                        "Цвет границ: %s\n",
                getPerimeter(), getArea(), getFillColor(), getBorderColor());
    }
}
