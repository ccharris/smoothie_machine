package harris.carolyn.smoothie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import fruit.Fruit;

public class Recipe {

	Recipe(String smoothieName, Collection<Fruit> ingredients){
		System.out.println("Creating a new smoothie, called " + smoothieName + ", with the following ingredients: ");
		for(Fruit ingredient: ingredients){
			System.out.println(" - " + ingredient.getQuantity() + " portion(s) of " + ingredient.getName());
		}
	}
	
	
	public double calcValue(Collection<Fruit> ingredients){
		double totalPrice = 0;
		List <String> fruitNames = new ArrayList<String>();
		List <Boolean> organics = new ArrayList<Boolean>();
		List <Integer> fruitQuants = new ArrayList<Integer>();
		for(Fruit ingredient : ingredients){
			fruitNames.add(ingredient.getName());
		}
		for(Fruit ingredient : ingredients){
			organics.add(ingredient.getOrganic());
		}
		for(Fruit ingredient : ingredients){
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
			double tempPricePre = IngredientTypes.valueOf(fruitNames.get(1).toUpperCase()).getPrice();
			tempPricePre = (tempPricePre * (fruitQuants.get(2)));
			double tempPrice = tempPricePre *2;
			totalPrice += tempPrice;
		}
		if((organics.get(2) == false) && organics.get(2) != null){
			double tempPrice = IngredientTypes.valueOf(fruitNames.get(1).toUpperCase()).getPrice();
			tempPrice = (tempPrice * (fruitQuants.get(2)));
			totalPrice += tempPrice;
		}
		if(organics.get(3)){
			double tempPricePre = IngredientTypes.valueOf(fruitNames.get(1).toUpperCase()).getPrice();
			tempPricePre = (tempPricePre * (fruitQuants.get(3)));
			double tempPrice = tempPricePre *2;
			totalPrice += tempPrice;
		}
		if((organics.get(3) == false) && organics.get(3) != null){
			double tempPrice = IngredientTypes.valueOf(fruitNames.get(1).toUpperCase()).getPrice();
			tempPrice = (tempPrice * (fruitQuants.get(3)));
			totalPrice += tempPrice;
		}
		} catch (IndexOutOfBoundsException e){
			
		}
			
			
//		for(String fruitName : fruitNames){
//			double tempPricePre = FruitTypes.valueOf(fruitName.toUpperCase()).getPrice();
//			
//			totalPrice += tempPricePre;
//		}
		return totalPrice;
	}
	public void getPrice(Collection<Fruit> ingredients){
		System.out.println("Your total price for your smoothie is $" + calcValue(ingredients));
	}

	
}
