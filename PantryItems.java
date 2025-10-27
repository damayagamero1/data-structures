package pantry;

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
	//Setters
	public void setItem(String a) {
		this.name = a;
	}
	public void setExpDate(String a ) {
		this.date = a;
	}
	public void setStash (int a) {
		this.stash=a;
	}
	//Getters
	public String getItem() {
		return this.name;
	}
	public String getExpDate() {
		return this.date;
	}
	public int getStash () {
		return this.stash;
	}
	//ToString
	public String toString() {
		String s = "Item: "+name+", Quantity: "+stash+", Expiration Date: "+ date;
		return s;
	}
}
