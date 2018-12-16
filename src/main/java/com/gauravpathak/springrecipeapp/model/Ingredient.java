package com.gauravpathak.springrecipeapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@EqualsAndHashCode(exclude = "recipe")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INGREDIENT_ID")
    private Long ingredientId;
    private String description;
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name="RECIPE_ID")
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="UOM_ID")
    private UnitOfMeasure unitOfMeasure;

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure,Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.recipe = recipe;
        this.unitOfMeasure = unitOfMeasure;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure) {
        this.description = description;
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
    }

}
