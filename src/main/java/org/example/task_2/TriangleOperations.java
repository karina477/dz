package org.example.task_2;

public interface TriangleOperations extends ShapeOperations {
    double getSideA();
    double getSideB();
    double getSideC();

    @Override
    default double getPerimeter() {
        return getSideA() + getSideB() + getSideC();
    }

    @Override
    default double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - getSideA()) * (p - getSideB()) * (p - getSideC()));
    }
}
