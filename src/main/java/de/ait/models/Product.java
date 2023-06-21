package de.ait.models;

import java.util.UUID;

public class Product {
    private String id;

    private Category category;

    private String title;

    private double price;

    private String releaseYear;

    public Product(Category category, String title, double price, String releaseYear) {

        this.id = UUID.randomUUID().toString();

        if (category != null) {
            this.category = category;
        } else {
            System.err.println("Введите категорию товара");
        }


        if (price > 0) {
            this.price = price;
        } else {
            System.err.println("Введите корректную цену");
        }

        if (releaseYear != null) {
            this.releaseYear = releaseYear;
        } else {
            System.err.println("Введите корректную дату");
        }
    }


    public String getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", releaseYear='" + releaseYear + '\'' +
                '}';

    }
}