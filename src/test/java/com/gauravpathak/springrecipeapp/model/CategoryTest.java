package com.gauravpathak.springrecipeapp.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

    Category category;

    @Before
    public void setup() {
        this.category = new Category();
    }

    @Test
    public void getCategoryId() {
        Long id = 3L;
        category.setCategoryId(id);
        Assert.assertEquals(id, category.getCategoryId());
    }

    @Test
    public void getDescription() {
        String description = "Bagel";
        category.setDescription(description);
        Assert.assertEquals(description, category.getDescription());
    }

    @Test
    public void getRecipe() {
    }
}