package harris.carolyn.smoothie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import fruit.Fruit;

public class Machine {
	Collection<Fruit> allfruits = new ArrayList<Fruit>();
	Collection<String> ingredients = new ArrayList<String>();
	List<String> validIngredients = new ArrayList<String>();
	String fruit1;
	String fruit2;
	String fruit3;
	String fruit4;
	public Machine(){
		System.out.println("Welcome to the smoothie machine!");
	}
	void printIngredients() {
		BufferedReader reader = null;
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
	void printRecipes() {
		System.out.println("Would you like to see some suggested recipes?");
		Scanner rResponse = new Scanner(System.in);
		String response = rResponse.nextLine();
		if(response.contains("y")){
		BufferedReader readRecipe = null;
		try {
			readRecipe = new BufferedReader(new FileReader("resources/Recipes.txt"));
			String line;
			while ((line = readRecipe.readLine()) != null){
				System.out.println(line);
			}
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try{
				readRecipe.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		} else {
			System.out.println("Okay, go ahead and be creative!");
		}
	}

	void getUserIngredients() {
		Scanner userIn = new Scanner(System.in);
		System.out.println("What is the first fruit you want to use in your smoothie?");
		String firstFruit = userIn.nextLine().toLowerCase();
		System.out.println("What is the second fruit you want to use in your smoothie?");
		String secondFruit = userIn.nextLine().toLowerCase();
		System.out.println("Would you like to add more fruit?");
		String moreFruit = userIn.nextLine().toLowerCase();
		if (moreFruit.contains("y")) {
			System.out.println("What is the third fruit you want to use in your smoothie?");
			String thirdFruit = userIn.nextLine().toLowerCase();
			System.out.println("Would you like to add more fruit?");
			String moreFruitTwo = userIn.nextLine().toLowerCase();
			if (moreFruitTwo.contains("y")) {
				System.out.println("What is the third fruit you want to use in your smoothie?");
				String fourthFruit = userIn.nextLine().toLowerCase();
				ingredients.addAll(Arrays.asList(firstFruit, secondFruit, thirdFruit, fourthFruit));
			} else {
				ingredients.addAll(Arrays.asList(firstFruit, secondFruit, thirdFruit));
			}
		} else {
			ingredients.addAll(Arrays.asList(firstFruit, secondFruit));
		}
	}

	public List<String> ingredientsEnums() {
		List<String> fruitEnums = new ArrayList<String>();
		for (IngredientTypes type : IngredientTypes.values()) {
			fruitEnums.add(type.name());
		}
		return fruitEnums;
	}

	void testValidIngredients(Collection<String> ingredients) {
		for (String ingredient : ingredients) {
			if (ingredientsEnums().contains(ingredient.toUpperCase())) {
				validIngredients.add(ingredient);
			} else {
				System.out.println("That ingredient " + ingredient + " is not available in this smoothie store.");
			}
		}
	}

	Collection<String> getIngredients() {
		return validIngredients;
	}

	public void getEachFruit(List<String> validIngredients) {
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

	public Fruit getFruitParams(String ingredient) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many portions of " + ingredient + " would you like?");
		String quantityString = scan.nextLine();
		int quantity = 1;
		try{
			quantity = Integer.parseInt(quantityString);
		} catch(NumberFormatException e){
			System.out.println("Please enter a correct number, i.e. 1");
		}
		System.out.println("Would you like to have organic " + ingredient + "?");
		String orgo = scan.nextLine();
		boolean isOrganic;
		if (orgo.contains("y")) {
			isOrganic = true;
		} else {
			isOrganic = false;
		}
		Fruit fruit = new Fruit(ingredient, quantity, isOrganic);
		return fruit;
	}

	public Collection<Fruit> getAllFruit() {
		if (fruit1 != null) {
			allfruits.add(getFruitParams(fruit1));
		}
		if (fruit2 != null) {
			allfruits.add(getFruitParams(fruit2));
		}
		if (fruit3 != null) {
			allfruits.add(getFruitParams(fruit3));
		}
		if (fruit4 != null) {
			allfruits.add(getFruitParams(fruit4));
		}

		return allfruits;

	}

	public String getSmoothieName() {
		System.out.println("What do you want your smoothie to be called?");
		Scanner uIn = new Scanner(System.in);
		String smoothieName = uIn.nextLine();
		return smoothieName;
	}
}
