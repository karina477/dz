package org.example.task_1;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void run(int length) {
        if (length > 500) {
            System.out.println("Собака не можент пробежать бальше 500м");
        } else {
            System.out.println(name + " " + "Пробежал: " + length + "м");
        }
    }

    @Override
    public void swim(int length) {
        if (length > 10) {
            System.out.println("Собака не можент проплыть бальше 10м");
        } else {
            System.out.println(name + " " + "Проплыл: " + length + "м");
        }
    }
}
