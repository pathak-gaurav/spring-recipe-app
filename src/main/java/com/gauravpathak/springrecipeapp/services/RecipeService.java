package com.gauravpathak.springrecipeapp.services;

import com.gauravpathak.springrecipeapp.model.Recipe;

import java.util.Set;

public interface RecipeService {

     Set<Recipe> getRecipes();
     Recipe findById(Long l);
}
