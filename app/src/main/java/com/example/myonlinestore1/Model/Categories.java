package com.example.myonlinestore1.Model;

import java.util.List;

public class Categories {

    private String   id;
    private String   name;
    private String   slug;
    private String   parent;
    private List<Images> images;

    public Categories(String id, String name, String slug, String parent, List<Images> images) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.parent = parent;
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getParent() {
        return parent;
    }

    public List<Images> getImages() {
        return images;
    }
}
