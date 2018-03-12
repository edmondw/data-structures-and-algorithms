package structures.deque;

import java.util.LinkedList;

public class LinkedListDeque<E> implements Deque<E> {
	LinkedList<E> list = new LinkedList<>();
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void addFirst(E e) {
		list.addFirst(e);
	}

	@Override
	public void addLast(E e) {
		list.addLast(e);
	}

	@Override
	public E removeFirst() {
		if (isEmpty()) return null;
		return list.removeFirst();
	}

	@Override
	public E removeLast() {
		if (isEmpty()) return null;
		return list.removeLast();
	}

	@Override
	public E peekFirst() {
		if (isEmpty()) return null;
		return list.getFirst();
	}

	@Override
	public E peekLast() {
		if (isEmpty()) return null;		
		return list.getLast();
	}

	@Override
	public void print() {
		System.out.println("TOP" + list.toString());
	}
}
