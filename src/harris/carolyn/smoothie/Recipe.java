package harris.carolyn.smoothie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import fruit.Food;
import fruit.Fruit;
import fruit.PeelableFruit;

public class Recipe {
	// constructor
	Recipe(String smoothieName, Collection<Food> ingredients) {
		System.out.println("Creating a new smoothie, called " + smoothieName + ", with the following ingredients: ");
		for (Food ingredient : ingredients) {
			System.out.println(" - " + ingredient.getQuantity() + " portion(s) of " + ingredient.getName());
		}
	}

	// calculates the value of the smoothie
	public double calcValue(Collection<Food> ingredients) {
		double totalPrice = 0;
		List<String> fruitNames = new ArrayList<String>();
		List<Boolean> organics = new ArrayList<Boolean>();
		List<Integer> fruitQuants = new ArrayList<Integer>();
		for (Food ingredient : ingredients) {
			fruitNames.add(ingredient.getName());
			organics.add(ingredient.getOrganic());
			fruitQuants.add(ingredient.getQuantity());
		}
		try {
			for (int i = 0; i < 4; i++) {
				if (fruitNames.get(i) != null) {
					if (organics.get(i)) {
						double tempPricePre = IngredientTypes.valueOf(fruitNames.get(i).toUpperCase()).getPrice();
						tempPricePre = (tempPricePre * (fruitQuants.get(i)));
						double tempPrice = tempPricePre * 2;
						totalPrice += tempPrice;
					}
					if (!organics.get(i)) {
						double tempPrice = IngredientTypes.valueOf(fruitNames.get(i).toUpperCase()).getPrice();
						tempPrice = (tempPrice * (fruitQuants.get(i)));
						totalPrice += tempPrice;
					}
				}
			}
		} catch (IndexOutOfBoundsException e) {

		}
		return totalPrice;
	}

	// returns the value of the price of the smoothie
	public double getPrice(Collection<Food> ingredients) {
		System.out.println("Your total price for your smoothie is $" + calcValue(ingredients) + "0");
		return calcValue(ingredients);
	}

	// get instructions on how to make the smoothie
	public String getRecipeInstructs(Collection<Food> ingredients) {
		String recipeGreet = "SMOOTHIE RECIPE:";
		System.out.println(recipeGreet);
		String recipe = "First, add ice into the blender.";
		for (Food ingredient : ingredients) {
			if ((ingredient.getClass().toString().contains("PeelableFruit"))) {
				recipe = (recipe + "\nBefore using each " + ingredient.getName() + ", you must peel it."
						+ "\nAfter peeling each " + ingredient.getName() + ", add it to the blender");
			} else if ((ingredient.getClass().toString().contains("PitFruit"))) {
				recipe = (recipe + "\nBefore using each " + ingredient.getName() + ", you must remove the pit."
						+ "\nAfter removing the pit from each " + ingredient.getName() + ", add it to the blender.");
			} else {
				recipe = (recipe + "\nAfter washing each " + ingredient.getName() + ", add each " + ingredient.getName()
						+ " to the blender.");
			}
		}
		recipe = (recipe + "\nLastly, blend all ingredients until smooth." + "\nYour delicious smoothie is now ready!");
		return recipe;
	}

}
