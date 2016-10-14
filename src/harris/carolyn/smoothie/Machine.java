package harris.carolyn.smoothie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import fruit.Food;
import fruit.Fruit;
import fruit.OtherIngredients;
import fruit.PeelableFruit;
import fruit.PitFruit;

public class Machine {
	Collection<Food> allIngredients = new ArrayList<Food>();
	Collection<String> ingredients = new ArrayList<String>();
	List<String> validIngredients = new ArrayList<String>();
	String fruit1;
	String fruit2;
	String fruit3;
	String fruit4;
	boolean recipeChoose;
	boolean viewRecipe;
	boolean isExplosion;
	boolean isFusion;
	boolean isBlast;
	boolean isFun;

	public Machine() {
		System.out.println("Welcome to the smoothie machine!");
	}
//print ingredients possible from a text file
	void printIngredients() {
		BufferedReader reader = null;
		List<String> ingredients = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader("resources/ingredientList.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
//print all the recipes
	void printRecipes() {
		System.out.println("Would you like to see some suggested recipes?");
		Scanner rResponse = new Scanner(System.in);
		String response = rResponse.nextLine();
		if (response.contains("y")) {
			viewRecipe = true;
			BufferedReader readRecipe = null;
			try {
				readRecipe = new BufferedReader(new FileReader("resources/Recipes.txt"));
				String line;
				while ((line = readRecipe.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					readRecipe.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Okay, go ahead and be creative!");
		}
	}
//take user input to decide which ingredients they want in their smoothie
	void getUserIngredients() {
		Scanner userIn = new Scanner(System.in);
		String recipeDecide = "";
		if (viewRecipe) {
			System.out.println("Would you like to use one of the recipes?");
			recipeDecide = userIn.nextLine().toLowerCase();
		}
		if (recipeDecide.contains("y")) {
			recipeChoose = true;
			System.out.println("What recipe looks good?");
			String recipeChoice = userIn.nextLine().toLowerCase();
			if (recipeChoice.contains("explosion")) {
				ingredients.addAll(Arrays.asList("strawberry", "banana"));
				isExplosion = true;
			} else if (recipeChoice.contains("fusion")) {
				ingredients.addAll(Arrays.asList("peach", "orange", "banana"));
				isFusion = true;
			} else if (recipeChoice.contains("blast")) {
				ingredients.addAll(Arrays.asList("raspberry", "strawberry", "blueberry", "yogurt"));
				isBlast = true;
			} else if (recipeChoice.contains("fun")) {
				ingredients.addAll(Arrays.asList("pineapple", "orange", "banana", "yogurt"));
				isFun = true;
			}
		} else {
			System.out.println("What is the first ingredient you want to use in your smoothie?");
			String firstIngredient = userIn.nextLine().toLowerCase();
			System.out.println("What is the second ingredient you want to use in your smoothie?");
			String secondIngredient = userIn.nextLine().toLowerCase();
			System.out.println("Would you like to add more ingredients?");
			String moreFruit = userIn.nextLine().toLowerCase();
			if (moreFruit.contains("y")) {
				System.out.println("What is the third ingredient you want to use in your smoothie?");
				String thirdIngredient = userIn.nextLine().toLowerCase();
				System.out.println("Would you like to add more ingredients?");
				String moreFruitTwo = userIn.nextLine().toLowerCase();
				if (moreFruitTwo.contains("y")) {
					System.out.println("What is the third ingredient you want to use in your smoothie?");
					String fourthIngredient = userIn.nextLine().toLowerCase();
					ingredients.addAll(
							Arrays.asList(firstIngredient, secondIngredient, thirdIngredient, fourthIngredient));
				} else {
					ingredients.addAll(Arrays.asList(firstIngredient, secondIngredient, thirdIngredient));
				}
			} else {
				ingredients.addAll(Arrays.asList(firstIngredient, secondIngredient));
			}
			
		}
	}
//creates a list of enum names
	public List<String> ingredientsEnums() {
		List<String> fruitEnums = new ArrayList<String>();
		for (IngredientTypes type : IngredientTypes.values()) {
			fruitEnums.add(type.name());
		}
		return fruitEnums;
	}
//see if ingredient is one in the enums
	void testValidIngredients(Collection<String> ingredients) {
		for (String ingredient : ingredients) {
			if (ingredientsEnums().contains(ingredient.toUpperCase())) {
				validIngredients.add(ingredient);
			} else {
				System.out.println("That ingredient " + ingredient + " is not available in this smoothie store.");
			}
		}
	}
//get the ingredients
	Collection<String> getIngredients() {
		return validIngredients;
	}
// get each ingredient as separate fruit to later create a class from user input
	public void getEachIngredient(List<String> validIngredients) {
		for (int i = 0; i < validIngredients.size(); i++) {
			if (i == 0) {
				fruit1 = validIngredients.get(i);
			} else if (i == 1) {
				fruit2 = validIngredients.get(i);
			} else if (i == 2) {
				fruit3 = validIngredients.get(i);
			} else if (i == 3) {
				fruit4 = validIngredients.get(i);
			}

		}
	}
// create ingredient class depending on information, that you get from the user
	public Food getIngredientParams(String ingredient) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many portions of " + ingredient + " would you like?");
		String quantityString = scan.nextLine();
		int quantity = 1;
		try {
			quantity = Integer.parseInt(quantityString);
		} catch (NumberFormatException e) {
			System.out.println("Since you didn't enter a number, defaulted to 1 portion");
		}
		System.out.println("Would you like to have organic " + ingredient + "?");
		String orgo = scan.nextLine();
		boolean isOrganic;
		if (orgo.contains("y")) {
			isOrganic = true;
		} else {
			isOrganic = false;
		}
		Food food;
		if (ingredient.equals("banana") || ingredient.equals("orange") || ingredient.equals("lemon")
				|| ingredient.equals("lime")) {
			food = new PeelableFruit(ingredient, quantity, isOrganic);
		} else if (ingredient.equals("peach") || ingredient.equals("cherry")) {
			food = new PitFruit(ingredient, quantity, isOrganic);
		} else if (ingredient.equals("spinach") || ingredient.equals("yogurt") || ingredient.equals("ice")
				|| ingredient.equals("protein")) {
			food = new OtherIngredients(ingredient, quantity, isOrganic);
		} else {
			food = new Fruit(ingredient, quantity, isOrganic);
		}
		return food;
	}

	//adds all ingredients to a collection
	public Collection<Food> getAllIngredients() {
		if (fruit1 != null) {
			allIngredients.add(getIngredientParams(fruit1));
		}
		if (fruit2 != null) {
			allIngredients.add(getIngredientParams(fruit2));
		}
		if (fruit3 != null) {
			allIngredients.add(getIngredientParams(fruit3));
		}
		if (fruit4 != null) {
			allIngredients.add(getIngredientParams(fruit4));
		}
		return allIngredients;
	}

	//get smoothie name, ask if they want to use a pre-made recipe, or create their own
	public String getSmoothieName() {
		if (!recipeChoose) {
			System.out.println("What do you want your smoothie to be called?");
			Scanner uIn = new Scanner(System.in);
			String smoothieName = uIn.nextLine();
			return smoothieName;
		} else if (recipeChoose) {
			String smoothieName = "";
			if (isFusion) {
				smoothieName = "Peach Fusion";
			} else if (isExplosion) {
				smoothieName = "BerryNana Explosion";
			} else if (isBlast) {
				smoothieName = "Berry Blast";
			} else if (isFun) {
				smoothieName = "Tropical Fun";
			}
			return smoothieName;
		} else {
			String smoothieName = "";
			return smoothieName;
		}
	}
}
