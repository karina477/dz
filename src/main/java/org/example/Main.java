package org.example;

import org.example.task_1.Animal;
import org.example.task_1.Bowl;
import org.example.task_1.Cat;
import org.example.task_1.Dog;
import org.example.task_2.Circle;
import org.example.task_2.Rectangle;
import org.example.task_2.Triangle;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        Dog dog = new Dog("Бобик");
        Cat cat1 = new Cat("Мурка", 15);

        dog.run(200);
        dog.run(550);
        dog.swim(8);
        dog.swim(11);

        cat1.run(190);
        cat1.run(230);
        cat1.swim(5);

        Cat[] catArray = new Cat[4];
        catArray[0] = new Cat("Пурка", 10);
        catArray[1] = new Cat("Вася", 5);
        catArray[2] = new Cat("Муся", 15);
        catArray[3] = new Cat("Боб", 10);

        Bowl bowl = new Bowl();
        bowl.add(35);

        for (int i = 0; i < catArray.length; i++) {
            catArray[i].eats(bowl);
            System.out.println(catArray[i].getSatiety());
        }

        Animal.printCountCreatedAnimals();

        // Задание 2
        Circle circle = new Circle(5.0, "Красный", "Черный");
        Rectangle rectangle = new Rectangle(4.0, 6.0, "Синий", "Белый");
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, "Зеленый", "Желтый");

        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(triangle);
    }
}