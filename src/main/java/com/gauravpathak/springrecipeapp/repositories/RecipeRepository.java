package com.gauravpathak.springrecipeapp.repositories;

import com.gauravpathak.springrecipeapp.model.Recipe;
import org.springframework.data.repository.CrudRepository;


public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
