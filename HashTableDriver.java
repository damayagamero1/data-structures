package hashTable; // Final Revision*

import java.util.Scanner;

public class HashTableDriver {
    public static Scanner input = new Scanner(System.in);
    public static final int SIZE = 20;
    public static DAHashTable<String, Shelter> Directory = new DAHashTable<>(SIZE);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Welcome to the Homeless Shelter Management System");
            System.out.println("-----------------------------------------------------");
            System.out.println("1. Add Shelter");
            System.out.println("2. Update Available Beds");
            System.out.println("3. Search Shelter");
            System.out.println("4. Exit");
            System.out.print("Enter your Choice: ");

            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Enter a number from 1 to 4:");
                input.next(); // discard invalid input
            }

            choice = input.nextInt();
            while (choice < 1 || choice > 4) {
                System.out.println("Please place a valid input:");
                choice = input.nextInt();
            }
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addShelter();
                    break;
                case 2:
                    addBeds();
                    break;
                case 3:
                    searchShelter();
                    break;
                case 4:
                    break;
            }
        } while (choice != 4);

        System.out.println("Goodbye!");
    }

    private static void searchShelter() {
        System.out.println("Input the name of the Shelter:");
        String in = input.nextLine();
        Shelter shelter = Directory.get(in);
        if (shelter != null) {
            System.out.println(shelter);
        } else {
            System.out.println("Shelter not found.");
        }
    }

    private static void addBeds() {
        if (Directory.isEmpty()) {
            System.out.println("Directory is empty. Please add a shelter first.");
            return;
        }

        System.out.println("Input the name of the Shelter:");
        String in = input.nextLine();

        if (lookUp(in)) {
            Shelter shelter = Directory.get(in);
            System.out.print("How many beds are we adding to the shelter?: ");

            while (!input.hasNextInt()) {
                System.out.print("Enter a valid number of beds: ");
                input.next();
            }

            int additionalBeds = input.nextInt();
            input.nextLine(); // consume newline

            shelter.setBeds(shelter.getBeds() + additionalBeds);
            Directory.displayHash();
        } else {
            System.out.println("Shelter not found. Please add it first.");
        }
    }

    private static void addShelter() {
        System.out.println("Input the name of the Shelter:");
        String in = input.nextLine();

        if (Directory.isFull()) {
            System.out.println("Directory is full. Cannot add more shelters.");
            return;
        }

        if (!lookUp(in)) {
            Shelter shelter = createShelter(in);
            Directory.insertItem(in, shelter);
            Directory.displayHash();
        } else {
            System.out.println("Shelter already exists. Do you want to update available beds? \n1. Yes\n2. No");

            int p = input.nextInt();
            input.nextLine(); // consume newline

            while (p < 1 || p > 2) {
                System.out.print("Input a valid option (1 or 2): ");
                p = input.nextInt();
                input.nextLine();
            }

            if (p == 1) {
                addBeds();
            }
        }
    }

    private static Shelter createShelter(String name) {
        Shelter shelter = new Shelter();
        shelter.setName(name);

        System.out.print("Input Location: ");
        shelter.setLocation(input.nextLine());

        System.out.print("Input Capacity: ");
        while (!input.hasNextInt()) {
            System.out.print("Enter a valid number for capacity: ");
            input.next();
        }
        shelter.setCapacity(input.nextInt());
        input.nextLine(); // consume newline

        System.out.print("Input available beds: ");
        while (!input.hasNextInt()) {
            System.out.print("Enter a valid number of beds: ");
            input.next();
        }
        shelter.setBeds(input.nextInt());
        input.nextLine(); // consume newline

        System.out.print("Input Contact Information: ");
        shelter.setContact(input.nextLine());

        return shelter;
    }

    private static boolean lookUp(String key) {
        return Directory.get(key) != null;
    }
}


