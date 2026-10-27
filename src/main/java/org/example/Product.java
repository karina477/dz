package org.example;

public class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private int price;
    private boolean bookingStatus;

    public Product(String name, String productionDate, String manufacturer, String countryOfOrigin, int price, boolean bookingStatus) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }

    public void printInfo() {
        System.out.printf("Название: %s, Дата производства: %s, Производитель: %s, Страна происхождения: %s, Цена: %d, Доступен: %b%n",
                name, productionDate, manufacturer, countryOfOrigin, price, bookingStatus);

    }
}
