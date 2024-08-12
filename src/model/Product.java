package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Product {
    private int id;
    private String name;
    private String brand;
    private String category;
    private double price;
    private int quantity;
    private String description;
    private LocalDate purchaseDate;
    private int warrantyPeriod;
    private static int idIncrement = 1;

    public Product(String name, String brand, String category, double price, int quantity, String description, LocalDate purchaseDate, int warrantyPeriod) {
        this.id = idIncrement++;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.purchaseDate = purchaseDate;
        this.warrantyPeriod = warrantyPeriod;
        //idIncrement ++;
    }

    public Product(int id, String name, String brand, String category, double price, int quantity, String description, LocalDate purchaseDate, int warrantyPeriod) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.purchaseDate = purchaseDate;
        this.warrantyPeriod = warrantyPeriod;
        if(id >= idIncrement){
            idIncrement = id + 1;
        }
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public static int getIdIncrement() {
        return idIncrement;
    }

    public static void setIdIncrement(int idIncrement) {
        Product.idIncrement = idIncrement;
    }

    public LocalDate expiredWarrantyPeriod() {
        return purchaseDate.plusMonths(warrantyPeriod);
    }

    public String toString() {
        return "Mã sản phẩm: " + id +
                "\nTên sản phẩm: " + name +
                "\nThương hiệu: " + brand +
                "\nLoại sản phẩm: " + category +
                "\nGiá sản phầm: " + price +
                "\nSố lượng: " + quantity +
                "\nMô tả: " + description +
                "\nNgày mua hàng: " + purchaseDate +
                "\nThời gian bảo hành: " + warrantyPeriod + " tháng";
    }
}


