package for_BirthdayDatabase;

public class Node<E> {

	private E myData;
	private Node<E> myLink;
	
	public Node(E theData) {
		myData = theData;
		myLink = null;
		
	}

	public E getMyData() {
		return myData;
	}

	public void setMyData(E myData) {
		this.myData = myData;
	}

	public Node<E> getMyLink() {
		return myLink;
	}

	public void setMyLink(Node<E> myLink) {
		this.myLink = myLink;
	}

	@Override
	public String toString() {
		return "Hello, I'm " + myData;
	}
	
}
