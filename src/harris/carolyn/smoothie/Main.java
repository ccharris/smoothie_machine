package harris.carolyn.smoothie;

public class Main {

	public static void main(String[] args) {
		Machine smoothie = new Machine();
		smoothie.printIngredients();
		smoothie.printRecipes();
		smoothie.getUserIngredients();
		smoothie.testValidIngredients(smoothie.ingredients);
		System.out.println(smoothie.getIngredients());
		smoothie.getEachIngredient(smoothie.validIngredients);
		smoothie.getAllIngredients();
		Recipe newRecipe = new Recipe(smoothie.getSmoothieName(), smoothie.allIngredients);
		System.out.println(newRecipe.getRecipeInstructs(smoothie.allIngredients));
		newRecipe.getPrice(smoothie.allIngredients);
	}

}
