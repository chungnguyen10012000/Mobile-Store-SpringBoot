package com.example.mobilewebspringboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private double productPrice;

    @Column(nullable = false)
    private int numInStock;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private int condition;

    @Column(nullable = false)
    private String image;

    public Product() {
    }

    public Product(String productName, double productPrice, int numInStock, String description, 
    String manufacturer, String category, int condition, String image) {
        this.productId = null;
        this.productName = productName;
        this.productPrice = productPrice;
        this.numInStock = numInStock;
        this.description = description;
        this.manufacturer = manufacturer;
        this.category = category;
        this.condition = condition;
        this.image = image;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getNumInStock() {
        return this.numInStock;
    }

    public void setNumInStock(int numInStock) {
        this.numInStock = numInStock;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCondition() {
        return this.condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}