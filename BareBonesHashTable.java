package hashTable;

public interface BareBonesHashTable<K,V> {
	public int hashFunction(K key);
	public void insertItem(K key,V data);
	public void deleteItem(K key,V data);
	public V get(K key);
	public boolean isEmpty();
	public void displayHash();

}
// This interface defines the basic operations for a hash table, including methods for inserting, deleting, and retrieving items, as well as checking if the table is empty and displaying its contents.
// The hashFunction method is used to compute the hash value for a given key, while the insertItem and deleteItem methods are used to add and remove items from the table, respectively.
