package arrayListClass;

public interface BareBonesArrayList<E> {
	// List All method of an array List
	public void add (E a); // adds an element at the end  of the list
	public void add (E a, int index); // adds an element on specific index
	public E remove(int index); // 
	public E get(int index);
	public void set (E a, int index);
	public int getSize();
	public int indexOf(E a);

}
