package com.gauravpathak.springrecipeapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECIPE_ID")
    private Long recipeId;

    @Lob
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    @Lob
    private String directions;
    @Lob
    private Byte[] images;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Notes notes;

    @ManyToMany
    @JoinTable(name = "RECIPE_CATEGORY", joinColumns = @JoinColumn(name = "RECIPE_ID"), inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
    private Set<Category> categories = new HashSet<>();

    public Recipe() {
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }


    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

    public Set<Ingredient> addIngredients() {
        return ingredients;
    }

}
