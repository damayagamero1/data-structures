package linkedListClass;

public class DALinkedList<e> implements LinkedListInt<e> {
	
	// We need to create nodes, so we create a node class
	private class Node<f>{
		private f data;			//Data at the node
		private Node<f> next;	// The link to the next node
		
		// Constructors to create the Node
		// THis constructor creates a node with data next reference
		public Node(f data, Node<f> next) {
			this.data = data;
			this.next = next;
		}
		// Constructor to create a node with only data, no next reference
		public Node(f data) {
			this(data, null);
		}
	}
	// Data and Methods for the LinkedList
	private Node<e> head;
	private int size;
	// Constructors for the  LinkedList
	public DALinkedList() {
		this.head = new Node<e>(null);
		// The head has no data, or next value at the beginning
		this.size = 0;
	}
	@Override
	public void add(int index, e item) {
		// this method adds an element to the LL
		// Depending on the index, it will use addFirst() or 
		// addAfter methods
		
		// Always check the validity of index
		if(index < 0||index > size) {
			System.out.println("Invalid index! ");
			return;
		}
		else if (index == 0) {
			addFirst(item);
		}
		else {
			Node<e> node = getNode(index);
			addAfter(node,item);
		}
		
	}
	private void addFirst(e item) {
		// We create a node with item as data, and head.next as next, wich is basically
		// copying the head.next value into the next reference of the node
		Node<e> temp = new Node<e>(item, head.next);
		head.next = temp;
		size++;
	}
	private void addAfter(Node<e> node,e item) {
		// add the item after the reference "node"
		node.next = new Node<e>(item,node.next);
		size++;
	}
	private DALinkedList<e>.Node<e> getNode(int index){
		// need to check the validity of the index
		if (index < 0|| index > this.size) {
			System.out.println("Invalid index!");
			return null;
		}
		// this method loops over the LL, and returns the reference of the node at index
		Node<e> node = head;
		for (int i = 0; i < index && node!= null; i++) {
			node = node.next;
		}
		return node;
	}

	@Override
	public void add(e item) {
		// This add method, inserts an element at the end of the list
		// Instead of the implementing this entire method, we can make use
		// of the other add(in index, e item) method 
		// to add at thge end , is equivalent to index == size
		add(size, item);
	}

	@Override
	public e remove(int index) {
		// This method removes an element form the Ll at given index
		// any time we work with index we check validity
		if (index< 0||index>size) {
			System.out.println("Invalid Index!");
			
		}
		else if (index==0)
		{
			return removeFirst();
		}
		else {
			Node<e> node = getNode(index);
			return removeAfter(node);
		}
		return null;
	}

	private e removeAfter(Node<e> node) {
		//This method deletes the node after the given 

		Node<e>temp = node;
		if (temp!=null) {
			// update  the head with the head.next
			node.next = node.next.next;
			size--;
			return temp.data;
		}
		
		return null;
	}
	private e removeFirst() {
		// Delete the first Node
		// We move the head.reference to the second node, or null
		//Basically we copy ther value frome thhe next pointer inmto the header
		
		Node<e>temp = head;
		if (temp!=null) {
			// update  the head with the head.next
			head.next = head.next.next;
			size--;
			return temp.data;
		}
		
		return null;
	}
	@Override
	public e get(int index) {
		if (index < 0|| index > this.size) {
			System.out.println("Invalid index!");
			return null;
		}
		else 
		return getNode(index).next.data;
	}

	@Override
	public e set(int index, e newValue) {
		// TODO Auto-generated method stub
		if (index < 0|| index > this.size) {
			System.out.println("Invalid index!");
			return null;
		}
		else  
			return getNode(index).next.data = newValue ;
	}

	@Override
	public int size() {
		return this.size;
	}
	public String toString() {
		String s = "[";
		Node<e> p = head;
		if (p!=null) {
			while (p.next !=null) {
			//iterate over the node one by one
			s = s+ p.next.data +"->";
			p=p.next;
			}
		}
		s+= "]";
		return s;
	}

}
