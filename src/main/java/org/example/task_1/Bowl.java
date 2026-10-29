package org.example.task_1;

public class Bowl {
    public int food;

    public boolean trySubtract(int amount) {
        if(food > amount){
            food -= amount;
            return true;
        }

        return false;
    }

    public void add(int amount){
        food += amount;
    }
}
