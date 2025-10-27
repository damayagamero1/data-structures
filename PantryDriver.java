package pantry;
import java.util.Scanner;
public class PantryDriver {

	public static Scanner input = new Scanner (System.in);
	public static int menuVal;
	public static DALinkedList<PantryItems> Pantry = new DALinkedList<PantryItems>(); 
	
	public static void main(String[] args) {
		// main menu display
		do {
		System.out.println("   Welcome to your Pantry Management System");
		System.out.println("----------------------------------------------");
		System.out.println("1. Add Item");
		System.out.println("2. Distribute Item");
		System.out.println("3. Search Item");
		System.out.println("4. Exit");
		System.out.print("Enter your choice: ");
		menuVal = input.nextInt();// input for menu method
		while(menuVal < 1 ||menuVal > 4 ) {// input validation
			System.out.print("\nInput a valid option: ");
			menuVal = input.nextInt();
		}
		menuVal = Menu(menuVal); // this method will take the input value and pass it by the prompted case
		}while(menuVal!=4);

	}
	public static int Menu(int x) {
		switch (x)
		{
		case 1:{
				addItem();
			break;
			}
		case 2:{
			disItem();
			break;
		}
			
		case 3:{
			searchItem();
			break;
		}

		case 4:
			System.out.println("Have a Good Day");
			break;
		}
		return x;
		
	}
		
	private static void searchItem() {
		// this method utilizes linear search in order to find the String that is needed;
		System.out.print("\nEnter Item Name: ");
		boolean check = false; // it utilizes a Boolean Counter to identify if the value is present or not
		String search =input.next();
		for(int i = 0; i< Pantry.size();i++) {
		if (search.equalsIgnoreCase(Pantry.get(i).getItem())) { 			
			System.out.println(Pantry.get(i));
			check=true;
		}
		else check = false;
		}
		if (!check)
			System.out.println("Item Not Found");
			
	}
	private static void disItem() {
		System.out.print("\nEnter Item Name: ");
		int index=-1;
		String search =input.next();
		System.out.print("\nEnter quantity: ");
		int dis = input.nextInt();
		// it utilizes the same concept as the searchItem() but it stores the index value.
		for(int i = 0; i< Pantry.size();i++) {
		if (search.equalsIgnoreCase(Pantry.get(i).getItem())) {
			index = i;
		}
			
		}
		if (index==-1)// it utilizes the index value to measure if the item is at all in the list
			System.out.println("Item Not Found");
		// and afterwards is checked to make sure the stash value is equal or hier than the one 
		// been prompted by the input
		else {
			if (Pantry.get(index).getStash()<dis) {
				System.out.println("Request exceeds abailable inventory");
			}
			// once everything is clear we can now we get the difference form Pantry.get(index).getStash()-z.
			else {
			Pantry.get(index).setStash(Pantry.get(index).getStash()-dis);
			System.out.println("You have distributed "+dis+" "+search+". "); // and then we print.
			}
		}
	
	}
	// revised code only change added a Boolean counter to avoid over adding values into the linked list.
		// this code has been revised with chat GPT in order to fix a bug i wasn't able to find.
		private static void addItem() {
		    PantryItems newItem = new PantryItems();
		    System.out.print("\nEnter Item Name: ");
		    newItem.setItem(input.next());

		    System.out.print("\nEnter quantity: ");
		    newItem.setStash(input.nextInt());


		    boolean found = false;// chat gpt added a boolean counter;

		    for (int i = 0; i < Pantry.size(); i++) {
		        if (newItem.getItem().equalsIgnoreCase(Pantry.get(i).getItem())) {
		            Pantry.get(i).setStash(Pantry.get(i).getStash() + newItem.getStash());
		            found = true;
		            break; // Once found and updated, no need to continue
		        }
		    }

		    if (!found) {// to get the Pantry.add(newItem) out of the loop which was giving me the bug.

			    System.out.print("\nEnter Expiration Date (YYYY-MM-DD): ");
			    newItem.setExpDate(input.next());
		        Pantry.add(newItem);
		    }

		    System.out.println("Item added successfully! ");
	// original method
	/*private static void addItem() {
		// This method will first ask for all inputs and then create an Pantry object, then we will compare the 
		//name of all data stored in the Linked List until input == data or we reach the end of the Linked list
		// at which pint we add a new node.
		PantryItems newItem = new PantryItems();// create a new object to interact with
		System.out.print("\nEnter Item Name: ");
		newItem.setItem(input.next());			// input the data
		System.out.print("\nEnter quantity: ");
		newItem.setStash(input.nextInt());
		System.out.print("\nEnter Expiration Date (YYYY-MM-DD) : ");
		newItem.setExpDate(input.next());
		if (Pantry.size()==0)  // tried to make it work with the size of the array list first i was not able to make it work
			Pantry.add(newItem);
		for(int i = 0;i< Pantry.size();i++) { // the analysis for existing objects on the array list needs to be done with 
		// two specific pointers one as the newItem.getStash() which we are comparing and the Pantry.get(i).getItem();
		if (newItem.getItem().equalsIgnoreCase(Pantry.get(i).getItem())) {
			Pantry.get(i).setStash(Pantry.get(i).getStash()+newItem.getStash());
		}
	}
System.out.println("Item Added Successfully!");	
}*/
	
	}
}

