package arrayListClass;

public class ArrayListDemo {

	public static void main(String[] args) 
	{
		//Create an object of array list class and test 
		DanielArrayList<Integer> list = new DanielArrayList<Integer>(4);
		System.out.println(list);
		for (int i = 0; i<20;i++)
			list.add(i+1);
		System.out.println(list);
		list.remove(0);
		list.add(20, 0);
		System.out.println(list.indexOf(22));
		System.out.println(list.indexOf(10));
		System.out.println(list.getSize());
		list.set(9, 16);
		System.out.println(list);
	}

}
