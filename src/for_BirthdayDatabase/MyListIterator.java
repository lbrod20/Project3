package for_BirthdayDatabase;

import java.util.Iterator;

public class MyListIterator<E extends Comparable<E>> implements Iterator<E> {
	
	private MyLinkedList<E> ml;
	private Object element;
	private int index;
	private boolean removeGotCalled;

	public MyListIterator(MyLinkedList<E> thelist) {
		ml = thelist;
		if(thelist.size() == 0) {
			element = null;
		}else {
			element = ml.get(0);
		}
		index = 0;
		removeGotCalled = false;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return element != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E next() {
		// TODO Auto-generated method stub
		Object toReturn = element;
		index++;
		try {
			element = ml.get(index);
		}catch(IndexOutOfBoundsException e) {
			element = null;
		}
		removeGotCalled = false;
		return (E)toReturn;
	}
	
	public void remove() {
		removeGotCalled = true;
		if(index == 0) {
			throw new IllegalStateException();
		}
		ml.remove(ml.get(index -1));
		index --;
	}

}