// got pass the first iteration of the code for adding an object didnt recognice the key due to misuse of 2D array format and unneeded complexity.
//package hashTable; 
//import java.util.Scanner;
//public class HashTableDriver {
//
//     public static Scanner input = new Scanner(System.in);   // Scanner object for user input
//     public static final int SIZE = 20;      // Size of the hash table
//     public static DAHashTable<String,Shelter> Directory = new DAHashTable<String,Shelter>(SIZE);    // Hash table to store shelters
//     public static void main(String[] args) {
//    	 int choice;     // Variable to store user choice
//    	 do {            // Loop until user chooses to exit
//    		 System.out.println("Welcome to the Homeless Shelter Management System");
//    		 System.out.println("-----------------------------------------------------");
//    		 System.out.println("1. Add Shelter");
//    		 System.out.println("2. Update Available Beds");
//    		 System.out.println("3. Search Shelter");
//    		 System.out.println("4. Exit");
//    		 System.out.print("Enter your Choice: ");
//    		 choice = input.nextInt();
//    		 while(choice<1||choice>4) {
//    			 System.out.println("Please Place a valid Input");
//    			 choice =input.nextInt();
//    			 }
//    		 input.nextLine();
//    		 switch (choice) {
//    		 case 1: addShelter();
//    		 break;
//    		 case 2: addBeds();
//    		 break;
//    		 case 3: searchShelter();
//    		 break;
//    		 case 4:
//    			 break;
//    			 }
//    		 }while(choice != 4);
//    	 System.out.println("Goodbye!");
//    	}
//     private static void searchShelter() {
//    	 // TODO Auto-generated method stub
//    	 System.out.println("Input the name of the Shelter: ");  // Prompt user for shelter name
//		String in = input.nextLine();    // Read shelter name from user input
//		Shelter shelter = Directory.get(in);
//		if (shelter != null) {
//			System.out.println(shelter);
//		} else {
//			System.out.println("Shelter not found.");
//		}
//     }
//
//     private static void addBeds() {
// 		// TODO Auto-generated method stub
// 		if (Directory.isEmpty()) {      // Check if Directory is empty
// 			System.out.println("Directory is empty. Please add a shelter first.");
// 			return;  // Exit the method if Directory is empty
// 		}
// 		else {
// 			System.out.println("Input the name of the Shelter: ");  // Prompt user for shelter name
// 			String in = input.nextLine();    // Read shelter name from user input
//
// 			// Check if the shelter exists in the Directory
// 			if (lookUp(in)) {     // Check if the shelter already exists in the Directory
// 				Shelter add = Directory.get(in);    // Retrieve the Shelter object from the Directory
// 				System.out.print("\nHow many beds are we adding to the shelter?: ");
// 				add.setBeds(add.getBeds()+input.nextInt());   // Update available beds for the shelter
// 				input.nextLine(); // consume leftover newline
// 				Directory.displayHash();        // Display the contents of the Directory
// 			} else if (!lookUp(in)){
// 				System.out.println("Shelter not found. Please add it first.");
// 			}
// 		}
// 	}
//         private static void addShelter() {
//             System.out.println("Input the name of the Shelter: ");  // Prompt user for shelter name
//             String in = input.nextLine();
//
//             // Handle case when Directory is empty
//             if (Directory.isEmpty()) {      // Check if Directory is empty
//                 System.out.println("Directory is empty. Adding first shelter");
//                 Shelter add = createShelter(in);    // Create a new Shelter object
//                 Directory.insertItem(in, add);  // Insert the shelter into the Directory
//                 Directory.displayHash();        // Display the contents of the Directory
//                 }
//             if (Directory.isFull()) {       // Check if Directory is full
//     			System.out.println("Directory is full. Cannot add more shelters.");
//     			return;  // Exit the method if Directory is full
//     		}
//             // If shelter doesn't exist, add it
//             else if (!lookUp1(in)) {     // Check if the shelter already exists in the Directory
//                 Shelter add = createShelter(in);
//                   Directory.insertItem(in, add);
//                  Directory.displayHash();
//              }
//              // Shelter exists, ask if user wants to update available beds
//              else if (lookUp1(in)){
//                   System.out.println("Shelter already added. Are there any changes to the amount of beds? \n1. Yes\n2. No");
//                     int p = input.nextInt();
//                   input.nextLine(); // consume leftover newline
//                    while (p < 1 || p > 2) {
//                       System.out.print("\nInput a valid option: ");
//                       p = input.nextInt();
//                       input.nextLine(); // consume leftover newline
//                       }
//                    if (p == 1) {
//                    	addBeds();
//                    	}
//                    }
//             }
//
//      // Helper method to create Shelter and gather inputs
//        private static Shelter createShelter(String name) {
//            Shelter add = new Shelter();
//             add.setName(name);
//
//             System.out.print("\nInput Location: ");
//            add.setLocation(input.nextLine());
//
//             System.out.print("\nInput Capacity: ");
//             add.setCapacity(input.nextInt());
//             input.nextLine(); // consume leftover newline
//
//             System.out.print("\nInput available beds: ");
//             add.setBeds(input.nextInt());
//             input.nextLine(); // consume leftover newline
//
//            System.out.print("\nInput Contact Information: ");
//             add.setContact(input.nextLine());
//
//             return add;
//         }
//
//         private static boolean lookUp1(String key) {
//               // Check if the shelter exists in the Directory
//           
//             System.out.print(key);
//             return key != null && key.equals(key);
//         }
//
//private static boolean lookUp(String key) {
//    Shelter shelter = (Shelter) Directory.get(key);
//    if (shelter != null && shelter.getName().equals(key)) {
//        System.out.print(shelter);
//    }
//    return shelter != null;
//}
//}

