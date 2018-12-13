package com.gauravpathak.springrecipeapp.model;

import javax.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_id_generator")
    @SequenceGenerator(name = "note_id_generator", allocationSize = 1, initialValue = 21001, sequenceName = "note_id_sequence")
    @Column(name = "NOTES_ID")
    private Long notesId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Recipe recipe;

    @Lob
    private String recipeNotes;

    public Long getNotesId() {
        return notesId;
    }

    public void setNotesId(Long notesId) {
        this.notesId = notesId;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
