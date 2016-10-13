package fruit;

public class OtherIngredients implements Food {
	String name;
	int quantity;
	boolean isOrganic;
	
	public OtherIngredients(String name, int quantity, boolean isOrganic){
		this.name = name;
		this.quantity = quantity;
		this.isOrganic = isOrganic;
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void canEat() {
		
	}

	@Override
	public void getAllInfo() {
		System.out.println("This ingredient is " + name + " has " + quantity + " of them");
	}

	@Override
	public boolean getOrganic() {
		return isOrganic;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

}
