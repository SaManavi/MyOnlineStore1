package com.example.myonlinestore1.Model;

import java.util.Date;
import java.util.List;

public class Products {

    private String id;
    private String name;
    private String description;
    private String price;
    private String total_sales;
    private String date_modified;
    private String parent_id;
    private List<Images> images;

    public Products(String id, String name, String description, String price, String total_sales, String date_modified, String parent_id, List<Images> images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.total_sales = total_sales;
        this.date_modified = date_modified;
        this.parent_id = parent_id;
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getTotal_sales() {
        return total_sales;
    }

    public String getDate_modified() {
        return date_modified;
    }

    public String getParent_id() {
        return parent_id;
    }

    public List<Images> getImages() {
        return images;
    }
}