//First Revision, ArrayList Bad Idea, Key to Object logistic confusion.

//import java.util.Scanner;
//public class HashTableDriver {
//
//	public static Scanner input = new Scanner(System.in);   // Scanner object for user input
//	public static final int SIZE = 20;      // Size of the hash table
//	public static DAHashTable<String,Shelter> Directory = new DAHashTable<String,Shelter>(SIZE);    // Hash table to store shelters
//	public static void main(String[] args) {
//		int choice;     // Variable to store user choice
//		do {            // Loop until user chooses to exit
//		System.out.println("Welcome to the Homeless Shelter Management System");
//		System.out.println("-----------------------------------------------------");
//		System.out.println("1. Add Shelter");
//		System.out.println("2. Update Available Beds");
//		System.out.println("3. Search Shelter");
//		System.out.println("4. Exit");
//		System.out.print("Enter your Choice: ");
//		choice = input.nextInt();
//		while(choice<1||choice>4) {
//			System.out.println("Please Place a valid Input");
//			choice =input.nextInt();
//		}
//		input.nextLine();
//		switch (choice) {
//		case 1: addShelter();
//			break;
//		case 2:	addBeds();
//			break;
//		case 3: searchShelter();
//			break;
//		case 4:
//			break;
//		}
//		}while(choice != 4);
//		System.out.println("Goodbye!");
//	}
//	private static void searchShelter() {       
//		// TODO Auto-generated method stub
//		
//	}
//	private static void addBeds() {
//		// TODO Auto-generated method stub
//		
//	}
//	private static void addShelter() {  
//	    System.out.println("Input the name of the Shelter: ");  // Prompt user for shelter name
//	    String in = input.nextLine();
//
//	    // Handle case when Directory is empty
//	    if (Directory.isEmpty()) {      // Check if Directory is empty
//	        System.out.println("Directory is empty. Adding first shelter...");
//	        Shelter add = createShelter(in);    // Create a new Shelter object
//	        Directory.insertItem(in, add);  // Insert the shelter into the Directory
//	        Directory.displayHash();        // Display the contents of the Directory
//	    } 
//	    // If shelter doesn't exist, add it
//         if (!lookUp(in)) {     // Check if the shelter already exists in the Directory
//                    Shelter add = createShelter(in);    
//                    Directory.insertItem(in, add);  
//                    Directory.displayHash();
//                } 
//                // Shelter exists, ask if user wants to update available beds
//                else {
//                    System.out.println("Shelter already added. Are there any changes to the amount of beds? \n1. Yes\n2. No");
//                    int p = input.nextInt();
//                    input.nextLine(); // consume leftover newline
//                    while (p < 1 || p > 2) {
//                        System.out.print("\nInput a valid option: ");
//                        p = input.nextInt();    
//                        input.nextLine(); // consume leftover newline
//                    }
//                    if (p == 1) {
//                        addBeds();
//                    }
//                }
//	}
//
//	// Helper method to create Shelter and gather inputs
//	private static Shelter createShelter(String name) { 
//	    Shelter add = new Shelter();    
//	    add.setName(name);
//
//	    System.out.print("\nInput Location: ");
//	    add.setLocation(input.nextLine());
//
//	    System.out.print("\nInput Capacity: ");
//	    add.setCapacity(input.nextInt());
//	    input.nextLine(); // consume leftover newline
//
//	    System.out.print("\nInput available beds: ");
//	    add.setBeds(input.nextInt());
//	    input.nextLine(); // consume leftover newline
//
//	    System.out.print("\nInput Contact Information: ");
//	    add.setContact(input.nextLine());
//
//	    return add;
//	}
//
//	private static boolean lookUp(String key) {
//                // Check if the shelter exists in the Directory         
//	    int  = Directory.get(key);       
//	    System.out.print(shelter);  
//	    return shelter != null && shelter.getName().equals(key);    
//	}
//}