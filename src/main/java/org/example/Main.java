package org.example;

import javax.xml.crypto.Data;

public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("iPhone 15 Pro Max", "22.09.2023", "Apple", "Китай", 140000, false);
        productsArray[1] = new Product("Galaxy S24 Ultra", "31.01.2024", "Samsung", "Вьетнам", 125000, true);
        productsArray[2] = new Product("Redmi Note 13 Pro", "15.01.2024", "Xiaomi", "Китай", 32000, true);
        productsArray[3] = new Product("Honor Magic V3", "05.09.2024", "Honor", "Китай", 135000, false);
        productsArray[4] = new Product("Realme GT 6", "20.06.2024", "Realme", "Китай", 45000, true);
    }
}