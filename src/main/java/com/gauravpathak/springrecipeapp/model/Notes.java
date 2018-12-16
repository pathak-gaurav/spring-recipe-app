package com.gauravpathak.springrecipeapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(exclude = "recipe")
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTES_ID")
    private Long notesId;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;

    public Notes(Recipe recipe, String recipeNotes) {
        this.recipe = recipe;
        this.recipeNotes = recipeNotes;
    }

    public Notes() {
    }

}
