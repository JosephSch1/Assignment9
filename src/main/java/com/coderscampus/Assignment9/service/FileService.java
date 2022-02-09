package com.coderscampus.Assignment9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment9.recipe.Recipe;
import com.coderscampus.Assignment9.repository.RecipeRepository;

@Service
public class FileService {
	
	@Autowired
	RecipeRepository repository;
	
	@SuppressWarnings("deprecation")
	public List<Recipe> readFile() throws IOException {
		Reader in = new FileReader("recipes.txt");
		CSVFormat format = CSVFormat.DEFAULT.withDelimiter(',').withEscape('\\').withHeader("Cooking Minutes", "Dairy Free", "Gluten Free",
				"Instructions", "Preparation Minutes", "Price Per Serving",
				"Ready In Minutes", "Servings", "Spoonacular Score", "Title", "Vegan", "Vegetarian")
				.withSkipHeaderRecord()
				.withIgnoreSurroundingSpaces(); //The CSVFormat will allow us to use the maven CSV reader 
		// dependency to properly parse the recipes.txt file
		
		Iterable<CSVRecord> records = format.parse(in);
		for (CSVRecord record : records) {
			Recipe recipe = new Recipe();
			Integer cookingMinutes = Integer.parseInt(record.get("Cooking Minutes"));
			recipe.setCookingMinutes(cookingMinutes);
			Boolean dairyFree = Boolean.parseBoolean(record.get("Dairy Free"));
			recipe.setDairyFree(dairyFree);
			Boolean glutenFree = Boolean.parseBoolean(record.get("Gluten Free"));
			recipe.setGlutenFree(glutenFree);
			String instructions = record.get("Instructions");
			recipe.setInstructions(instructions);
			Double preparationMinutes = Double.parseDouble(record.get("Preparation Minutes"));
			recipe.setPrepariationMinutes(preparationMinutes);
			Double pricePerServing = Double.parseDouble(record.get("Price Per Serving"));
			recipe.setPricePerServing(pricePerServing);
			Integer readyInMinutes = Integer.parseInt(record.get("Ready In Minutes"));
			recipe.setReadyInMinutes(readyInMinutes);
			Integer servings = Integer.parseInt(record.get("Servings"));
			recipe.setServings(servings);
			Double spoonacularScore = Double.parseDouble(record.get("Spoonacular Score"));
			recipe.setSpoonacularScore(spoonacularScore);
			String title = record.get("Title");
			recipe.setTitle(title);
			Boolean vegan = Boolean.parseBoolean(record.get("Vegan"));
			recipe.setVegan(vegan);
			Boolean vegetarian = Boolean.parseBoolean(record.get("Vegetarian"));
			recipe.setVegetarian(vegetarian);
		
		repository.getRecipe().add(recipe);
		// here, we iterate through the recipes.txt and populate a recipes object based on the items in the file.
		}
		return repository.getRecipe();
	}
	public List<Recipe> sortableList () throws IOException {
		if (repository.getRecipe().size() == 0) {
			return readFile();
		}
		return repository.getRecipe();
	}
	
}
