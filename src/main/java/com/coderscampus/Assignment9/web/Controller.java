package com.coderscampus.Assignment9.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.Assignment9.recipe.Recipe;
import com.coderscampus.Assignment9.service.FileService;


@RestController
public class Controller {

	@Autowired
	private FileService service;
	
	@GetMapping("/gluten-free")
	public List<Recipe> getGlutenFree () throws IOException {
		List<Recipe> gluten = service.sortableList().stream()
							  .filter(Recipe::getGlutenFree)
							  .collect(Collectors.toList());
		return gluten;
	}
	
	@GetMapping("/vegan")
	public List<Recipe> getVegan () throws IOException {
		List<Recipe> vegan = service.sortableList().stream()
							 .filter(Recipe::getVegan)
							 .collect(Collectors.toList());
		return vegan;
	}
	
	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> getVeganAndGlutenFree () throws IOException {
		List<Recipe> veganAndGlutenFree = service.sortableList().stream()
							 .filter(Recipe::getVegan)
							 .filter(Recipe::getGlutenFree)
							 .collect(Collectors.toList());
		return veganAndGlutenFree;
	}
	
	@GetMapping("/vegetarian")
	public List<Recipe> getVegetarian () throws IOException {
		List<Recipe> vegetarian = service.sortableList().stream()
							 .filter(Recipe::getVegetarian)
							 .collect(Collectors.toList());
		return vegetarian;
	}
	
	@GetMapping("/all-recipes")
	public List<Recipe> getAllRecipes () throws IOException {
		List<Recipe> all = service.sortableList();
		return all;
	}
}
