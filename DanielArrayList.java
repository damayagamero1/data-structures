package arrayListClass;

public class DanielArrayList<E> implements BareBonesArrayList<E> 
{
	// Data
	private int size; // how many elements are in the array list 
	private int capacity; // how big is the array?
	private E[] myArray;  // reference to the actual array, yet to be created
	private static final int INITIAL_CAPACITY = 10; // default capacity
	
	// Constructors
	public DanielArrayList()
	{
		// this constructor creates an array with default capacity
		this.capacity = this.INITIAL_CAPACITY;
		this.size = 0;
		myArray =(E[]) new Object[this.capacity];// this creates the actual array
	}
	public DanielArrayList(int x)
	{
		this.capacity = x;
		this.size = 0;
		myArray = (E[]) new Object[this.capacity];
	}
	@Override
	public void add(E a) {
		// this method will add an element to the end of the list
		// First we need to check if there is space to add an element
		if (this.size<this.capacity)
		{
			//this means there is space
			// the index where we can insert the data is given by size
			myArray[this.size]=a;
			this.size++;
		}
		else {
			//there is no space in my array
			// we need to call reallocate() method
			System.out.println("Sorry, no more space available");
			// Now Call reallocate
			this.reallocate();
			this.add(a); // once reallocate provides the space, call add again.
		}
		
	}

	private void reallocate() 
	{
		this.capacity *= 2;
		E[] temp = (E[]) new Object[this.capacity];
		for (int i = 0;i<myArray.length;i++)
		{
			temp[i]=myArray[i];
		}
		this.myArray = temp;
	}
	@Override
	public void add(E a, int index) {
		//this add method, inserts element at given index
		//first thing we need to do is check the validity of the index
		if (index < 0||index > size)
			System.out.println("Invalid index! Cannot insert data here! ");
		else if (index == size )
			this.add(a);
		else 
		{
			//check if there is space available to shift, else call realocate
			if(this.size == this.capacity)
				{
					this.reallocate();
				}
			else 
			{
				//once reallocate is done, now we have space to sift the elements
				for (int i = size; i > index ; i--)
				{
					this.myArray[i] = this.myArray[i-1];
				}
				this.myArray[index]=a;
				this.size++;
			}
		}
	}

	@Override
	public E remove(int index) {
		// this method will delelete and return the element at given index
		// check validity
		if (index <0||index>=this.size) {
			System.out.println("Cannot remove Data Invalid index");
			return null;
		}
		E returnElement = this.myArray[index];
		for (int i = index; i < this.size -1 ;i++)
		{
			this.myArray[i]= this.myArray[i+1];
		}
		this.size--;
		return returnElement;
	}

	@Override
	public E get(int index) {
		if (index <0||index>=this.size) {
			System.out.println("Cannot remove Data Invalid index");
			return null;
		}
		return this.myArray[index];
	}

	@Override
	public void set(E a, int index) {
		if (index <0||index>=this.size) {
			System.out.println("Cannot remove Data Invalid index");
		}
		this.myArray[index] = a;
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public int indexOf(E a) {
		for (int i = 0; i< this.size;i++)
		{
			if (this.myArray[i]==a)
				return i;
		}
		System.out.println("Element not found");
		return -1;
	}
	
	public String toString()
	{
		String s="";
		//we iterate over the array, add all the elements to the string
		for (int i = 0; i <this.size;i++) 
		{
			s=s+myArray[i]+", ";
		}
		return s;
	}

}
