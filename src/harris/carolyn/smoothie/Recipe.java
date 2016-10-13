package harris.carolyn.smoothie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import fruit.Food;
import fruit.Fruit;
import fruit.PeelableFruit;

public class Recipe {

	Recipe(String smoothieName, Collection<Food> ingredients){
		System.out.println("Creating a new smoothie, called " + smoothieName + ", with the following ingredients: ");
		for(Food ingredient: ingredients){
			System.out.println(" - " + ingredient.getQuantity() + " portion(s) of " + ingredient.getName());
		}
	}
	
	
	public double calcValue(Collection<Food> ingredients){
		double totalPrice = 0;
		List <String> fruitNames = new ArrayList<String>();
		List <Boolean> organics = new ArrayList<Boolean>();
		List <Integer> fruitQuants = new ArrayList<Integer>();
		for(Food ingredient : ingredients){
			fruitNames.add(ingredient.getName());
		}
		for(Food ingredient : ingredients){
			organics.add(ingredient.getOrganic());
		}
		for(Food ingredient : ingredients){
			fruitQuants.add(ingredient.getQuantity());
		}
		try{
			if(organics.get(0)){
			double tempPricePre = IngredientTypes.valueOf(fruitNames.get(0).toUpperCase()).getPrice();
			tempPricePre = (tempPricePre * (fruitQuants.get(0)));
			double tempPrice = tempPricePre *2;
			totalPrice += tempPrice;
		}
		if(!organics.get(0)){
			double tempPrice = IngredientTypes.valueOf(fruitNames.get(0).toUpperCase()).getPrice();
			tempPrice = (tempPrice * (fruitQuants.get(0)));
			totalPrice += tempPrice;
		}
		if(organics.get(1)){
			double tempPricePre = IngredientTypes.valueOf(fruitNames.get(1).toUpperCase()).getPrice();
			tempPricePre = (tempPricePre * (fruitQuants.get(1)));
			double tempPrice = tempPricePre *2;
			totalPrice += tempPrice;
		}
		if (organics.get(1) == false){
			double tempPrice = IngredientTypes.valueOf(fruitNames.get(1).toUpperCase()).getPrice();
			tempPrice = (tempPrice * (fruitQuants.get(1)));
			totalPrice += tempPrice;
		}
		if(organics.get(2)){
			double tempPricePre = IngredientTypes.valueOf(fruitNames.get(2).toUpperCase()).getPrice();
			tempPricePre = (tempPricePre * (fruitQuants.get(2)));
			double tempPrice = tempPricePre *2;
			totalPrice += tempPrice;
		}
		if((organics.get(2) == false) && organics.get(2) != null){
			double tempPrice = IngredientTypes.valueOf(fruitNames.get(2).toUpperCase()).getPrice();
			tempPrice = (tempPrice * (fruitQuants.get(2)));
			totalPrice += tempPrice;
		}
		if(organics.get(3)){
			double tempPricePre = IngredientTypes.valueOf(fruitNames.get(3).toUpperCase()).getPrice();
			tempPricePre = (tempPricePre * (fruitQuants.get(3)));
			double tempPrice = tempPricePre *2;
			totalPrice += tempPrice;
		}
		if((organics.get(3) == false) && organics.get(3) != null){
			double tempPrice = IngredientTypes.valueOf(fruitNames.get(3).toUpperCase()).getPrice();
			tempPrice = (tempPrice * (fruitQuants.get(3)));
			totalPrice += tempPrice;
		}
		} catch (IndexOutOfBoundsException e){
			
		}
		return totalPrice;
	}
	public void getPrice(Collection<Food> ingredients){
		System.out.println("Your total price for your smoothie is $" + calcValue(ingredients) + "0");
	}
	
	public String getRecipeInstructs(Collection<Food> ingredients){
		String recipeGreet = "SMOOTHIE RECIPE:";
		System.out.println(recipeGreet);
		String recipe = "First, add ice into the blender.";
		for(Food ingredient : ingredients){
			if((ingredient.getClass().toString().contains("PeelableFruit"))){
				recipe = (recipe + "\nBefore using each " + ingredient.getName() + ", you must peel it."
						+ "\nAfter peeling each " + ingredient.getName() + ", add it to the blender");
			}else if((ingredient.getClass().toString().contains("PitFruit"))){
				recipe = (recipe + "\nBefore using each " + ingredient.getName() + ", you must remove the pit."
						+ "\nAfter removing the pit from each " + ingredient.getName() + ", add it to the blender.");
			}else{
				recipe = (recipe + "\nAfter washing each " + ingredient.getName() + ", add each " + ingredient.getName() + " to the blender.");
			}
		}
		recipe = (recipe + "\nLastly, blend all ingredients until smooth."
				+ "\nYour delicious smoothie is now ready!");
		return recipe;
	}
	
}
