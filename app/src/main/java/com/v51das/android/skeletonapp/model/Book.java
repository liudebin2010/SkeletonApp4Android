package com.v51das.android.skeletonapp.model;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class Book extends LitePalSupport {
    private int id;
    private String author;
    @Column(ignore = false)
    private double price;
    private int pages;
    @Column(unique = true, defaultValue = "unknown", nullable = false)
    private String name;
    @Column(ignore = false)
    private String press;

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
