package com.gauravpathak.springrecipeapp.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_id_generator")
    @SequenceGenerator(name = "ingredient_id_generator", allocationSize = 1, initialValue = 31001, sequenceName = "ingredient_id_sequence")
    @Column(name = "INGREDIENT_ID")
    private Long ingredientId;
    private String description;
    private BigDecimal amount;
    //private UnitOfMeasure uom;

    @ManyToOne
    private Recipe recipe;


    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
