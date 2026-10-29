package org.example.task_1;

public abstract class Animal {
    protected String name;

    private static int total;

    public Animal(String name) {
        this.name = name;
        total++;
    }

    public abstract void run(int length);

    public abstract void swim(int length);

    public static void printCountCreatedAnimals() {
        System.out.println(total);
    }
}
