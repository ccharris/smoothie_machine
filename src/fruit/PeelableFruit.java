package fruit;

public class PeelableFruit extends Fruit implements Peelable{
	public PeelableFruit(String name, int quantity, boolean isOrganic){
		super(name, quantity, isOrganic);
	}

	boolean peeled;
	@Override
	public void peel() {
		if(!peeled){
			peeled = true;
		}else {
		}
		
	}
	@Override
	public boolean isPeeled() {
		return peeled;
	}
}
