package pantry;

public interface LinkedListInt <e>{
	// Method to add an element at an index
	public void add( int index, e item);
	public void add (e item); 	//adds at the end of the list
	public e remove(int index); // remove form a given index
	// Getters and Setters
	public e get(int index);	// get value at given index
	public e set(int index, e newValue); // update value
	// Get the size of the Linked List
	public int size();

}
