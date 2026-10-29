package org.example.task_2;

public interface CircleOperations extends ShapeOperations {
    double getRadius();

    @Override
    default double getPerimeter() {
        return 2 * Math.PI * getRadius();
    }

    @Override
    default double getArea() {
        return Math.PI * Math.pow(getRadius(), 2);
    }
}