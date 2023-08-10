package for_BirthdayDatabase;
import java.util.Comparator;
import java.util.Iterator;

public class MyLinkedList<E extends Comparable<E>> implements Iterable<E> {

	private Node<E> myHead;
	private int size;
	private Comparator<E> myComparator;
	
	public MyLinkedList() {
		myHead = null;
		size = 0;
	}
	
	public MyLinkedList(Comparator<E> theComparator) {
		myHead = null;
		size = 0;
		myComparator = theComparator;
	}
	
	public void add(E data) {
		Node<E> n = new Node<E>(data);
		if(myHead == null) {
			myHead = n;
			size ++;
			return;
		}
		Node<E> mover = myHead;
		while(mover.getMyLink() != null) {
			mover = mover.getMyLink();
		}
		mover.setMyLink(n);
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		String toReturn = "";
		Node<E> mover = myHead;
		while(mover != null) {
			toReturn += mover.getMyData() + "\n";
			mover = mover.getMyLink();
		}
		if(size == 0) {
			return "List is empty";
		}
		return toReturn;
	}
	
	public void addFirst(E data) {
		Node<E> n = new Node<>(data);
		n.setMyLink(myHead);
		myHead = n;
		size++;
	}
	
	public E get(int index) {
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException(index + " is out of bounds.");
		}
		Node<E> mover = myHead;
		for(int i = 0; i < index; i++) {
			mover = mover.getMyLink();
		}
		return mover.getMyData();
	}
	
	public void set(int index, E data) {
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException(index + " is out of bounds.");
		}
		Node<E> mover = myHead;
		for(int i = 0; i < index; i++) {
			mover = mover.getMyLink();
		}
		mover.setMyData(data);
	}
	
	public boolean remove(Object data) {
		if(myHead == null) {
			return false;
		}
		
		if(myHead.getMyData().equals(data)) {
			myHead = myHead.getMyLink();
			size--;
			return true;
		}
		
		Node<E> first = myHead;
		Node<E> second = myHead.getMyLink();
		
		while(second != null) {
//			for(int i = 0; i > size; i++) {
			if(second.getMyData().equals(data)) {
				first.setMyLink(second.getMyLink());
				size--;
				return true;
			}else {
				first = second;
				second = second.getMyLink();
			}
		}
		
		return false;
	}
	
	private int myCompare(E first, E second) {
		if(myComparator == null) {
			return first.compareTo(second);
		}
		return myComparator.compare(first, second);
	}
	
	public void add(int index, E data) {
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException(index + " is out of bounds.");
		}
		if(index == 0) {
			addFirst(data);
			return;
		}
		Node<E> n = new Node<>(data);
		Node<E> mover = myHead;
		for(int i = 0; i < index-1; i++) {
			mover = mover.getMyLink();
		}
		n.setMyLink(mover.getMyLink());
		mover.setMyLink(n);
		size++;
	}
	
	public void insertInOrder(E data) {
		Node<E> mover = myHead;
//		Node<E> n = new Node<E>(data);
		int index = 0;
		if(mover == null) {
			add(data);
			return;
		}else {
			while(mover != null && myCompare(mover.getMyData(), data) < 0) {
				mover = mover.getMyLink();
				index++;
				System.out.println(index);
			}
		}
		if (index == size) {
			add(data);
		}else {
			System.out.println("hello");
			add(index, data);
		}
	}
	
	public boolean contains(E data) {
		Node<E> mover = myHead;
		for(int i = 0; i < size-1; i++) {
			if(mover.getMyData().equals(data)) {
				return true;
			}else {
				mover = mover.getMyLink();
			}
		}
		return false;
	}
	
	public Node<E> getMiddle(Node<E> myHead){
		Node<E> slow = myHead;
		Node<E> fast = myHead;
		while(fast.getMyLink() != null && fast.getMyLink().getMyLink() != null) {
			slow = slow.getMyLink();
			fast = fast.getMyLink().getMyLink();
		}
		return slow;
	}
	
	public Node<E> merge(Node<E> a, Node<E> b){
		Node<E> result = null;
		if(a == null) {
			return b;
		}
		if(b == null) {
			return a;
		}
		if(myCompare(a.getMyData(), b.getMyData()) <= 0) {
			result = a;
			result.setMyLink(merge(a.getMyLink(), b));
		}else {
			result = b;
			result.setMyLink(merge(a, b.getMyLink()));
		}
		return result;
	}
	
	public Node<E> mergeSort(Node<E> h){
		if(h == null || h.getMyLink() == null) {
			return h;
		}
		Node<E> middle = getMiddle(h);
		Node<E> nextToMiddle = middle.getMyLink();
		middle.setMyLink(null);
		Node<E> left = mergeSort(h);
		Node<E> right = mergeSort(nextToMiddle);
		Node<E> sortedlist = merge(left, right);
		return sortedlist;
	}
	
	public void sort() {
		myHead = this.mergeSort(myHead);
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new MyListIterator<E>(this);
	}
	
}

