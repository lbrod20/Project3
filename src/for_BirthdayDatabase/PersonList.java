package for_BirthdayDatabase;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

public class PersonList {

	MyLinkedList<Person> list = new MyLinkedList<Person>();
	
	public PersonList() {
		
	}
	
	public boolean add(Person p) {
		if(!list.contains(p)) {
			list.add(p);
			return true;
		}
		return false;
	}
	
	public boolean addAlpha(Person p) {
		if(!list.contains(p)) {
			list.insertInOrder(p);
			return true;
		}
		return false;
	}
	
	public Person search(Person p) {
		if(list.contains(p)) {
			return p;
		}
		return null;
	}
	
	public String saveToFile(String fileName) {
		 String messageFromSave = "";
		 try {
		   ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(fileName));
		   for(int i = 0; i < list.size(); i++) {
			   oOS.writeObject(list.get(i));
		   }
		   oOS.flush();
		   oOS.close();
		 }catch(Exception e) {
		   messageFromSave = e.toString();
		 }
		  return messageFromSave;
	}

	public String loadFromFile(String fileName) {
		 String toReturn = ""; 
		 try{
		    ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(fileName));
		    while(oIS.available() > -1) {
		      Person fromFile = (Person)(oIS.readObject());
		      Person found = search(fromFile);
		      if(found == null) {
		        if(add(fromFile)) {
		            toReturn += fromFile + "\n";
		        }else {
		        	toReturn += fromFile + " not successfully added to DB.\n";
	            }
		      }else {
		        toReturn += found + " already in the DB.\n";
		      }
		    }
		   oIS.close();
		   }catch (EOFException eOF){
		   }
		   catch(Exception e) {
		      toReturn += e;
		   }
		   return toReturn;
	}
	
	public boolean delete(Name n) {
		Iterator<Person> iter = list.iterator();
		while(iter.hasNext()) {
			Person p = iter.next();
			if(p.getName().equals(n)) {
				iter.remove();
				return true;
			}
		}
		return false;
	}
	
	public String hasBirthdayOn(Date date) {
		String toReturn = "";
		for(Person p: list) {
			if(p.getDate() == date) {
				toReturn += p.toString();
				break;
			}
			toReturn += "Nobody has a birthday on that date.";
		}
		return toReturn;
	}

	public String printList() {
		return list.toString();
	}
	
	
	public String sortAlphab() {
		return printList();
	}
	
	
	public String sortChronol() {
		String toReturn = "";
		MyLinkedList<Person> myNewList = new MyLinkedList<>(new ChronoComparator());
		
		for(Person p: list) {
			myNewList.add(p);
		}
		myNewList.sort();
		
		for(Person p: myNewList) {
			toReturn += p.toString() + "\n";
		}
		
		return toReturn;
	}
	
	public String findPersonByName(Name name) {
		for(Person p: list) {
			if(p.getName().equals(name)) {
				return p.toString();
			}
		}
		return "Person was not found";
	}
	
	
	
	
	
}
