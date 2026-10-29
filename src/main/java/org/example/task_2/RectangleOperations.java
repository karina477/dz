package org.example.task_2;

public interface RectangleOperations extends ShapeOperations {
    double getWidth();
    double getHeight();

    @Override
    default double getPerimeter() {
        return 2 * (getWidth() + getHeight());
    }

    @Override
    default double getArea() {
        return getWidth() * getHeight();
    }
}
