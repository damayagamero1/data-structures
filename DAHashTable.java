package hashTable; // Final Revision* Created with Two tables instead of a single 2D array for ease of execution.
public class DAHashTable<K, V> {
    private int capacity;
    private int size;
    private K[] keys;
    private V[] values;

    public DAHashTable(int cap) {
        this.capacity = cap;
        keys = (K[]) new Object[cap];
        values = (V[]) new Object[cap];
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void insertItem(K key, V value) {
        if (isFull()) {
            System.out.println("Hash table is full. Cannot insert.");
            return;
        }

        int index = hash(key);
        while (keys[index] != null && !keys[index].equals(key)) {
            index = (index + 1) % capacity;
        }

        if (keys[index] == null) {
            size++;
        }

        keys[index] = key;
        values[index] = value;
    }

    public V get(K key) {
        int index = hash(key);
        int startIndex = index;

        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];
            }
            index = (index + 1) % capacity;
            if (index == startIndex) break; // Avoid infinite loop
        }

        return null;
    }

    public void displayHash() {
        System.out.println("\n--- Current Directory ---");
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                System.out.println("Index " + i + ": " + keys[i] + " -> " + values[i]);
            } else {
                System.out.println("Index " + i + ": empty");
            }
        }
        System.out.println("-------------------------\n");
    }
}
//Second try, utilizing 2D tables, got some logistic problems with the key and Object, Revision added unneeded imports and mixed up my original structure, had to restart.

//package hashTable;
//
//import java.util.Arrays;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
//public class DAHashTable<K, E> implements BareBonesHashTable<K, E> {
//
//    private final int bucket; // Number of buckets
//    private int capacity = 0; // Current number of elements in the hashtable
//    // Array of arrays to store the elements in each bucket
//    private final E[][] table; // Array of arrays to store the elements ineach bucket
//
//    public DAHashTable(int numBuckets) { // Constructor to initialize the hash table with a specified number of buckets
//        if (numBuckets <= 0) {
//            throw new IllegalArgumentException("Number of buckets must bepositive.");
//        }
//        this.bucket = numBuckets;
//        this.table = (E[][]) new Object[bucket][];
//        for (int i = 0; i < bucket; i++) { // Initialize each bucket as an empty array
//            table[i] = (E[]) new Object[0];
//        }
//    }
//
//    @Override
//    public int hashFunction(K key) {
//        return Math.abs(key.hashCode() % bucket);
//    }
//
//    @Override
//    public void insertItem(K key, E data) {
//        if (key == null) {
//            throw new NullPointerException("Key cannot be null.");
//        }
//        int index = hashFunction(key);
//        E[] bucketArray = table[index];
//        E[] newArray = Arrays.copyOf(bucketArray, bucketArray.length + 1);
//        newArray[bucketArray.length] = data;
//        table[index] = newArray;
//        capacity++;
//    }
//
//    @Override
//    public void deleteItem(K key, E data) {
//        if (key == null) {
//            throw new NullPointerException("Key cannot be null.");
//        }
//        int index = hashFunction(key);
//
//        // Check if data exists in the list before attempting to remove
//        boolean found = false;
//        E[] bucketArray = table[index];
//        for (int i = 0; i < bucketArray.length; i++) {
//            if (bucketArray[i].equals(data)) {
//                // Remove the item from the array
//                E[] newArray = Arrays.copyOf(bucketArray,bucketArray.length - 1);
//                System.arraycopy(newArray, 0, bucketArray, 0, i);
//                System.arraycopy(newArray, i, bucketArray, i,bucketArray.length - i - 1);
//                table[index] = newArray;
//                capacity--;
//                found = true;
//                break;
//            }
//        }
//        if (!found) {
//            // If the item is not found, do nothing
//        }
//    }
//
//    @Override
//    public void displayHash() {
//        System.out.println("Hash Table Contents:");
//        for (int i = 0; i < bucket; i++) { // Iterate through each bucket
//            E[] bucketArray = table[i];
//            if (bucketArray.length == 0) { // Check if the bucket is empty
//                System.out.println(i + " --> Empty");
//                continue;
//            }
//            System.out.print(i);
//            for (E x : bucketArray) {
//                System.out.print(" --> " + x);
//            }
//            System.out.println();
//        }
//    }
//
//    @Override
//    public E get(K key) {
//        if (key == null) {
//            throw new NullPointerException("Key cannot be null.");
//        }
//        int index = hashFunction(key);  // Compute the index using the hash function
//        E[] bucketArray = table[index];
//        if (bucketArray.length == 0) { // Check if the bucket is empty
//            return null;  // Return null if the bucket is empty
//        }
//        for (E item : bucketArray) {
//            if (item.equals(key)) {
//                return item;
//            }
//        }
//        return null;  // Return null if key is not found
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return capacity == 0;
//    }
//
//	public boolean isFull() {
//		// TODO Auto-generated method stub
//		return capacity == this.table.length;
//	}
//}

// First Try Utilizing array List, over complicated just because of expanding buckets.
/*package hashTable;
import java.util.ArrayList;

public class DAHashTable<K, E> implements BareBonesHashTable<K, E> {

    private final int bucket;   // Number of buckets
    private int capacity = 0;   // Current number of elements in the hash table
    // Array of ArrayLists to store the elements in each bucket
    private final ArrayList<E>[] table; // Array of ArrayLists to store the elements in each bucket

    public DAHashTable(int x) { // Constructor to initialize the hash table with a specified number of buckets
        if (x <= 0) {
            throw new IllegalArgumentException("Number of buckets must be positive.");
        }
         // Initialize the number of buckets and create the array of ArrayLists
         // The array is initialized with the specified number of buckets, and each bucket is an empty ArrayList.
        this.bucket = x;
        this.table = new ArrayList[bucket];
        for (int i = 0; i < bucket; i++) {  // Initialize each bucket as an empty ArrayList 
            table[i] = new ArrayList<E>();
        }
    }

    @Override
    public int hashFunction(K key) {    
        int k = key.hashCode();
        System.out.println(k);
        return Math.abs(k % bucket); // Ensure the result is non-negative
    }

    @Override
    public void insertItem(K key, E data) {
        int index = hashFunction(key);
        table[index].addFirst(data); // Add the data to the beginning of the list at the computed index
        capacity++;
    }

    @Override
    public void deleteItem(K key, E data) {
        int index = hashFunction(key);
        
        // Check if data exists in the list before attempting to remove
        if (!table[index].contains(data)) { 
            return;
        }
        table[index].remove(data);
        capacity--;
    }

    @Override
    public void displayHash() { // Display the contents of the hash table
        System.out.println("Hash Table Contents:");
        for (int i = 0; i < bucket; i++) {  // Iterate through each bucket
            if (table[i].isEmpty()) { // Check if the bucket is empty
                System.out.println(i + " --> Empty");
                continue;
            }
            System.out.print(i);
            for (E x : table[i]) {
                System.out.print(" --> " + x);
            }
            System.out.println();
        }
    }

    @Override
    public K get() {   // Retrieve the value associated with the given key
        int index = hashFunction(key);  // Compute the index using the hash function
        if (table[index].isEmpty()) { // Check if the bucket is empty
            return null;  // Return null if the bucket is empty
        }
        for (E item : table[index]) {   // Iterate through the items in the bucket
            if (equals() {  // Check if the item matches the key
                return item;  // Return the item if it matches the key
            } else {
                System.out.println("Key not found in bucket " + index); // Print message if key is not found in the bucket
            }
        }
        return null;  // Return null if key is not found
    }

    @Override
    public boolean isEmpty() {
        return capacity == 0;
    }
}*/

