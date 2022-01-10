package entity;

import java.util.List;

public class Product {

    private long id;

    private String name;

    private double price;

    private String barcode;

    private List<Transaction> transactions;

    public Product() {
    }

    public Product(long id, String name, double price, String barcode) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", barcode='" + barcode + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}
