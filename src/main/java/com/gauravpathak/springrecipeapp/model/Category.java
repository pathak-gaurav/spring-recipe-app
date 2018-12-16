package com.gauravpathak.springrecipeapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "recipe")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long categoryId;
    private String description;

    public Category(String description, Set<Recipe> recipe) {
        this.description = description;
        this.recipe = recipe;
    }

    public Category() {
    }

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipe = new HashSet<>();

}
