package harris.carolyn.smoothie;

public class Main {

	public static void main(String[] args) {
		Machine smoothie = new Machine();
		smoothie.printIngredients();
		smoothie.printRecipes();
		smoothie.getUserIngredients();
		smoothie.testValidIngredients(smoothie.ingredients);
		System.out.println(smoothie.getIngredients());
		smoothie.getEachFruit(smoothie.validIngredients);
		smoothie.getAllFruit();
		Recipe newRecipe = new Recipe(smoothie.getSmoothieName(), smoothie.allfruits);
		newRecipe.getPrice(smoothie.allfruits);
		

	}

}
