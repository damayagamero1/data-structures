package linkedListClass;

public class LinkedListDriver {

	public static void main(String[] args) {
		// create LL object
		DALinkedList <Integer> List = new DALinkedList<Integer>();
		
		System.out.println(List);
		List.add(0,12);System.out.println(List);
		List.add(1,24);System.out.println(List);
		List.add(0,36);System.out.println(List);
		List.add(48);System.out.println(List);
		List.add(1,50);System.out.println(List);
		List.remove(0);;System.out.println(List);
		System.out.println(List.get(0));
		System.out.println(List.get(1));
		System.out.println(List.get(2));
		System.out.println(List.get(3));
		List.set(0, 10);System.out.println(List);
		List.equals(List);
	}

}
