package harris.carolyn.smoothie;

public enum IngredientTypes {
	CHERRY(1.00), STRAWBERRY(2.00), RASPBERRY(1.50), BANANA(1.00), PINEAPPLE(3.00), APPLE(1.50), PEACH(1.50), ORANGE(1.00), LEMON(0.75), LIME(0.50), PEAR(2.00), BLUEBERRY(1.50), YOGURT(1.00), ICE(0.00), PROTEIN(1.00), SPINACH(1.50);
	
    private final double price; // in money
    IngredientTypes(double price) {
        this.price = price;
    }
    public double getPrice() { return price; }
}
