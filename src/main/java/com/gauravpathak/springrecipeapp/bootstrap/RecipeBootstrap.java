package com.gauravpathak.springrecipeapp.bootstrap;

import com.gauravpathak.springrecipeapp.model.*;
import com.gauravpathak.springrecipeapp.repositories.CategoryRepository;
import com.gauravpathak.springrecipeapp.repositories.RecipeRepository;
import com.gauravpathak.springrecipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
      recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon");
        if (!tablespoon.isPresent()) {
            throw new RuntimeException("Expected UOM is not found");
        }

        Optional<UnitOfMeasure> each = unitOfMeasureRepository.findByDescription("Each");
        if (!each.isPresent()) {
            throw new RuntimeException("Expected UOM is not found");
        }

        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
        if (!teaspoon.isPresent()) {
            throw new RuntimeException("Expected UOM is not found");
        }

        Optional<UnitOfMeasure> dash = unitOfMeasureRepository.findByDescription("Dash");
        if (!dash.isPresent()) {
            throw new RuntimeException("Expected UOM is not found");
        }

        Optional<UnitOfMeasure> pint = unitOfMeasureRepository.findByDescription("Pint");
        if (!pint.isPresent()) {
            throw new RuntimeException("Expected UOM is not found");
        }

        Optional<UnitOfMeasure> cup = unitOfMeasureRepository.findByDescription("Cup");
        if (!cup.isPresent()) {
            throw new RuntimeException("Expected UOM is not found");
        }

        UnitOfMeasure unitOfMeasureTablespoon = tablespoon.get();
        UnitOfMeasure unitOfMeasureEach = each.get();
        UnitOfMeasure unitOfMeasureTeaspoon = teaspoon.get();
        UnitOfMeasure unitOfMeasureDash = dash.get();
        UnitOfMeasure unitOfMeasurePint = pint.get();
        UnitOfMeasure unitOfMeasureCup = cup.get();

        Optional<Category> american = categoryRepository.findByDescription("American");
        if (!american.isPresent()) {
            throw new RuntimeException("Expected Category is not found");
        }
        Optional<Category> british = categoryRepository.findByDescription("British");
        if (!british.isPresent()) {
            throw new RuntimeException("Expected Category is not found");
        }

        Category categoryAmerican = american.get();
        Category categoryBritish = british.get();

        Recipe victoriaSpongeRecipe = new Recipe();
        victoriaSpongeRecipe.setDescription("\n" +
                "Granny's Victoria sponge");
        victoriaSpongeRecipe.setPrepTime(20);
        victoriaSpongeRecipe.setCookTime(20);
        victoriaSpongeRecipe.setDifficulty(Difficulty.EASY);
        victoriaSpongeRecipe.setDirections("1. Heat oven to 190C/170C fan/gas 5. Grease and flour two 20cm sandwich tins.\n" +
                "\n" +
                "2. Place 200g softened unsalted butter, 200g caster sugar and 1 tsp vanilla extract into a bowl and beat well to a creamy consistency.\n" +
                "\n" +
                "3. Slowly beat in 4 medium eggs, one by one, then fold in 200g self-raising flour and mix well. \n" +
                "\n" +
                "4. Divide the mix between the cake tins, place into the oven and bake for about 20 mins until risen and golden brown. The cakes should spring back when gently pushed in the middle.\n" +
                "\n" +
                "5. When ready, remove from the oven and allow to cool for 5 mins in the tin, before turning out onto a wire rack and cooling completely.\n" +
                "\n" +
                "6. Spread about 6 tbsp raspberry jam onto one cake and top with 250ml whipped double cream. Sandwich the cakes together and dust with icing sugar.");

        Notes victoriaSpongeNotes = new Notes();
        victoriaSpongeNotes.setRecipeNotes("The classic Victoria sandwich is always a teatime winner, every bite brings a taste of nostalgia");

        victoriaSpongeRecipe.setNotes(victoriaSpongeNotes);
        victoriaSpongeRecipe.getIngredients().add(new Ingredient("unsalted butter, softened, plus extra for greasing (gram)", new BigDecimal(200), unitOfMeasureCup,victoriaSpongeRecipe));
        victoriaSpongeRecipe.getIngredients().add(new Ingredient("caster sugar (gram)", new BigDecimal(200), unitOfMeasureCup,victoriaSpongeRecipe));
        victoriaSpongeRecipe.getIngredients().add(new Ingredient("vanilla extract", new BigDecimal(1), unitOfMeasureTablespoon,victoriaSpongeRecipe));
        victoriaSpongeRecipe.getIngredients().add(new Ingredient("medium eggs", new BigDecimal(4), unitOfMeasureEach,victoriaSpongeRecipe));
        victoriaSpongeRecipe.getIngredients().add(new Ingredient("self-raising flour, plus extra for dusting (gram)", new BigDecimal(200), unitOfMeasureCup,victoriaSpongeRecipe));
        victoriaSpongeRecipe.getIngredients().add(new Ingredient("raspberry jam", new BigDecimal(6), unitOfMeasureTablespoon,victoriaSpongeRecipe));
        victoriaSpongeRecipe.getIngredients().add(new Ingredient("double cream, whipped (milli Liter)", new BigDecimal(250), unitOfMeasureCup,victoriaSpongeRecipe));
        victoriaSpongeRecipe.getIngredients().add(new Ingredient("icing sugar, for dusting", new BigDecimal(1), unitOfMeasureCup,victoriaSpongeRecipe));

        victoriaSpongeNotes.setRecipe(victoriaSpongeRecipe);
        victoriaSpongeRecipe.getCategories().add(categoryBritish);


        recipes.add(victoriaSpongeRecipe);

        Recipe lancashireHotpotRecipe = new Recipe();
        lancashireHotpotRecipe.setDescription("Lancashire Hotpot");
        lancashireHotpotRecipe.setCookTime(100);
        lancashireHotpotRecipe.setPrepTime(20);
        lancashireHotpotRecipe.setDifficulty(Difficulty.EASY);
        lancashireHotpotRecipe.setDirections("Heat oven to 160C/fan 140C/gas 3.\n" +
                "\n" +
                "Heat a little of the 100g dripping or butter in a large shallow casserole dish and brown 900g stewing lamb chunks in batches, lift to a plate, then repeat with 3 trimmed and sliced lamb kidneys.\n" +
                "\n" +
                "Fry 2 chopped onions and 4 peeled and sliced carrots in the pan with a little more dripping until golden.\n" +
                "\n" +
                "Sprinkle over 25g plain flour, allow to cook for a couple of mins, shake over 2 tsp Worcestershire sauce, pour in 500ml lamb or chicken stock, then bring to the boil.\n" +
                "\n" +
                "Stir in the stewing lamb and kidneys and 2 bay leaves, then turn off the heat.\n" +
                "\n" +
                "Arrange 900g peeled and sliced potatoes on top of the meat, then drizzle with a little more dripping.\n" +
                "\n" +
                "Cover, then place in the oven for about 1½ hrs until the potatoes are cooked.\n" +
                "\n" +
                "Remove the lid, brush the potatoes with a little more dripping, then turn the oven up to brown the potatoes, or finish under the grill for 5-8 mins until brown.");

        Notes lancashireHotpotNotes = new Notes();
        lancashireHotpotNotes.setRecipeNotes("This famous lamb stew topped with sliced potatoes should be on the menu at every British pub");

        lancashireHotpotRecipe.setNotes(lancashireHotpotNotes);
        lancashireHotpotRecipe.getIngredients().add(new Ingredient("butter (gram)", new BigDecimal(100), unitOfMeasureCup,lancashireHotpotRecipe));
        lancashireHotpotRecipe.getIngredients().add(new Ingredient("stewing lamb, cut into large chunks (gram)", new BigDecimal(900), unitOfMeasureCup,lancashireHotpotRecipe));
        lancashireHotpotRecipe.getIngredients().add(new Ingredient("lamb kidneys, sliced, fat removed", new BigDecimal(3), unitOfMeasureEach,lancashireHotpotRecipe));
        lancashireHotpotRecipe.getIngredients().add(new Ingredient("medium onions chopped", new BigDecimal(2), unitOfMeasureEach,lancashireHotpotRecipe));
        lancashireHotpotRecipe.getIngredients().add(new Ingredient("carrot peeled and sliced", new BigDecimal(4), unitOfMeasureEach,lancashireHotpotRecipe));
        lancashireHotpotRecipe.getIngredients().add(new Ingredient("plain flour (gram)", new BigDecimal(25), unitOfMeasureCup,lancashireHotpotRecipe));
        lancashireHotpotRecipe.getIngredients().add(new Ingredient("Worcestershire sauce", new BigDecimal(2), unitOfMeasureTablespoon,lancashireHotpotRecipe));
        lancashireHotpotRecipe.getIngredients().add(new Ingredient("lamb or chicken stock (milliliter)", new BigDecimal(500), unitOfMeasureCup,lancashireHotpotRecipe));
        lancashireHotpotRecipe.getIngredients().add(new Ingredient("bay leaves", new BigDecimal(2), unitOfMeasureEach,lancashireHotpotRecipe));
        lancashireHotpotRecipe.getIngredients().add(new Ingredient("potato peeled and sliced (gram)", new BigDecimal(900), unitOfMeasureCup,lancashireHotpotRecipe));

        lancashireHotpotNotes.setRecipe(lancashireHotpotRecipe);
        lancashireHotpotRecipe.getCategories().add(categoryBritish);
        recipes.add(lancashireHotpotRecipe);

        return recipes;
    }


}
