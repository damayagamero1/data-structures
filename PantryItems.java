package linkedListClass;

public class PantryItems {
	private String name,date;
	private int stash;
	public PantryItems()
	{
		name = "";
		date = "";
		stash = 0;
	}
	public PantryItems(String item, String exp, int quantity) {
		name = item;
		date = exp;
		stash = quantity;
	}
	public void setItem(String a) {
		this.name = a;
	}
	public String toString() {
		String s = "Item: "+name+"/nQuantity: "+stash+"/n Expiration Date: "+ date;
		return s;
	}
}
