package fruit;

public class PitFruit extends Fruit implements Pittable {

	public PitFruit(String name, int quantity, boolean isOrganic) {
		super("peach", quantity, isOrganic);
	}
	boolean isPit = true;
	@Override
	public void pit() {
		if(isPit){
			isPit = false;
		}
	}
	
	@Override
	public boolean hasPit() {
	 return isPit;
	}

}
