package for_BirthdayDatabase;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Comparable<Person>, Serializable{

	private Name name;
	private Date date;
	private static int numPeople = 0;
	
	public Person(Name name, Date date) {
		this.name = name;
		this.date = date;
		numPeople++;
	}
	
	public Person(String first, String last, Month theMonth, int theDay, int theYear) {
		this.date = new Date(theMonth, theDay, theYear);
		this.name = new Name(first, last);
		numPeople++;
	}

	public Name getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

	public static int getNumPpl() {
		return numPeople;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(date, other.date) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return name.toString() + " - " + date.toString(); 
	}

	@Override
	public int compareTo(Person other) {
		// TODO Auto-generated method stub
		return name.compareTo(other.name);
		
	}
	
	
	
	
}
