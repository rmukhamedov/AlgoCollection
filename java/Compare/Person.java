public class Person implements Comparable<Person>
{
	private int id;
	private String name;
	private String street;
	private String city;
	private String state;
	private String phoneNumber;
	
	public Person(int num, String n, String s, String c, String st, String p){
		id = num;
		name = n;
		street = s;
		city = c;
		state = st;
		phoneNumber = p;
	}
	
	public Person(String n){
		id = 0;
		name = n;
		street = null;
		city = null;
		state = null;
		phoneNumber = null;
	}
	
	public Person(int n){
		id = n;
		name = null;
		street = null;
		city = null;
		state = null;
		phoneNumber = null;
	}
	
	public String toString(){
		return id + " " + name + " " + street + " " + city + " " + state + " " + phoneNumber;
	}
	
	public int getID(){
		return id;
	}
	
	public int compareTo(Person person){
		return name.compareTo(person.name);
	}
}