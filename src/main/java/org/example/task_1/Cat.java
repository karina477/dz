package org.example.task_1;

public class Cat extends Animal {
    private boolean satiety = false;
    private int necessaryAmountOfFood;

    public Cat(String name, int necessaryAmountOfFood) {
        super(name);
        this.necessaryAmountOfFood = necessaryAmountOfFood;
    }

    public boolean getSatiety() {
        return satiety;
    }

    public void eats(Bowl bowl) {
        if (bowl.trySubtract(necessaryAmountOfFood)) {
            satiety = true;
        }
    }

    @Override
    public void run(int length) {
        if (length > 200) {
            System.out.println("Кот не можент пробежать бальше 200м");
        } else {
            System.out.println(name + " " + "Пробежал: " + length + "м");
        }
    }

    @Override
    public void swim(int length) {
        System.out.println("Кот не умеет плавать");
    }
}
