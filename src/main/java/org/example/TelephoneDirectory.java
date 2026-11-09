package org.example;

import java.util.HashMap;
import java.util.Map;

public class TelephoneDirectory {
    private Map<String,String> dictionary = new HashMap<>();

    public void add(String number, String surname){
        dictionary.put(number, surname);
    }

    public void get(String surname){
        dictionary.entrySet().stream()
                .filter(e -> e.getValue().equals(surname))
                .forEach(e -> System.out.println(e.getKey()));
    }
}
