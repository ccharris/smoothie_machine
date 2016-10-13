package harris.carolyn.smoothie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class InRecipe {

	public Collection<String[]> loadRecipes(String filename) {
		
		final File recipeFile = new File(filename);
		final Collection<String[]> recipes = new ArrayList<>();

		final InputStream recipeStream;
		try {
			recipeStream = new FileInputStream(recipeFile);

		} catch (FileNotFoundException e) {
			System.out.println("Couldn't fine the file: " + recipeFile.getAbsolutePath());
			return recipes;
		}

		try (Scanner input = new Scanner(recipeStream)) {
			while (input.hasNextLine()) {
				String[] items = input.nextLine().split(",");
				recipes.add(items);
			}
		}
		return recipes;
	}

}
