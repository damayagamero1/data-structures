package hashTable; // Simple Class as simple as it gets with Builders, Setters and Getters.

public class Shelter {
private String name,location,ContactInfo;
private int capacity, availableBeds;

public Shelter() {
	name ="";
	location = "";
	ContactInfo = "";
	capacity = 0;
	availableBeds = 0;
}
public Shelter(String name, String loc,String info,int capacity, int beds) {
	this.name = name;
	this.location = loc;
	this.ContactInfo = info;
	this.capacity = capacity;
	this.availableBeds = beds;
}
public void setName(String a) {
	this.name = a;
}
public void setLocation(String a) {
	this.location = a;
}
public void setContact(String a) {
	this.ContactInfo = a;
}
public void setCapacity(int a) {
	this.capacity = a;
}
public void setBeds(int a) {
	this.availableBeds = a;
}
public String getName() {
	return this.name;
}
public String getLocation() {
	return this.location;
}
public String getContact() {
	return this.ContactInfo;
}
public int getCapacity() {
	return this.capacity;
}
public int getBeds() {
	return this.availableBeds;
}
@Override
public String toString() { // Method to return a formatted string representation of the shelter object
	return String.format(
		"Shelter Details:\n" +
		"----------------\n" +
		"Name: %s\n" +
		"Location: %s\n" +
		"Contact Info: %s\n" +
		"Capacity: %d\n" +
		"Available Beds: %d\n",
		this.name, this.location, this.ContactInfo, this.capacity, this.availableBeds
	);
}
}
