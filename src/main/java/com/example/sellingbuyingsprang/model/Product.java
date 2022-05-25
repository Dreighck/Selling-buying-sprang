package com.example.sellingbuyingsprang.model;

import com.sun.istack.NotNull;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double price;
    private int qty;

    private String user; //Need to update String to User when get User class

    @Nullable
    private String description;

    public Product() {
    }

    public Product(int id, String name, double price, int qty) {
        this.name = name;
        this.price = price;
        if(id==this.id)
            this.qty += qty;
        else {
            this.qty = qty;
            this.id = id;
        }
    }

    public Product(int id, String name, double price, int qty, @Nullable String description) {
        this.name = name;
        this.price = price;
        if(id==this.id)
            this.qty += qty;
        else {
            this.qty = qty;
            this.id = id;
        }
        this.description = description;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}


