package com.gauravpathak.springrecipeapp.services;

import com.gauravpathak.springrecipeapp.model.Recipe;
import com.gauravpathak.springrecipeapp.repositories.RecipeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    private RecipeServiceImpl recipeService;

    @Mock
    private RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {

        Recipe recipe = new Recipe();
        HashSet recipeData = new HashSet();
        recipeData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeService.getRecipes();

        Assert.assertEquals(1, recipes.size());

        verify(recipeRepository,times(1)).findAll();

    }

    @Test
    public void findById() throws Exception{
        Recipe recipe = new Recipe();
        recipe.setRecipeId(1L);
        Optional<Recipe> optionalRecipe = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(optionalRecipe);

        Recipe recipeServiceById = recipeService.findById(1L);
        assertNotNull("Null Recipe Returned",recipeServiceById);
        verify(recipeRepository,times(1)).findById(anyLong());
        verify(recipeRepository,never()).findAll();
    }
}