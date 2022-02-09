package com.coderscampus.Assignment9.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coderscampus.Assignment9.recipe.Recipe;

@Repository
public class RecipeRepository {
	List<Recipe> savedRecipes = new ArrayList<>();
	
	public List<Recipe> getRecipe () {
		return savedRecipes;
	}
}
