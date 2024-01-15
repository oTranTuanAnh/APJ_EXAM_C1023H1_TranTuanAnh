package model;

public class Product {
    private String id;
    private String name;
    private double price;
    private double quantity;
    private String descriptions;

    public Product() {
    }

    public Product(String id, String name, double price, double quantity, String descriptions) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.descriptions = descriptions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-20s%-15s%-20s%-20s","id=" + id,
                "| name= " + name,
                "| price= " + price,
                "| quantity= " + quantity,
                "| descriptions= " + descriptions);
    }
}
